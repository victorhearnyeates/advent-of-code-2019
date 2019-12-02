package helpers

import scala.io.Source

trait Io {
  def getResource(str: String): Vector[String] = Source.fromResource(str).getLines().toVector
}
