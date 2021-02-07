package Chapter4

object QuickSort {

  def apply(unsortedArray: Array[Int]): Array[Int] =
    if (unsortedArray.length < 2) {
      unsortedArray
    } else {
      val pivot            = unsortedArray.head
      val lessThanPivot    = unsortedArray.filter(_ < pivot)
      val greaterThanPivot = unsortedArray.filter(_ > pivot)
      QuickSort(lessThanPivot) ++ Array(pivot) ++ QuickSort(greaterThanPivot)
    }
}
