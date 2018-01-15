package com.ruchij.counter

import com.ruchij.utils.GeneralUtils._

object CounterUtils
{
  def getCount(count: Int, modulus: Int, calculate: Int => Double): Int =
  {
    val list = Range(0, count).toList

    list
      .map(split(_, list)
        .map {
          case Split(left, right) =>
            calculate(left.length) * calculate(right.length)
        }
        .fold(0)(_ % modulus toInt)
      )
      .foldLeft(0) {
        case (sum, current) => (sum + current) % modulus
      }
  }
}
