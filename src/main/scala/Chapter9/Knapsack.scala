package Chapter9

//First Iteration
object Knapsack {

  def apply(items: List[Item], knapsackSize: Int): Int = {
    val table: Array[Array[Int]] = Array.ofDim[Int](items.size, knapsackSize)

    for {
      (item, index) <- items.zipWithIndex
      size          <- 0 until knapsackSize
    } {
      val sackSize = size + 1
      if (index == 0) {
        if (item.weight <= sackSize)
          table(index)(size) = item.value
        else {
          table(index)(size) = 0
        }
      } else {
        if (item.weight == sackSize) {
          if (item.value > table(index - 1)(sackSize)) {
            table(index)(size) = item.value
          } else {
            table(index)(size) = table(index - 1)(size)
          }
        }
        if (item.weight > sackSize) {
          table(index)(size) = table(index - 1)(size)
        }
        if (item.weight < sackSize) {
          if (item.value + table(index - 1)(size - item.weight) > table(index - 1)(size)) {
            table(index)(size) = item.value + table(index - 1)(size - item.weight)
          } else {
            table(index)(size) = table(index - 1)(size)
          }
        }
      }
      println(index, size, item.name, item.weight, item.value, table(index)(size))
    }
    table(items.size - 1)(knapsackSize - 1)
  }
}
