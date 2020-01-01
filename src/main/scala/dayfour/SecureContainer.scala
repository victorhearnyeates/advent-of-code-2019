package dayfour

import scala.annotation.tailrec

object SecureContainer {

  def adjacentDigits(int: Int, num: Int): Boolean = {
    int.toString.toCharArray.sliding(num).map(x => x.toSet.size == 1).reduce(_ || _)
  }

  def doesntDecrease(int: Int): Boolean = {
    val str = int.toString
    str == str.sorted
  }

  def numPassords(str: String): Int = {
    val split = str.split("-")
    val lower = split(0).toInt
    val upper = split(1).toInt

    lower until upper filter doesntDecrease count ((i: Int) => moreThanTwo(i.toString))
  }

  @tailrec
  def moreThanTwo(num: String, lastNum: Option[Char] = None, acc: Int = 1): Boolean = {
    val nextNum = num.headOption

    num match {
      case _ if acc == 2 && nextNum != lastNum => true
      case x if nextNum == lastNum => moreThanTwo(x.substring(1), x.headOption, acc + 1)
      case "" => false
      case other => moreThanTwo(other.substring(1), other.headOption)
    }
  }
}
