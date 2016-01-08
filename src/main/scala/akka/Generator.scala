package akka

import java.util.Date

import akka.actor.Actor

import scala.util.Random

class Generator extends Actor{

  def receive = {
    case "start" =>
      while(true){
        Thread.sleep( Random.nextInt( 3000 ) )
        sender ! Message( "dateMsg-from-"+ self.hashCode()+ "-"+new Date().toString )
      }

    case _ =>
      sender ! "unknown message received"
  }


}
