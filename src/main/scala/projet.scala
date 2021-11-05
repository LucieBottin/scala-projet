import scala.collection.MapView
import scala.io.BufferedSource

object projet extends App {
  import scala.io.Source
  def readData: List[String] = Source
    .fromFile("resources/airports.csv", "utf-8")
    .mkString
    .split("\n")
    .toList
  def filterData(line: String, result: Vector[String] = Vector(), tmp: String = "", index: Int = 0, quote: Boolean = false): List[String] = (line,quote) match {
      case (line, _) if line.length == 0 => result.toList
      case (line, _) if index == line.length() && line(index - 1) == ',' => (result :+ "N/A").toList.filter{x => x != ""} // end line with missing data
      case (line, _) if index == line.length() => (result :+ tmp).toList.filter{el : String => el != ""} // end line + add ""
      case (line, false) if line(index) == '"' => filterData(line, result, tmp + "\"", index + 1, true) // quote detected
      case (line, true) if line(index) == '"' && index != (line.length() - 1) && line(index + 1) == ',' => filterData(line, result :+ (tmp + "\""), "", index + 1, false) // add the whole string to re
      case (line, false) if line(index) == ',' && index != (line.length() - 1) && line(index + 1) == ','  => filterData(line, result :+ tmp :+ "N/A", "", index + 1, false)  // missing data
      case (line, false) if line(index) == ',' => filterData(line, result :+ tmp, "", index + 1, false)  // comma error : add nothing to res
      case _ => filterData(line, result, tmp + line(index), index + 1, quote) // Add the char to the tmp accumulator and next char
    }
}

object airports {
    case class Airports(id: String, ident: String, `type`: String, name: String, latitude_deg: String, longitude_deg: String,
      elevation_ft: String, continent: String, iso_country: String, iso_region: String, municipality: String, scheduled_service: String,
      gps_code: String, iata_code: String, local_code: String, home_link: String, wikipedia_link: String, keywords: String)

    def parseLinesAirports(list : List[String]): List[Airports] = {
      val ui = list.map{line => {
          createAirports(projet.filterData(line))
        }
      }.toList
      println(ui(1))
      ui
    }

    def createAirports(l: List[String]): Airports = Airports(l(0), l(1), l(2), l(3), l(4), l(5), l(6), l(7), l(8), l(9),
      l(10), l(11), l(12), l(13), l(14), l(15), l(16), l(17))
}