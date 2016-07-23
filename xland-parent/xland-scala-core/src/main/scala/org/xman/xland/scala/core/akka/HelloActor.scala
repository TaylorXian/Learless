package org.xman.xland.scala.core.akka

import akka.actor.Actor
import akka.actor.Props

class HelloActor extends Actor {
  override def preStart(): Unit = {
    val greeter = context.actorOf(Props[Greeter], "greeter")
    greeter ! Greeter.Greet
  }
  def receive = {
    case Greeter.Done => context.stop(self)
  }
}

object Greeter {
  case object Greet
  case object Done
}

class Greeter extends Actor {
  def receive = {
    case Greeter.Greet => 
      println("Hello Akka Actor!")
      sender ! Greeter.Done
  }
}