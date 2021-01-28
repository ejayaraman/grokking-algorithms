package Chapter2

import chapter2.SelectionSort
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class SelectionSortSpec extends AnyFlatSpec with Matchers{

  "SelectionSort" should "return a sorted array" in {

    SelectionSort.sort(Array(1, 3, 4, 2, 6, 5)) should be (Array(1, 2, 3, 4, 5, 6))
  }
}
