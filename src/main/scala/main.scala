import projet._

object main {
  def menu(): Any = {
    println("What do you want to do ?")
    println("1- Query")
    println("2- Reports")
    println("3- Exit")
    print("-> ")
    scala.io.StdIn.readLine() match {
      case "Query" | "1"   => query_menu()
      case "Reports" | "2" => reports_menu()
      case "Exit" | "3"    => println("Exit...")
      case _               => println("Unknown Option")
    }
  }

  def query_menu(): Any = {
    println("Enter the country or coutry code")
    print("-> ")
  }

  def reports_menu(): Any = {
    println("1- 10 countries with highest/lowest number of airports (with count).")
    println("2- Type of runways per country")
    println("3- 10 most common runway latitude")
    print("-> ")
  }

  def main(args: Array[String]): Unit = {
    val path = "./src/main/ressources/"

    menu();
  }
}
