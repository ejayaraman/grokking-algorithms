package Chapter3

object Recursive {

  def sum(list: List[Int]): Int = {
    list match {
      case Nil => 0
      case head :: tail => head + sum(tail)
    }
  }
}
