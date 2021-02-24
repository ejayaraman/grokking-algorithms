package Chapter8

import scala.collection.mutable

//First Iteration
class FindStations {

  val foundStates: mutable.Set[String]   = collection.mutable.Set[String]()
  val foundStations: mutable.Set[String] = collection.mutable.Set[String]()

  def stations(stations: List[Station], statesNeeded: Set[String]): Set[String] = {
    for (state <- statesNeeded) {
      var stationCount = 0
      var bestStation  = ""
      for (station <- stations) {
        if (station.states.intersect(statesNeeded).nonEmpty) {
          if (station.states.diff(foundStates).size > stationCount) {
            stationCount = station.states.intersect(statesNeeded).size
            foundStates.addAll(station.states)
            bestStation = station.name
          }
        }
      }
      if (bestStation.nonEmpty)
        foundStations.addOne(bestStation)
    }
    foundStations.toSet
  }

}
