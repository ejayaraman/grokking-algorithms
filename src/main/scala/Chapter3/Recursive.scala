package Chapter3

object Recursive {

  def sum(list: List[Int]): Int =
    list match {
      case Nil          => 0
      case head :: tail => head + sum(tail)
    }

  def count(list: List[Int]): Int =
    list match {
      case Nil          => 0
      case head :: Nil  => 1
      case head :: tail => 1 + count(tail)
    }

  def max(list: List[Int]): Int =
    list match {
      case Nil         => 0
      case head :: Nil => head
      case head :: tail =>
        if (head > max(tail))
          head
        else
          max(tail)
    }
}
