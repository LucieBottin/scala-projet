import projet._

class projet_test extends org.scalatest.FunSuite with  org.scalatest.Matchers {
  test("StringToAirports with N/A elements in the middle") {
    val data = parser_airports.stringToAirports(List("29929","LFPR","closed","Guyancourt Airport","48.76029968261719",
      "2.0625","541","EU","FR","FR-J","Guyancourt","no","LFPR","N/A","N/A","N/A","http://fr.wikipedia.org/wiki/A%C3%A9rodrome_de_Guyancourt","N/A"))
    data should be (parser_airports.Airports("29929","LFPR","closed","Guyancourt Airport","48.76029968261719","2.0625",
      "541","EU","FR","FR-J","Guyancourt","no","LFPR","N/A","N/A","N/A","http://fr.wikipedia.org/wiki/A%C3%A9rodrome_de_Guyancourt","N/A"))
  }
}