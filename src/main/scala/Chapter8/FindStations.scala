package Chapter8

import scala.collection.mutable

//Third Iteration
class FindStations {

  val foundStates: mutable.Set[String]   = collection.mutable.Set[String]()
  val foundStations: mutable.Set[String] = collection.mutable.Set[String]()

  def stations(stations: List[Station], statesNeeded: Set[String]): Set[String] = {
    for (currentStation <- stations) {
      if (currentStation.states.intersect(statesNeeded).nonEmpty) {
        var currentStationCount = currentStation.states.intersect(statesNeeded).size
        var bestStation         = currentStation.name
        for (thisStation <- stations) {
          if (thisStation.states
                .intersect(statesNeeded)
                .nonEmpty && thisStation.states.diff(foundStates).size > currentStationCount) {
            currentStationCount = thisStation.states.intersect(statesNeeded).size
            foundStates.addAll(thisStation.states)
            bestStation = thisStation.name
          }
        }
        foundStations.addOne(bestStation)
      }
    }
    foundStations.toSet
  }
}
