package Chapter6

import java.util
import scala.collection.convert.ImplicitConversions.`collection AsScalaIterable`
import scala.collection.mutable.ArrayBuffer
import scala.jdk.CollectionConverters._

object BreadthFirstSearch {
  val queueToSearch = new util.ArrayDeque[String]()
  val seen          = new ArrayBuffer[String]()

  def apply(graph: Map[String, List[String]], node: String): String = {
    if (seen.contains(node)) {
      BreadthFirstSearch(graph, queueToSearch.getFirst)
    } else {
      seen.addOne(node)
      graph.get(node).map { nodes =>
        queueToSearch.addAll(nodes.asJava)
      }
      if (node.endsWith("m")) {
        println(seen.mkString("->"))
        node
      } else if (queueToSearch.nonEmpty) {
        BreadthFirstSearch(graph, queueToSearch.pop)
      } else {
        "No name found ending with 'm'"
      }
    }
  }
}
