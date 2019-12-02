package daytwo

import scala.annotation.tailrec

object Intcode {

  @tailrec
  def compute(array: Array[Int], position: Int = 0): Array[Int] = {
    if (array(position) == 99) {
      array
    } else {
      array.slice(position, position + 4) match {
        case Array(1, x, y, z) => array(z) = array(x) + array(y)
        case Array(2, x, y, z) => array(z) = array(x) * array(y)
      }
      compute(array, position + 4)
    }
  }
}
