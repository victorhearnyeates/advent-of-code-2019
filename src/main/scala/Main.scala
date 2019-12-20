import dayone.FuelCount
import daytwo.Intcode
import daythree.DistancePlotter
import helpers.Io

import scala.io.Source

object Main extends App {

  //Day One
  val moduleMassCount = FuelCount.addUpModules(new Io {}, "module-masses")
  println(s"Total module mass is : $moduleMassCount")

  //Day Two
  val input = Source.fromResource("intcode-alarm").getLines().next().split(',').map(_.toInt)
  input(1) = 95
  input(2) = 7
  val intcode = Intcode.compute(input)
  println(intcode.toList.toString)

  //Day Three
  val inputs: List[String] = Source.fromResource("input-distances").getLines().toList
  val input1 = inputs.head.split(",").toList
  val input2 = inputs.tail.head.split(",").toList
  val minimumDistance = DistancePlotter.parseMinimum(input1, input2)
  println("The minimum distance is " + minimumDistance)
}
