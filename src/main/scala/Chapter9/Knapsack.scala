package Chapter9

//Third Iteration
object Knapsack {
  def apply(items: List[Item], knapsackSize: Int): Int = {
    val table: Array[Array[Int]] = Array.ofDim[Int](items.size, knapsackSize)

    for {
      (item, itemIndex) <- items.zipWithIndex
      knapsackIndex     <- 0 until knapsackSize
    } {
      val sackSize       = knapsackIndex + 1
      val thisItemValue  = item.value
      val thisItemWeight = item.weight

      table(itemIndex)(knapsackIndex) = if (itemIndex == 0) {
        if (item.weight <= sackSize)
          thisItemValue
        else
          0
      } else {
        val currentValue                 = table(itemIndex - 1)(knapsackIndex)
        lazy val valueForRemainingWeight = table(itemIndex - 1)(knapsackIndex - item.weight)

        if (thisItemWeight == sackSize && thisItemValue > currentValue)
          item.value
        else if (thisItemWeight < sackSize && (thisItemValue + valueForRemainingWeight > currentValue))
          thisItemValue + valueForRemainingWeight
        else
          currentValue
      }
      println(itemIndex, knapsackIndex, item.name, item.weight, item.value, table(itemIndex)(knapsackIndex))
    }
    table(items.size - 1)(knapsackSize - 1)
  }
}
