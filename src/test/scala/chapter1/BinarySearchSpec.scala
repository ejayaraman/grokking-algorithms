package chapter1

import org.scalatest.flatspec.AnyFlatSpec

class BinarySearchSpec extends AnyFlatSpec {
  "Binary Search" should "return -1 when element not found" in {
    assert(BinarySearch.search(List(0,1,2,3),4) == -1)
  }
  it should "return index when element found" in {
    assert(BinarySearch.search(List(0,1,2,3),2) == 2)
  }
  it should "return index when element found1" in {
    assert(BinarySearch.search(List(0,1,2,3,5),5) == 4)
  }
}