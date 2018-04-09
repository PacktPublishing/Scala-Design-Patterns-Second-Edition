package com.ivan.nikolov.linearisation

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FlatSpec, Matchers}

@RunWith(classOf[JUnitRunner])
class DoubledMultiplierIdentityTest extends FlatSpec with Matchers {

  class DoubledMultiplierIdentityClass extends DoubledMultiplierIdentity
  
  val instance = new DoubledMultiplierIdentityClass
  
  "identity" should "return 2 * 1" in {
    instance.identity should equal(2)
  }
}
