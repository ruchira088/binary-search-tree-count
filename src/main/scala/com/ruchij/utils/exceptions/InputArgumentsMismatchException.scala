package com.ruchij.utils.exceptions

case class InputArgumentsMismatchException(expected: Int, actual: Int) extends Exception
{
  override def getMessage: String = s"InputArgumentsMismatchException(Expected: $expected, Actual: $actual)"
}