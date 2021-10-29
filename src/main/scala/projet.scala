import scala.collection.MapView 
import scala.io.BufferedSource

  object parser_airports {
    case class Airports(id: String, ident: String, `type`: String, name: String, latitude_deg: String, longitude_deg: String,
      elevation_ft: String, continent: String, iso_country: String, iso_region: String, municipality: String, scheduled_service: String,
      gps_code: String, iata_code: String, local_code: String, home_link: String, wikipedia_link: String, keywords: String)

    def parseLinesAirports(l : List[String]): String = {
    val ui : List[Airports] = l.map{list => {
    stringToAirports(projet.read_data)}
  }.toList
  println(ui)
  val oui : String = "oui"
    oui
}

    def stringToAirports(l: List[String]): Airports = Airports(l(0), l(1), l(2), l(3), l(4), l(5), l(6), l(7), l(8), l(9),
      l(10), l(11), l(12), l(13), l(14), l(15), l(16), l(17))
  }

object projet extends App {
  import scala.io.Source
  def read_data : List[String] = {
    println("id, ident, type, name, latitude_deg, longitude_deg, elevation_ft, continent, iso_country, iso_region, municipality, scheduled_service, gps_code, iata_code, local_code, home_link, wikipedia_link, keywords")
    val dt : List[String]  = Source.fromFile("resources/airports.csv", "utf-8").getLines.toList
    val dt2 : List[List[String]] = dt.map(_.split("\n").toList)
    dt2.flatten
  }
}
