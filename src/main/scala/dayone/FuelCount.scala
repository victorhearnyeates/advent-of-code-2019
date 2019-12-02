package dayone

import helpers.Io

object FuelCount {

  def count(input: Int, acc: Int = 0): Int = {
    val fuel = input / 3 - 2
    if (fuel > 6) count(fuel, acc + fuel) else acc + fuel
  }

  def addUpModules(io: Io, resource: String): Int = {
    io.getResource(resource).foldLeft(0)((acc, y) => acc + count(y.toInt))
  }
}
