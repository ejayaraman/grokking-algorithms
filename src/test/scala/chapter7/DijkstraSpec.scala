package chapter7

import Chapter7.{Dijkstra, Node}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class DijkstraSpec extends AnyFlatSpec with Matchers {

  "Dijkstra" should "return the shortest path as 2" in {
    val startNeighbours = List[Node](Node("a", 1), Node("b", 2))
    val aNeighbours     = List[Node](Node("final", 1))
    val bNeighbours     = List[Node](Node("a", 3), Node("final", 5))

    val graph: Map[String, List[Node]] =
      Map("start" -> startNeighbours, "a" -> aNeighbours, "b" -> bNeighbours)

    Dijkstra(graph) shouldBe 2
  }

  "Dijkstra" should "return the shortest path" in {
    val startNeighbours = List[Node](Node("a", 6), Node("b", 2))
    val aNeighbours     = List[Node](Node("final", 1))
    val bNeighbours     = List[Node](Node("a", 3), Node("final", 5))

    val graph: Map[String, List[Node]] =
      Map("start" -> startNeighbours, "a" -> aNeighbours, "b" -> bNeighbours)

    Dijkstra(graph) shouldBe 6
  }

  "Dijkstra" should "return the shortest path when there is a node that is not connected to final" in {
    val startNeighbours = List[Node](Node("a", 1), Node("b", 2))
    val aNeighbours     = List[Node](Node("final", 1))
    val bNeighbours     = List[Node](Node("a", 3), Node("c", 1), Node("final", 5))

    val graph: Map[String, List[Node]] =
      Map("start" -> startNeighbours, "a" -> aNeighbours, "b" -> bNeighbours)

    Dijkstra(graph) shouldBe 2
  }

  "Dijkstra" should "return the shortest path via C" in {
    val startNeighbours = List[Node](Node("a", 1), Node("b", 2))
    val aNeighbours     = List[Node](Node("final", 6))
    val bNeighbours     = List[Node](Node("a", 3), Node("c", 1), Node("final", 10))
    val cNeighbours     = List[Node](Node("final", 1))

    val graph: Map[String, List[Node]] =
      Map("start" -> startNeighbours, "a" -> aNeighbours, "b" -> bNeighbours, "c" -> cNeighbours)

    Dijkstra(graph) shouldBe 4
  }

  "Dijkstra" should "return the shortest path for exercise 7.1A" in {
    val startNeighbours = List[Node](Node("a", 5), Node("b", 2))
    val aNeighbours     = List[Node](Node("c", 4), Node("d", 2))
    val bNeighbours     = List[Node](Node("a", 8), Node("d", 7))
    val cNeighbours     = List[Node](Node("d", 6), Node("final", 3))
    val dNeighbours     = List[Node](Node("final", 1))

    val graph: Map[String, List[Node]] =
      Map("start" -> startNeighbours, "a" -> aNeighbours, "b" -> bNeighbours, "c" -> cNeighbours, "d" -> dNeighbours)

    Dijkstra(graph) shouldBe 8
  }

  "Dijkstra" should "return the shortest path for exercise 7.1B" in {
    val startNeighbours = List[Node](Node("a", 10))
    val aNeighbours     = List[Node](Node("b", 20))
    val bNeighbours     = List[Node](Node("c", 1), Node("final", 30))
    val cNeighbours     = List[Node](Node("a", 1))

    val graph: Map[String, List[Node]] =
      Map("start" -> startNeighbours, "a" -> aNeighbours, "b" -> bNeighbours, "c" -> cNeighbours)

    Dijkstra(graph) shouldBe 60
  }

}
