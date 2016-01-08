package akka

import akka.actor.{ActorSystem, Props}

object Main {

  def main(args: Array[String]) {

    val sys = ActorSystem("akka_test")
    val starter = sys.actorOf( Props(new Start( 10, 2 )), name = "starter" )
    starter ! "start"

    while(true){

      Thread.sleep( 1000 )

    }

  }

}
