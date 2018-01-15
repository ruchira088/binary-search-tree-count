package com.ruchij.counter

object StreamCounter
{
  def count(nodes: Int, modulus: Int): Int = {

    lazy val binarySearchTreeCounter: Stream[Int] = 1 #:: Stream.from(1).map {
      index => CounterUtils.getCount(index, modulus, binarySearchTreeCounter.apply)
    }

    binarySearchTreeCounter(nodes)
  }
}
