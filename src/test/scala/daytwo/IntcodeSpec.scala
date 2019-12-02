package daytwo

import org.scalatest.{FlatSpec, Matchers}

class IntcodeSpec extends FlatSpec with Matchers {

  "compute" should "take an array that starts with 99 and return in" in {
    val input = Array(99,0,0,0,0)
    val output = Intcode.compute(input)

    output shouldBe input
  }

   it should "take an array that starts with a 1 and find the array positions of the two numbers immediately preceding it" +
     "and then add them together and insert them into the position given by the third receding number" in {
     val input = Array(1,2,4,0,99)
     val expected = Array(103,2,4,0,99)

     val output = Intcode.compute(input)

     output shouldBe expected
   }

  it should "take an array that starts with a 2 and multiply the two array positions given by the numbers immediately " +
    "preceding it and insert it into the array position given by the third preceding number" in {
    val input = Array(2,2,4,0,99)
    val expected = Array(396,2,4,0,99)

    val output = Intcode.compute(input)

    output shouldBe expected
  }

  it should "work with both type of operators in longer arrays" in {
    val input = Array(1,3,0,5,2,0,4,0,99)
    val expected = Array(8,3,0,5,2,6,4,0,99)

    val output = Intcode.compute(input)

    output shouldBe expected
  }
}
