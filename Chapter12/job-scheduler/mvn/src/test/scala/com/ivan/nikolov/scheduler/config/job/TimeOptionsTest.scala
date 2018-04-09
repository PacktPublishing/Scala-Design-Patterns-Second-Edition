package com.ivan.nikolov.scheduler.config.job

import java.time.LocalDateTime

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FlatSpec, Matchers}

@RunWith(classOf[JUnitRunner])
class TimeOptionsTest extends FlatSpec with Matchers {

  "getInitialDelay" should "get the right initial delay for hourly less than an hour after now." in {
    val now = LocalDateTime.of(2018, 3, 20, 12, 43, 10)
    val later = now.plusMinutes(20)
    val timeOptions = TimeOptions(later.getHour, later.getMinute)
    val result = timeOptions.getInitialDelay(now, Hourly)
    result.toMinutes should equal(20)
  }
  
  it should "get the right initial delay for hourly more than an hour after now." in {
    val now = LocalDateTime.of(2018, 3, 20, 18, 51, 17)
    val later = now.plusHours(3)
    val timeOptions = TimeOptions(later.getHour, later.getMinute)
    val result = timeOptions.getInitialDelay(now, Hourly)
    result.toHours should equal(3)
  }
  
  it should "get the right initial delay for hourly less than an hour before now." in {
    val now = LocalDateTime.of(2018, 3, 20, 11, 18, 55)
    val earlier = now.minusMinutes(25)
    // because of the logic and it will fail otherwise.
    if (earlier.getDayOfWeek == now.getDayOfWeek) {
      val timeOptions = TimeOptions(earlier.getHour, earlier.getMinute)
      val result = timeOptions.getInitialDelay(now, Hourly)
      result.toMinutes should equal(35)
    }
  }
  
  it should "get the right initial delay for hourly more than an hour before now." in {
    val now = LocalDateTime.of(2018, 3, 20, 12, 43, 59)
    val earlier = now.minusHours(1).minusMinutes(25)
    // because of the logic and it will fail otherwise.
    if (earlier.getDayOfWeek == now.getDayOfWeek) {
      val timeOptions = TimeOptions(earlier.getHour, earlier.getMinute)
      val result = timeOptions.getInitialDelay(now, Hourly)
      result.toMinutes should equal(35)
    }
  }
  
  it should "get the right initial delay for daily before now." in {
    val now = LocalDateTime.of(2018, 3, 20, 14, 43, 10)
    val earlier = now.minusMinutes(25)
    // because of the logic and it will fail otherwise.
    if (earlier.getDayOfWeek == now.getDayOfWeek) {
      val timeOptions = TimeOptions(earlier.getHour, earlier.getMinute)
      val result = timeOptions.getInitialDelay(now, Daily)
      result.toMinutes should equal(24 * 60 - 25)
    }
  }
  
  it should "get the right initial delay for daily after now." in {
    val now = LocalDateTime.of(2018, 3, 20, 16, 21, 6)
    val later = now.plusMinutes(20)
    val timeOptions = TimeOptions(later.getHour, later.getMinute)
    val result = timeOptions.getInitialDelay(now, Daily)
    result.toMinutes should equal(20)
  }
}
