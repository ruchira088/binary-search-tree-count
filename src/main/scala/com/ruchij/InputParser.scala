package com.ruchij

import com.ruchij.utils.GeneralUtils
import com.ruchij.exceptions.{EmptyInputException, InputArgumentsMismatchException}

import scala.util.{Failure, Success, Try}

object InputParser
{
  def parseStringList(input: List[String]): Try[List[Int]] =
    GeneralUtils.convertList[String, Int](input, _.toInt)

  def nodeCountsList(input: List[Int]): Try[List[Int]] =
    input match
      {
        case Nil => Failure(EmptyInputException)
        case x :: xs if xs.length != x => Failure(InputArgumentsMismatchException(x, xs.length))
        case _ :: xs => Success(xs)
      }

  def parse(input: List[String]): Try[List[Int]] =
    for {
      ints <- parseStringList(input)

      nodes <- nodeCountsList(ints)
    }
    yield nodes
}
