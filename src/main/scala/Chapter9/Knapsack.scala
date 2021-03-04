package Chapter9

//Second Iteration
object Knapsack {
  def apply(items: List[Item], knapsackSize: Int): Int = {
    val table: Array[Array[Int]] = Array.ofDim[Int](items.size, knapsackSize)

    for {
      (item, index) <- items.zipWithIndex
      size          <- 0 until knapsackSize
    } {
      val sackSize = size + 1
      table(index)(size) = if (index == 0) {
        if (item.weight <= sackSize)
          item.value
        else
          0
      } else {
        if (item.weight == sackSize && item.value > table(index - 1)(sackSize))
          item.value
        else if (item.weight > sackSize)
          table(index - 1)(size)
        else if (item.weight < sackSize && (item.value + table(index - 1)(size - item.weight) > table(index - 1)(size)))
          item.value + table(index - 1)(size - item.weight)
        else
          table(index - 1)(size)
      }
      println(index, size, item.name, item.weight, item.value, table(index)(size))
    }
    table(items.size - 1)(knapsackSize - 1)
  }
}
