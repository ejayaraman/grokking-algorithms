package Chapter8

import scala.collection.mutable

//Second Iteration
class FindStations {

  val foundStates: mutable.Set[String]   = collection.mutable.Set[String]()
  val foundStations: mutable.Set[String] = collection.mutable.Set[String]()

  def stations(stations: List[Station], statesNeeded: Set[String]): Set[String] = {
    for (station <- stations) {
      if (station.states.intersect(statesNeeded).nonEmpty) {
        var stationCount = station.states.intersect(statesNeeded).size
        var bestStation  = station.name
        for (station <- stations) {
          if (station.states.intersect(statesNeeded).nonEmpty) {
            if (station.states.diff(foundStates).size > stationCount) {
              stationCount = station.states.intersect(statesNeeded).size
              foundStates.addAll(station.states)
              bestStation = station.name
            }
          }
        }
        foundStations.addOne(bestStation)
      }
    }
    foundStations.toSet
  }
}
