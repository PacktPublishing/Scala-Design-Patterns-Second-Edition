package com.ivan.nikolov.monoids

import org.scalacheck.Arbitrary
import org.scalatest.prop.Checkers
import org.scalatest.{FlatSpec, Matchers}

import scalaz._

import scalaz.scalacheck.ScalazProperties._

class MonoidsTest extends FlatSpec with Matchers with Checkers {

  implicit def arbString(implicit ev: Arbitrary[String]): Arbitrary[String] =
    Arbitrary { ev.arbitrary.map(identity) }
  
  "stringConcatenation monoid" should "satisfy the identity rule." in {
    monoid.laws[String](stringConcatenation, Equal.equalA[String], arbString).check()
  }
}
