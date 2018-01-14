package com.ruchij

import java.nio.file.{Path, Paths}

import com.ruchij.utils.IOUtils

import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

object App
{
  val INPUT_FILE_PATH: Path = Paths.get("input.txt")

  def main(args: Array[String]): Unit =
  {
    val output = for {
      input <- IOUtils.readTextFile(INPUT_FILE_PATH)

      nodes <- Future.fromTry(InputParser.parse(input))

      results = nodes.map(BinarySearchTreeCount.calculate).mkString("\n")
    }
    yield results

    println(Await.result(output, 30 seconds))
  }
}
