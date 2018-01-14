package com.ruchij.utils.exceptions

object EmptyInputException extends Exception
{
  override def getMessage: String = "Empty input file"
}
