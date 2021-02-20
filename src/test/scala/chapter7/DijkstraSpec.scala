package chapter7

import Chapter7.{Dijkstra, Node}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class DijkstraSpec extends AnyFlatSpec with Matchers {

  "Dijkstra" should "return the shortest path as 2" in {
    val startNeighbours = List[Node](Node("a", 1), Node("b", 2))
    val aNeighbours     = List[Node](Node("fin", 1))
    val bNeighbours     = List[Node](Node("a", 3), Node("fin", 5))

    val graph: Map[String, List[Node]] =
      Map("start" -> startNeighbours, "a" -> aNeighbours, "b" -> bNeighbours)

    Dijkstra(graph) shouldBe 2
  }

  "Dijkstra" should "return the shortest path" in {
    val startNeighbours = List[Node](Node("a", 6), Node("b", 2))
    val aNeighbours     = List[Node](Node("fin", 1))
    val bNeighbours     = List[Node](Node("a", 3), Node("fin", 5))

    val graph: Map[String, List[Node]] =
      Map("start" -> startNeighbours, "a" -> aNeighbours, "b" -> bNeighbours)

    Dijkstra(graph) shouldBe 6
  }


}
