package Chapter3

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

class RecursiveSpec extends AnyFlatSpec with Matchers {

  "Recursive sum function" should "return correct sum" in {
    Recursive.sum(List(1, 2, 3)) shouldBe 6
  }

  it should "return 0 for empty list" in {
    Recursive.sum(List.empty) shouldBe 0
  }

  it should "return the same number for a list with single element" in {
    Recursive.sum(List(3)) shouldBe 3
  }

  "Recursive count function" should "return the correct count" in {
    Recursive.count(List(1, 2, 3)) shouldBe 3
  }

  it should "return 0 for empty list" in {
    Recursive.count(List.empty) shouldBe 0
  }

  it should "return the correct count value of a list with single element" in {
    Recursive.count(List(3)) shouldBe 1
  }

  "Recursive max function" should "return the correct max value" in {
    Recursive.max(List(1, 3, 2)) shouldBe 3
  }

  "Recursive max function" should "return the correct max value for a longer list" in {
    Recursive.max(List(1, 3, 2, 4, 5, 7, 6, 9, -1)) shouldBe 9
  }

  "Recursive max function" should "return 0 for empty list" in {
    Recursive.max(List()) shouldBe 0
  }

  "Recursive max function" should "return the same value for list with one item" in {
    Recursive.max(List(1)) shouldBe 0
  }

  "Recursive max function" should "return the correct max value when duplicate entries exist" in {
    Recursive.max(List(1, 3, 2, 4, 5, 7, 6, 9, -1, 9, 2)) shouldBe 9
  }
}
