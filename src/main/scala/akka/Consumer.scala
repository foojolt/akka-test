package akka

import akka.actor.Actor

class Consumer extends Actor {

  def receive = {
    case Message(text) =>
      println("consume message by: " + self.hashCode() + ", msg: " + text)
    case _ =>
      sender ! "unknown message received: "
  }


}
