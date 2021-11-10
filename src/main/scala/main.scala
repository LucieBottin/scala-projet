import projet._
import org.apache.spark.sql.SparkSession

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
    val spark = SparkSession.builder().appName("projet-scala").config("spark.master", "local").getOrCreate();
    val data = spark.read.format("csv").option("header", true).load("resources/runways.csv").toDF();
    data.createOrReplaceTempView("runways");
    val data2 = spark.read.format("csv").option("header", true).load("resources/airports.csv").toDF();
    data2.createOrReplaceTempView("airports");

    println("Enter country code : ")
    val choice = scala.io.StdIn.readLine()

    val subQuery = spark.sql("SELECT ident FROM airports WHERE iso_country = '" + choice + "'");
    val selectedData = spark.sql("SELECT id FROM runways WHERE airport_ident = " + subQuery);

    selectedData.show();
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
