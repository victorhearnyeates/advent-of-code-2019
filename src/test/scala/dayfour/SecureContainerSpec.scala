package dayfour

import org.scalatest.{FlatSpec, Matchers}

class SecureContainerSpec extends FlatSpec with Matchers {

  "adjacentDigits" should "return true if a number contains consecutive digits" in {
    val input = 12445

    val output = SecureContainer.adjacentDigits(input, 2)

    assert(output)
  }

  it should "return false if it doesn't contain consecutive digits" in {
    val input = 12345
    val output = SecureContainer.adjacentDigits(input, 2)

    assert(!output)
  }

  "doesntDecrease" should "return true if the numbers don't decrease going left to right" in {
    val input = 123445
    val output = SecureContainer.doesntDecrease(input)

    assert(output)
  }

  it should "return false if numbers decrease" in {
    val input = 21234
    val output = SecureContainer.doesntDecrease(input)

    assert(!output)
  }

  "numPasswords" should "return 4 for 112345-112349" in {
    val input = "112345-112349"
    val output = SecureContainer.numPassords(input)

    output shouldBe 4
  }

  it should "return 1 for 112349-112354" in {
    val input = "112349-112354"
    val output = SecureContainer.numPassords(input)

    output shouldBe 1
  }

  it should "return 1 for 112443-112446" in {
    val input = "112443-112446"
    val output = SecureContainer.numPassords(input)

    output shouldBe 1
  }

  "onlyThree" should "return false for increasing digits" in {
    val input = "123456"
    val output = SecureContainer.moreThanTwo(input)

    assert(!output)
  }

  it should "return true if the number contains sequential duplicate digits" in {
    val input = "112345"
    val output = SecureContainer.moreThanTwo(input)

    assert(output)
  }

  it should "return false if the number contains 3 sequential duplicate digits" in {
    val input = "111345"
    val output = SecureContainer.moreThanTwo(input)

    assert(!output)
  }

  it should "be able to handle a mixture of 2 and 3 sequential digits" in {
    val input1 = "111355"
    val input2 = "113555"
    val output1 = SecureContainer.moreThanTwo(input1)
    val output2 = SecureContainer.moreThanTwo(input2)

    assert(output1)
    assert(output2)
  }

  it should "not contain larger groups" in {
    val input = "111123"
    val output = SecureContainer.moreThanTwo(input)

    assert(!output)
  }
}
