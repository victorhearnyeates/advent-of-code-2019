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

    lower until upper filter doesntDecrease filter ((i: Int) => moreThanTwo(i.toString)) count ((i: Int) => !adjacentDigits(i, 4))
  }

  @tailrec
  def moreThanTwo(num: String, lastNum: Option[Char] = None, isTrue: Boolean = false): Boolean = num match {
    case "" => isTrue
    case x if firstLetterMatches(num.headOption, lastNum) => moreThanTwo(x.substring(1), x.headOption, !isTrue)
    case other => moreThanTwo(other.substring(1), other.headOption, isTrue)
  }

  private def firstLetterMatches(firstLetter: Option[Char], last: Option[Char]): Boolean = firstLetter == last
}
