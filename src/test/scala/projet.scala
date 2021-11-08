import projet._

class projet_test extends org.scalatest.FunSuite with org.scalatest.Matchers {
  test("createAirports") {
    val data = airports.createAirports(
      List("29929","LFPR","closed","Guyancourt Airport","48.76029968261719","2.0625","541","EU","FR","FR-J","Guyancourt","no","LFPR","N/A","N/A","N/A","http://fr.wikipedia.org/wiki/A%C3%A9rodrome_de_Guyancourt","N/A")
    )
    data should be(
      airports.Airports("29929","LFPR","closed","Guyancourt Airport","48.76029968261719","2.0625","541","EU","FR","FR-J","Guyancourt","no","LFPR","N/A","N/A","N/A","http://fr.wikipedia.org/wiki/A%C3%A9rodrome_de_Guyancourt","N/A")
    )
  }
  
  test("parseLinesAirports") {
    val data = airports.parseLinesAirports(
      List("\"29929\",\"LFPR\",\"closed\",\"Guyancourt Airport\",\"48.76029968261719\",\"2.0625\",\"541\",\"EU\",\"FR\",\"FR-J\",\"Guyancourt\",\"no\",\"LFPR\",\"N/A\",\"N/A\",\"N/A\",\"http://fr.wikipedia.org/wiki/A%C3%A9rodrome_de_Guyancourt\",\"N/A\"")
    )
    data should be(
      List(airports.Airports("29929","LFPR","closed","Guyancourt Airport","48.76029968261719","2.0625","541","EU","FR","FR-J","Guyancourt","no","LFPR","N/A","N/A","N/A","http://fr.wikipedia.org/wiki/A%C3%A9rodrome_de_Guyancourt","N/A"))
    )
  }
}

class TestParserCSV extends org.scalatest.FunSuite with org.scalatest.Matchers {
    test("full line") {
    val data = projet.filterData(
      "\"29929\",\"LFPR\",\"closed\",\"Guyancourt Airport\",\"48.76029968261719\",\"2.0625\",\"541\",\"EU\",\"FR\",\"FR-J\",\"Guyancourt\",\"no\",\"LFPR\",\"N/A\",\"N/A\",\"N/A\",\"http://fr.wikipedia.org/wiki/A%C3%A9rodrome_de_Guyancourt\",\"N/A\""
    )
    data should be(
      List("29929","LFPR","closed","Guyancourt Airport","48.76029968261719","2.0625","541","EU","FR","FR-J","Guyancourt","no","LFPR","N/A","N/A","N/A","http://fr.wikipedia.org/wiki/A%C3%A9rodrome_de_Guyancourt","N/A")
    )
  }

  test("Empty string") {
    val data = projet.filterData("")
    data should be(List())
  }

  test("Simple string") {
    val data = projet.filterData("00A")
    data should be(List("00A"))
  }

  test("Simple quote") {
    val data = projet.filterData("6523,\"00A\",\"heliport\"")
    data should be(List("6523", "00A", "heliport"))
  }

  test("quote with comma inside") {
    val data = projet.filterData("6523,\"00A\",\"heliport\",\"Total, Rf Heliport\"")
    data should be(List("6523", "00A", "heliport", "Total, Rf Heliport"))
  }

  test("quote with quote and comma inside") {
    val data = projet.filterData(
      "\"small_airport\",\"Fazenda São José \"\"OB\"\" Airport\",-21.425199508666992"
    )
    data should be(
      List("small_airport","Fazenda São José OB Airport", "-21.425199508666992")
    )
  }

  test("quote with missing data in the middle") {
    val data = projet.filterData("\"Santa Maria\",\"no\",,,,,,\"0CA1\"")
    data should be(List("Santa Maria", "no", "N/A", "N/A", "N/A", "N/A", "N/A", "0CA1"))
  }

  test("quote with missingg data at the end") {
    val data = projet.filterData("\"14XA\",,,,,")
    data should be(List("14XA", "N/A", "N/A", "N/A", "N/A", "N/A"))
  }
}