package org.xman.xland.scala.core.socket

import java.net.InetAddress
import java.net.Socket
import scala.io.BufferedSource
import java.io.PrintStream

object MyClient {
  val title = "Simple Client"
  val preferredSize = (500, 500)
  val socket = new Socket(InetAddress.getByName("localhost"), 19999)
  val in = new BufferedSource(socket.getInputStream).getLines
  val out = new PrintStream(socket.getOutputStream)
  println("Client initialized:")

  out.println("Hello!")
  out.flush()
  println("Client received: " + in.next)

  out.println("Disconnect")
  out.flush()
  socket.close
  def main(args: Array[String]): Unit = {
    
  }
}