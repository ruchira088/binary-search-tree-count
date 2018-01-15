package com.ruchij

import com.ruchij.counter.{CustomMemoizeCounter, StreamCounter}
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

      List[Int => Int](CustomMemoizeCounter.count(_, App.MOD), StreamCounter.count(_, App.MOD))
          .foreach {
            calculate =>
              inputs.foreach {
                case (input, expectedOutput) =>
                  calculate(input) shouldEqual expectedOutput
              }
          }

    }
}
