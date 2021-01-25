package chapter1

import scala.annotation.tailrec
object BinarySearchRecursive {
  def search(sortedList: List[Int], searchElement: Int): Int = {
    val begin = 0
    val end   = sortedList.length - 1

    @tailrec
    def searchRecursive(begin: Int, end: Int): Int = {
      val mid = (begin + end) / 2
      if (begin <= end) {
        if (sortedList(mid) == searchElement) {
          mid
        } else if (sortedList(mid) < searchElement) {
          searchRecursive(begin = mid + 1, end)
        } else {
          searchRecursive(begin, mid)
        }
      } else {
        -1
      }
    }

    if (sortedList(begin) == searchElement) {
      begin
    } else
      searchRecursive(begin, end)
  }

}
