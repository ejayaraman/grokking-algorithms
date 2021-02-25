package Chapter8

import scala.collection.mutable

class FindStations(availableStations: List[Station], statesNeeded: Set[String]) {

  private val foundStates: mutable.Set[String]   = collection.mutable.Set[String]()
  private val foundStations: mutable.Set[String] = collection.mutable.Set[String]()

  def stations: Set[String] = {
    for (currentStation <- availableStations) {
      if (currentStation.states.intersect(statesNeeded).nonEmpty) {
        val bestStation = findBestStation(currentStation)
        foundStations.addOne(bestStation.name)
      }
    }
    foundStations.toSet
  }

  private def findBestStation(currentBestStation: Station): Station = {
    var currentStationCount = currentBestStation.states.intersect(statesNeeded).size
    var bestStation         = currentBestStation
    for (thisStation <- availableStations) {
      if (thisStation.states
            .intersect(statesNeeded)
            .nonEmpty && thisStation.states.diff(foundStates).size > currentStationCount) {
        currentStationCount = thisStation.states.intersect(statesNeeded).size
        foundStates.addAll(thisStation.states)
        bestStation = thisStation
      }
    }
    bestStation
  }
}
