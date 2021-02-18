package chapter7

import Chapter7.Dijkstra
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class DijkstraSpec extends AnyFlatSpec with Matchers {

  "Dijkstra" should "return the shortest path" in {
    val startNeighbours = Map[String, Double]("a"   -> 6, "b" -> 2)
    val aNeighbours     = Map[String, Double]("fin" -> 1)
    val bNeighbours     = Map[String, Double]("a"   -> 3, "fin" -> 5)

    val graph: Map[String, Map[String, Double]] =
      Map("start" -> startNeighbours, "a" -> aNeighbours, "b" -> bNeighbours)

    Dijkstra(graph) shouldBe 6
  }

  "Dijkstra" should "return the shortest path as 2" in {
    val startNeighbours = Map[String, Double]("a"   -> 1, "b" -> 2)
    val aNeighbours     = Map[String, Double]("fin" -> 1)
    val bNeighbours     = Map[String, Double]("a"   -> 3, "fin" -> 5)

    val graph: Map[String, Map[String, Double]] =
      Map("start" -> startNeighbours, "a" -> aNeighbours, "b" -> bNeighbours)

    Dijkstra(graph) shouldBe 2
  }
}
