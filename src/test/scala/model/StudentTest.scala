package model

import org.scalatest.FunSuite

class StudentTest extends FunSuite{

  test("Basic"){

    val s = new Student("bob", 12)
    assert( s.name == "bob" )
    assert( s.age == 12 )

  }

}
