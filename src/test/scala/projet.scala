import projet._

class projet_test extends org.scalatest.FunSuite with org.scalatest.Matchers {
  test("StringToAirports with N/A elements in the middle") {
    val data = airports.createAirports(
      List(
        "29929",
        "LFPR",
        "closed",
        "Guyancourt Airport",
        "48.76029968261719",
        "2.0625",
        "541",
        "EU",
        "FR",
        "FR-J",
        "Guyancourt",
        "no",
        "LFPR",
        "N/A",
        "N/A",
        "N/A",
        "http://fr.wikipedia.org/wiki/A%C3%A9rodrome_de_Guyancourt",
        "N/A"
      )
    )
    data should be(
      airports.Airports(
        "29929",
        "LFPR",
        "closed",
        "Guyancourt Airport",
        "48.76029968261719",
        "2.0625",
        "541",
        "EU",
        "FR",
        "FR-J",
        "Guyancourt",
        "no",
        "LFPR",
        "N/A",
        "N/A",
        "N/A",
        "http://fr.wikipedia.org/wiki/A%C3%A9rodrome_de_Guyancourt",
        "N/A"
      )
    )
  }
  test("parse line airports") {
    val data = airports.parseLinesAirports(
      List(
        "\"29929\",\"LFPR\",\"closed\",\"Guyancourt Airport\",\"48.76029968261719\",\"2.0625\",\"541\",\"EU\",\"FR\",\"FR-J\",\"Guyancourt\",\"no\",\"LFPR\",\"N/A\",\"N/A\",\"N/A\",\"http://fr.wikipedia.org/wiki/A%C3%A9rodrome_de_Guyancourt\",\"N/A\""
      )
    )
    data should be(
      List(
        airports.Airports(
          "29929",
          "LFPR",
          "closed",
          "Guyancourt Airport",
          "48.76029968261719",
          "2.0625",
          "541",
          "EU",
          "FR",
          "FR-J",
          "Guyancourt",
          "no",
          "LFPR",
          "N/A",
          "N/A",
          "N/A",
          "http://fr.wikipedia.org/wiki/A%C3%A9rodrome_de_Guyancourt",
          "N/A"
        )
      )
    )
  }
}

class TestParserCSV extends org.scalatest.FunSuite with org.scalatest.Matchers {
  test("Empty string") {
    val data = projet.filterData("")
    data should be(List())
  }

  test("simple") {
    val data = projet.filterData(
      "\"29929\",\"LFPR\",\"closed\",\"Guyancourt Airport\",\"48.76029968261719\",\"2.0625\",\"541\",\"EU\",\"FR\",\"FR-J\",\"Guyancourt\",\"no\",\"LFPR\",\"N/A\",\"N/A\",\"N/A\",\"http://fr.wikipedia.org/wiki/A%C3%A9rodrome_de_Guyancourt\",\"N/A\""
    )
    data should be(
      List(
        "\"29929\"",
        "\"LFPR\"",
        "\"closed\"",
        "\"Guyancourt Airport\"",
        "\"48.76029968261719\"",
        "\"2.0625\"",
        "\"541\"",
        "\"EU\"",
        "\"FR\"",
        "\"FR-J\"",
        "\"Guyancourt\"",
        "\"no\"",
        "\"LFPR\"",
        "\"N/A\"",
        "\"N/A\"",
        "\"N/A\"",
        "\"http://fr.wikipedia.org/wiki/A%C3%A9rodrome_de_Guyancourt\"",
        "\"N/A\""
      )
    )
  }

  test("List String") {
    val data = projet.filterData("airport")
    data should be(List("airport"))
  }

  test("No comma inside quote") {
    val data = projet.filterData("\"avion\",5432,\"volant\"")
    data should be(List("\"avion\"", "5432", "\"volant\""))
  }

  test("Comma inside quote") {
    val data = projet.filterData("\"avion,volant\",3,\"comma, coucou\"")
    data should be(List("\"avion,volant\"", "3", "\"comma, coucou\""))
  }

  test("Quote and comma inside quote") {
    val data = projet.filterData(
      "\"avion \"\"FR\"\" CDG\",-21.4249589508666992"
    )
    data should be(
      List("\"avion \"\"FR\"\" CDG\"", "-21.4249589508666992")
    )
  }

  test("Null elements in the middle") {
    val data = projet.filterData("\"avion\",,,,2")
    data should be(List("\"avion\"", "N/A", "N/A", "N/A", "2"))
  }

  test("Null elements at the end") {
    val data = projet.filterData("salut,,,,,")
    data should be(List("salut", "N/A", "N/A", "N/A", "N/A", "N/A"))
  }
}
