import dayone.FuelCount
import helpers.Io

object Main extends App {

  val moduleMassCount = FuelCount.addUpModules(new Io {}, "module-masses")

  println(s"Total module mass is : $moduleMassCount")
}
