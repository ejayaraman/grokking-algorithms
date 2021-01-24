package chapter1

object BinarySearch {
  def search(sortedList: List[Int], searchElement: Int): Int = {
    var begin = 0
    var end   = sortedList.length - 1

    while (begin < end) {
      val mid = (begin + end) / 2
      if (sortedList(mid) == searchElement) {
        return mid
      } else if (sortedList(mid) < searchElement) {
        begin = mid + 1
      } else {
        end = mid
      }
    }

    if (sortedList(begin) == searchElement) {
      begin
    } else
      -1
  }

}
