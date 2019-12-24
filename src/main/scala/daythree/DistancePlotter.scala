package daythree

import scala.annotation.tailrec
import model.Position

import scala.math.abs
import scala.util.matching.Regex

object DistancePlotter {

  private val regex: Regex = "([UDLR])(\\d+)".r

  @tailrec
  def parseList(xs: List[String], acc: Vector[Position] = Vector(Position(0,0))): Vector[Position] = xs match {
    case Nil => acc
    case h :: t => h match {
      case regex(letter, number) => parseList(t, accumulate(number.toInt, acc.last, letter, acc))
    }
  }

  def parseDirection(direction: String, p: Position): Position = direction match {
    case "U" => p.copy(y = p.y + 1)
    case "D" => p.copy(y = p.y - 1)
    case "L" => p.copy(x = p.x - 1)
    case "R" => p.copy(x = p.x + 1)
  }

  @tailrec
  def accumulate(n: Int, p: Position, direction: String, acc: Vector[Position]): Vector[Position] = {
    if (n == 0) acc else {
      val newPosition = parseDirection(direction, p)
      accumulate(n - 1, newPosition, direction, acc :+ newPosition)
    }
  }

  def parseMinimum(xs: List[String], ys: List[String]): Int = {
    val v1 = parseList(xs)
    val v2 = parseList(ys)

    minimumDistance(v1, v2)
  }

  def minimumDistance(v1: Vector[Position], v2: Vector[Position]): Int = {
    //Remove Position(0,0)
    val commonPositions = v1.intersect(v2).tail
    commonPositions.map(x => abs(x.distance)).min
  }

  def calculateDistance(seq: Seq[Position]): Map[Position, Int] = seq.zipWithIndex.map {
    case (position, distance) => (position, distance + 1)
  }.toMap
}
