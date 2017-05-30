package org.xman.xland.scala.core

import org.junit._
import Assert._

@Test
class AppTest {

  @Test
  def testOK() = {
    createMap()
    assertTrue(true)
  }

  def createMap(): Unit = {
    val m = Map("topic" -> 4)
    println(m)
  }
}


