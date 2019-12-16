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
    val output = accumulate(1, origin, "U", Set(origin))

    output shouldBe Set(Position(0,0), Position(0,1))
  }

  it should "return two positions if passed n = 2" in {
    val output = accumulate(2, origin, "U", Set(origin))

    output shouldBe Set(origin, Position(0,1), Position(0,2))
  }
}
