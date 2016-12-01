package org.xman.xland.scala.core

import org.xman.xland.core.jdbc.PlainSQLiteJdbc

object SQLiteJdbcTest {
  def main(args: Array[String]): Unit = {
    val jdbcTest = new PlainSQLiteJdbc()
    jdbcTest.execute()
  }
}