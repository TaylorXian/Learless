package org.xman.xland.scala.core.spark

import org.apache.spark.SparkConf
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.kafka.KafkaUtils
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  * Created by xiandeb on 16/12/6.
  */
object SparkStreamingApp {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("spark streaming app")
    val ssc = new StreamingContext(conf, Seconds(10))

    val zkQuorum = "localhost:2181"
    val groupId = "groupId"
    val topics = Map("topic" -> 4)
    val stream = KafkaUtils.createStream(ssc, zkQuorum, groupId, topics, StorageLevel.MEMORY_ONLY_SER_2)
    stream.repartition(10)
  }

}
