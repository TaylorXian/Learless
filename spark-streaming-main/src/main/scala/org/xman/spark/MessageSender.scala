package org.xman.spark

import java.util.Properties

import kafka.producer.{KeyedMessage, Producer, ProducerConfig}

import scala.io.Source

/**
  * Created by xianjy on 2016/11/30.
  */
object MessageSender {

  val topic = "test"

  def main(args: Array[String]) {
    val properties = new Properties
    properties.put("metadata.broker.list", "10.19.12.51:9092")
    properties.put("serializer.class", "kafka.serializer.StringEncoder")
    properties.put("partitioner.class", "kafka.producer.DefaultPartitioner")
    properties.put("producer.type", "sync")

    val producer = new Producer[String, String](new ProducerConfig(properties))
    val key = (System.currentTimeMillis() % 4).toString()

    println(key)
    messages.foreach(m => {
      producer.send(new KeyedMessage[String, String](topic, key, m))
      Thread.sleep(30)
    })
//    Thread.sleep(20 * 1000)
//    println(messages.toList)

  }

  def messages: Iterator[String] = {
    Source.fromFile("D:/ebook/TheLilyoftheValley-HonoreDeBalzac.txt").getLines()
  }

}
