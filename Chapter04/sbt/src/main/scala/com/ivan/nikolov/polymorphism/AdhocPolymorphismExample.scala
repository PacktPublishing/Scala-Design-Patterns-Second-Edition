package com.ivan.nikolov.polymorphism

trait Adder[T] {
  def sum(a: T, b: T): T
}

object Adder {
  def sum[T: Adder](a: T, b: T): T =
    implicitly[Adder[T]].sum(a, b)
  
//  implicit val int2Adder: Adder[Int] = new Adder[Int] {
//    override def sum(a: Int, b: Int): Int = a + b
//  }

  implicit def numeric2Adder[T : Numeric]: Adder[T] = new Adder[T] {
    override def sum(a: T, b: T): T = implicitly[Numeric[T]].plus(a, b)
  }

  // same implementation as above, but allowed when the trait has a single method
  implicit val string2Adder: Adder[String] =
    (a: String, b: String) => s"$a concatenated with $b"
}

object AdhocPolymorphismExample {
  import Adder._
  def main(args: Array[String]): Unit = {
    System.out.println(s"The sum of 1 + 2 is ${sum(1, 2)}")
    System.out.println(s"The sum of 1.2 + 6.5 is ${sum(1.2, 6.5)}")
    System.out.println(s"The sum of abc + def is ${sum("abc", "def")}")
  }
}
