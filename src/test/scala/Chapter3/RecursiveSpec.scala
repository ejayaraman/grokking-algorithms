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
}
