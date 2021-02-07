package chapter4

import Chapter4.QuickSort
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class QuickSortSpec extends AnyFlatSpec with Matchers {

  "quick sort" should "sort the give array correctly" in {
    QuickSort(Array(2, 1, 4, 3)) shouldBe Array(1, 2, 3, 4)
  }

  it should "sort array with negative numbers" in {
    QuickSort(Array(2, 1, 4, 3, -1, 0, -2)) shouldBe Array(-2, -1, 0, 1, 2, 3, 4)
  }

  it should "return an empty array when there are no elements" in {
    QuickSort(Array.empty) shouldBe Array.empty
  }

  it should "return the same array when the array has only one element" in {
    QuickSort(Array(1)) shouldBe Array(1)
  }
}
