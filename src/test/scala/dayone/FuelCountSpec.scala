package dayone

import helpers.Io
import org.scalamock.scalatest.MockFactory
import org.scalatest.{FlatSpec, Matchers}


class FuelCountSpec extends FlatSpec with Matchers with MockFactory {

  "count" should "divide a number by three, then take away 2" in {
    val output = FuelCount.count(14)

    output shouldBe 2
  }

  it should "calculate the fuel requirements of the fuel itself if the module is large enough" in {
    val output1 = FuelCount.count(1969)
    val output2 = FuelCount.count(100756)

    output1 shouldBe 966
    output2 shouldBe 50346
  }

  "addUpModules" should "apply count to all the numbers in the resource file and sum them up" in {
    val mockIo = stub[Io]
    (mockIo.getResource _).when("file").returns(Vector("12", "14", "15"))
    val output = FuelCount.addUpModules(mockIo, "file")

    output shouldBe 7
  }
}
