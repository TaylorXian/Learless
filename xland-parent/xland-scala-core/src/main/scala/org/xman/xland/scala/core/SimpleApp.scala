package org.xman.xland.scala.core

/**
 * Hello world!
 *
 */
object SimpleApp {
  val strings = Array("a,b,c,d,e,f,g,aa,bb,cc,dd,ee", "a,b,c,ee", "")
  def main(args: Array[String]): Unit = {
    strings.foreach(string => {
      println(string)
      val idx = stringLastIndexOf(string, ",", 4)
      println(idx)
      if (idx > -1)
        println(string.substring(0, idx))
    })
  }

  def stringLastIndexOf(string: String, search: String, lastNth: Int): Int = {
    var ss = string
    var idx = -1
    var ln = lastNth
    while (ln > 0) {
      idx = ss.lastIndexOf(search)
      if (idx < 0) return idx
      ln -= 1
      ss = ss.substring(0, idx)
    }
    return idx
  }
}
