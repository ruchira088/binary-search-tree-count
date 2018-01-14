package com.ruchij.utils

import scala.util.control.NonFatal
import scala.util.{Failure, Success, Try}

object GeneralUtils
{
  def convert[A, B](value: A, converter: A => B): Try[B] =
    try {
      Success(converter(value))
    }
    catch
    {
      case NonFatal(throwable) => Failure(throwable)
    }

  def convertList[A, B](list: List[A], converter: A => B): Try[List[B]] =
    list match
    {
      case Nil => Success(List.empty)
      case x :: xs =>
        for {
          value <- convert(x, converter)
          rest <- convertList(xs, converter)
        }
        yield value :: rest
    }

  def predicate(condition: Boolean, exception: => Exception): Try[Unit] =
    if (condition) Success((): Unit) else Failure(exception)
}
