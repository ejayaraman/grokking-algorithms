package chapter2

import scala.annotation.tailrec
import scala.collection.mutable.ArrayBuffer

object SelectionSort {

  def sort(unsortedArray: Array[Int]): Array[Int] = {

    val sortedArray = new ArrayBuffer[Int]()

    @tailrec
    def recurse(unsortedArray: Array[Int]): Array[Int] =
      if (unsortedArray.nonEmpty) {
        var smallest = unsortedArray.head
        for (i <- unsortedArray.indices) {
          if (unsortedArray(i) < smallest) {
            smallest = unsortedArray(i)
          }
        }
        sortedArray.addOne(smallest)
        recurse(unsortedArray.filterNot(_ == smallest))
      } else {
        sortedArray.toArray
      }

    recurse(unsortedArray)

  }

}
