package daythree

import org.scalatest.{FlatSpec, Matchers}
import DistancePlotter._
import daythree.model.Position

class DistancePlotterSpec extends FlatSpec with Matchers {

  private val origin = Position(0,0)

  "parseDirection" should "increment y for U by 1" in {
    val output = parseDirection("U", origin)

    output shouldBe Position(0,1)
  }

  it should "decrement y for D by 1" in {
    val output = parseDirection("D", origin)

    output shouldBe Position(0, -1)
  }

  "accumulate" should "take a position at the origin, a direct up and a count of return and return a Set above the origin" in {
    val output = accumulate(1, origin, "U", Vector(origin))

    output shouldBe Vector(Position(0,0), Position(0,1))
  }

  it should "return two positions if passed n = 2" in {
    val output = accumulate(2, origin, "U", Vector(origin))

    output shouldBe Vector(origin, Position(0,1), Position(0,2))
  }

  "parseList" should "return the same result as accumulate if passed a List with a single entry U2" in {
    val input = List("U2")

    val output = parseList(input)

    output shouldBe Vector(Position(0,0), Position(0,1), Position(0,2))
  }

  it should "handle two directions" in {
    val input = List("U2", "R2")
    val expected = Vector(Position(0,0), Position(0,1), Position(0,2), Position(1,2), Position(2,2))

    val output = parseList(input)

    output shouldBe expected
  }

  "minimumDistance" should "find the union of two lists of positions" in {
    val v1 = Vector(Position(0,0), Position(1,0), Position(2,0), Position(1,2))
    val v2 = Vector(Position(0,0), Position(2,0), Position(1,0), Position(1,1))

    val output = minimumDistance(v1, v2)

    output shouldBe 1
  }

  "parseMinimum" should "find the minimum distance given two strings" in {
    val input1 = List("R8","U5","L5","D3")
    val input2 = List("U7","R6","D4","L4")

    val output = parseMinimum(input1, input2)

    output shouldBe 6
  }

  "calculateDistance" should "Work out the number of steps that have been taken as well" in {
    val input = Vector(Position(2,0), Position(1,0), Position(1,1))

    val output = calculateDistance(input)

    output(Position(2,0)) shouldBe 0
    output(Position(1,0)) shouldBe 1
    output(Position(1,1)) shouldBe 2
  }

  "firstIntersection" should "take in two lists (vectors) of positions an return the first intersection of the two of them" in {
    val input1 = Vector(Position(0,0), Position(0,1), Position(0,2), Position(1,2), Position(1,3))
    val input2 = Vector(Position(0,0), Position(1,1), Position(1,2), Position(2,2), Position(2,1))

    val output = firstIntersection(input1, input2)
    output shouldBe (Position(1,2), 5)
  }
}
