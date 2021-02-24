package chapter8

import Chapter8.{FindStations, Station}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class FindStationsSpec extends AnyFlatSpec with Matchers {

  "FindStations" should "find the stations covering the required states" in {
    val statesNeeded = Set("mt", "wa", "or", "id", "nv", "ut", "ca", "az")
    val one          = Station("one", Set("id", "nv", "ut"))
    val two          = Station("two", Set("wa", "id", "mt"))
    val three        = Station("three", Set("or", "nv", "ca"))
    val four         = Station("four", Set("nv", "ut"))
    val five         = Station("five", Set("ca", "az"))

    val stations = List(one, two, three, four, five)

    new FindStations().stations(stations, statesNeeded) shouldBe Set("two", "three", "one", "five")
  }

  "FindStations" should "find the approximate stations covering the required states" in {
    val statesNeeded = Set("wa", "id", "mt", "or", "nv", "ca", "ut", "az", "tn")
    val one          = Station("one", Set("id", "nv", "ut"))
    val two          = Station("two", Set("wa", "id", "mt"))
    val three        = Station("three", Set("or", "nv", "ca"))
    val four         = Station("four", Set("nv", "ut"))
    val five         = Station("five", Set("ca", "az"))

    val stations = List(one, two, three, four, five)

    new FindStations().stations(stations, statesNeeded) shouldBe Set("two", "three", "one", "five")
  }

  "FindStations" should "find the stations covering just the required states" in {
    val statesNeeded = Set("id", "or", "wa")
    val one          = Station("one", Set("id", "nv", "ut"))
    val two          = Station("two", Set("wa", "id", "mt"))
    val three        = Station("three", Set("or", "nv", "ca"))
    val four         = Station("four", Set("nv", "ut"))
    val five         = Station("five", Set("ca", "az"))

    val stations = List(one, two, three, four, five)

    new FindStations().stations(stations, statesNeeded) shouldBe Set("two", "three")
  }
}
