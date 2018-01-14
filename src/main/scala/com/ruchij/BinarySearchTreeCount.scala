package com.ruchij

import scala.collection.mutable

object BinarySearchTreeCount
{
  private val mutableCache: mutable.Map[Int, Int] = mutable.Map(0 -> 1)

  val MOD: Int = (Math.pow(10, 8) + 7).toInt

  case class Split[T](left: List[T], right: List[T])

  private def split[T](value: T, list: List[T]): Option[Split[T]] =
    list match {
      case Nil => None
      case x :: xs if x == value => Some(Split(List.empty, xs))
      case x :: xs => split(value, xs)
        .map {
          case Split(left, right) => Split(x :: left, right)
        }
    }

  private def calculate[T](list: List[T]): Int =
    mutableCache.getOrElse(
      list.length,
      {
        val value = list
          .map(split(_, list)
            .map {
              case Split(left, right) => calculate(left).toDouble * calculate(right)
            }
            .fold(0)(_ % MOD toInt)
          )
          .foldLeft(0) {
            case (sum, current) => (sum + current) % MOD
          }

        mutableCache.put(list.length, value)
        value
      }
    )

  def calculate(nodeCount: Int): Int =
    calculate(1 to nodeCount toList)

}
