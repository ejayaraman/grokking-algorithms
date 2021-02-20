package Chapter7

import scala.annotation.tailrec
import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

//Second Iteration
object Dijkstra {
  def apply(graph: Map[String, List[Node]]): Int = {
    val costs: ArrayBuffer[Node] = new ArrayBuffer[Node]() ++ (graph("start") ++ List(
      Node("final", Double.PositiveInfinity.toInt)))
    val parents: mutable.Map[String, String] = mutable.Map[String, String]()
    graph("start").foreach { value =>
      parents.addOne(value.name -> "start")
    }

    @tailrec
    def recurse(processedNodes: List[String]): Int = {
      val unprocessedNodes: List[Node] = costs.filterNot(node => processedNodes.contains(node.name)).toList
      val lowestCostNode = unprocessedNodes match {
        case Nil          => None
        case head :: tail => Some((head :: tail).minBy(_.edge))
      }

      lowestCostNode match {
        case Some(lowCostNode) =>
          graph.get(lowCostNode.name) match {
            case Some(neighbours) =>
              neighbours.foreach { n =>
                val currentNode = if (costs.exists(_.name == n.name)) {
                  costs.find(_.name == n.name).get
                } else {
                  costs.addOne(Node(n.name, Double.PositiveInfinity.toInt)) //add a node to the costs collection when not exists.
                  costs.find(_.name == n.name).get
                }
                val currentCost = currentNode.edge
                val newCost     = costs.find(_.name == lowCostNode.name).get.edge + n.edge
                if (currentCost > newCost) {
                  currentNode.edge = newCost
                  parents.update(n.name, lowCostNode.name)
                }
              }
              recurse(lowCostNode.name :: processedNodes)
            case None => recurse(lowCostNode.name :: processedNodes)
          }
        case None => costs.find(_.name == "final").get.edge
      }
    }
    recurse(List.empty)
  }
}
