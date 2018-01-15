package com.ruchij.counter

import scala.collection.mutable

object CustomMemoizeCounter
{
  private val mutableCache: mutable.Map[Int, Int] = mutable.Map(0 -> 1)

  def count(nodes: Int, modulus: Int): Int =
    mutableCache.getOrElse(nodes, {
      val result = CounterUtils.getCount(nodes, modulus, count(_, modulus))
      mutableCache.put(nodes, result)
      result
    })

}
