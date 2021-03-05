package chapter9

import Chapter9.{Item, Knapsack}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class KnapsackSpec extends AnyFlatSpec with Matchers {

  "Knapsack" should "calculate the optimized items" in {
    val Water        = Item("Water", 3, 10)
    val Book         = Item("Book", 1, 3)
    val Food         = Item("Food", 2, 9)
    val Jacket       = Item("Jacket", 2, 5)
    val Camera       = Item("Camera", 1, 6)
    val items        = List(Water, Book, Food, Jacket, Camera)
    val knapsackSize = 6
    Knapsack(items, knapsackSize) shouldBe 25
  }
}
