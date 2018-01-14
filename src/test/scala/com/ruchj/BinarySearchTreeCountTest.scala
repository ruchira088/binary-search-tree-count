package com.ruchj

import com.ruchij.BinarySearchTreeCount
import org.scalatest.{FlatSpec, Matchers}

class BinarySearchTreeCountTest extends FlatSpec with Matchers
{
  "calculate" should "return the correct number of trees" in {

      val inputs: List[(Int, Int)] = List(
        1 -> 1,
        2 -> 2,
        3 -> 5,
        4 -> 14,
        39 -> 3113376,
        59 -> 28225721,
        96 -> 2506882,
        5 -> 42,
        36 -> 74625090,
        72 -> 47379996,
        91 -> 56976489,
        97 -> 38445476
      )

      inputs.foreach {
        case (input, expectedOutput) =>
          BinarySearchTreeCount.calculate(input) shouldEqual expectedOutput
      }
    }
}
