package daythree

import scala.annotation.tailrec

import model.Position

object DistancePlotter {

  private val regex = "([UDLR])(\\d+)".r

/*  def unpack(str: String) = str match {
    case regex(letter, number) => ???
  }*/

  def parseDirection(direction: String, p: Position): Position = direction match {
    case "U" => p.copy(y = p.y + 1)
    case "D" => p.copy(y = p.y - 1)
    case "L" => p.copy(x = p.x - 1)
    case "R" => p.copy(x = p.x + 1)
  }

  @tailrec
  def accumulate(n: Int, p: Position, direction: String, acc: Set[Position]): Set[Position] = {
    if (n == 0) acc else {
      val newPosition = parseDirection(direction, p)
      accumulate(n - 1, newPosition, direction, acc + newPosition)
    }
  }
}
