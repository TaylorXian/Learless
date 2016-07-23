package org.xman.xland.scala.core.socket

import java.net.ServerSocket
import java.io.PrintStream
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

object MyServer {

  def main(args: Array[String]): Unit = {
    try {
      val server = new ServerSocket(19999);
      println("Server initialized.")
      val client = server.accept
      val in = new BufferedReader(new InputStreamReader(client.getInputStream)).readLine
      val out = new PrintStream(client.getOutputStream)
      println("Server received " + in)
      out.println("Message received")
      out.flush
      if (in.equals("Disconnect")) {
        client.close
        server.close
        println("Server closing")
      }
    }
    catch {
      case e: Exception => println(e.getStackTrace); System.exit(1)
    }
  }
}