package daythree.model

import scala.math.abs

case class Position(x: Int, y: Int) {
  lazy val distance: Int = abs(x) + abs(y)
}
