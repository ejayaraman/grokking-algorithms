package Chapter7

import scala.annotation.tailrec
import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

//First Iteration
object Dijkstra {

  val processed = new ArrayBuffer[String]()

  def apply(graph: Map[String, Map[String, Double]]): Int = {

    val costs: mutable.Map[String, Double] = mutable.Map[String, Double]("fin" -> Double.PositiveInfinity) ++ graph(
      "start")
    val parents: mutable.Map[String, String] = mutable.Map[String, String]()
    graph("start").keys.foreach { value =>
      parents.addOne(value -> "start")
    }
    @tailrec
    def recurse: Int =
      lowestCostNode(costs.toMap) match {
        case Some(node) => {
          val neighbours: Option[Map[String, Double]] = graph.get(node)
          neighbours.foreach { neighbour =>
            neighbour.foreach { n =>
              if (costs(n._1) > costs(node) + n._2) {
                costs.update(n._1, costs(node) + n._2)
                parents.update(n._1, node)
              }
            }
          }
          processed.addOne(node)
          recurse
        }
        case None => costs("fin").toInt
      }
    recurse
  }

  def lowestCostNode(costs: Map[String, Double]): Option[String] = {
    val unprocessedNodes = costs.filterNot(value => processed.contains(value._1))
    if (unprocessedNodes.nonEmpty) {
      Some(unprocessedNodes.minBy(_._2)._1)
    } else
      None
  }
}
