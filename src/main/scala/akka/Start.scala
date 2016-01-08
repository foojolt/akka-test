package akka

import akka.actor.{ActorRef, Props, Actor}
import akka.routing.RoundRobinRouter

class Start(val genCnt: Int, val conCnt: Int) extends Actor {

  private var generator: ActorRef = null
  private var conPool: ActorRef = null
  private var started = false

  def receive = {
    case "start" =>
      generator = context.actorOf(Props[Generator], name = "generator")
//      conPool = context.actorOf(Props[Consumer], name = "conPool")
      conPool = context.actorOf(Props[Consumer].withRouter(RoundRobinRouter(conCnt)), name = "conPool")
      generator ! "start"
      started = true
    case Message(text) =>
      if (!started) {
        println("not started, but receive message: " + text)
      } else {
        conPool ! Message(text)
      }
    case _ =>
      println("unknown msg received")
  }
}
