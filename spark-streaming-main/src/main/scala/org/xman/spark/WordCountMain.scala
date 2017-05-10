package org.xman.spark

import com.typesafe.scalalogging.slf4j.LazyLogging
import org.apache.spark.SparkConf
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.dstream.ReceiverInputDStream
import org.apache.spark.streaming.kafka.KafkaUtils
import org.apache.spark.streaming.{Minutes, Seconds, StreamingContext}

import scala.collection.mutable

/**
  * Created by xianjy on 2016/11/29.
  */
object WordCountMain extends LazyLogging {

  val batchInterval = 20

  def main(args: Array[String]): Unit = {
    val Array(zkQuorum, group, topics, numThreads) = args
    val sparkConf = new SparkConf().setAppName("WordCountApp")

    val ssc = new StreamingContext(sparkConf, Seconds(batchInterval))
    ssc.checkpoint("checkpoint")

    logger.info(args.mkString(","))

    val topicMap = topics.split(",").map((_, numThreads.toInt)).toMap

    val dStream = KafkaUtils.createStream(ssc, zkQuorum, group, topicMap, StorageLevel.MEMORY_ONLY_SER_2)

//    KafkaUtils.createDirectStream

    dStream.mapPartitions(iter => {
      val tn = Thread.currentThread().getName + " mapPartitions: "
      val list = iter.toList
      println(tn + " iter.size ==: " + iter.size + " list.size ==: " + list.size)
      val buf = new mutable.ArrayBuffer[String]
      list.map(line => {
        val ws = line._2.split(" ")
        buf ++= ws
      })

      println(tn + buf)
      val m = mutable.HashMap.empty[String, Int]
      list.foreach(p => {
        val ws = p._2.split(" ")
        ws.foreach(w => {
          m.contains(w) match {
            case true => m(w) = m(w) + 1
            case _ => m(w) = 1
          }
        })
      })
      println(tn + m)
      list.iterator
    }).foreachRDD(rdd => {
      rdd.foreachPartition(partition => {
        val tn = Thread.currentThread().getName
        val list = partition.toList
        println(tn + "foreachRDD count:" + list.size)
        trans(list, tn)
        trans(list, tn)
      })
    })

    ssc.start()
    ssc.awaitTermination()
  }

  def trans(list: List[(String, String)], tn: String): Unit = {
    val buffer = new mutable.ArrayBuffer[String]
    buffer += System.currentTimeMillis().toString
    list.foreach(p => {
      buffer += p._2
    })
    println(tn + s"foreachRDD: ${buffer.##} " + buffer)
  }

  def count(dStream: ReceiverInputDStream[(String, String)]): Unit = {
    val words = dStream.map(_._2).flatMap(_.split(" "))
    val wordCounts = words.map(x => (x, 1L)).reduceByKeyAndWindow(_ + _, _ - _, Minutes(1), Seconds(batchInterval), 2)
    wordCounts.print()
  }

}
