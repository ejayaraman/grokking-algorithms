package Chapter7

import scala.annotation.tailrec
import scala.collection.mutable

//Second Iteration
object Dijkstra {
  def apply(graph: Map[String, List[Node]]): Int = {
    val costs: List[Node]                    = graph("start") ++ List(Node("final", Double.PositiveInfinity.toInt))
    val parents: mutable.Map[String, String] = mutable.Map[String, String]()
    graph("start").foreach { value =>
      parents.addOne(value.name -> "start")
    }

    @tailrec
    def recurse(processedNodes: List[String]): Int = {
      val unprocessedNodes: List[Node] = costs.filterNot(node => processedNodes.contains(node.name))
      val lowestCostNode = unprocessedNodes match {
        case Nil          => None
        case head :: tail => Some((head :: tail).minBy(_.edge))
      }

      lowestCostNode match {
        case Some(node) =>
          val neighbours: Option[List[Node]] = graph.get(node.name)
          neighbours.foreach { neighbour =>
            neighbour.foreach { n =>
              val currentNode = costs.find(_.name == n.name)
              val currentCost = currentNode.get.edge
              val newCost     = costs.find(_.name == node.name).get.edge + n.edge
              if (currentCost > newCost) {
                currentNode.get.edge = newCost
                parents.update(n.name, node.name)
              }
            }
          }
          recurse(node.name :: processedNodes)
        case None => costs.find(_.name == "final").get.edge
      }
    }
    recurse(List.empty)
  }
}
