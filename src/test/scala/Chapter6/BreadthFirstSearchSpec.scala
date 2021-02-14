package Chapter6

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class BreadthFirstSearchSpec extends AnyFlatSpec with Matchers {

  "BreadthFirstSearch" should "find the current match" in {
    val graph = Map[String, List[String]](
      "You"  -> List("Alice", "Bob", "Claire"),
      "Bob"    -> List("Anuj", "Peggy"),
      "Alice"  -> List("Peggy"),
      "Claire" -> List("Thom", "Jonny"))
    BreadthFirstSearch(graph, "You") shouldBe "Thom"
  }
}
