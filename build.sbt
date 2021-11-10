name := "projet"

version := "0.1"

scalaVersion := "2.13.1"

<<<<<<< HEAD
libraryDependencies ++= Seq(
  "org.scalatest" % "scalatest_2.13" % "3.1.0" % "test",
  "com.google.firebase" % "firebase-server-sdk" % "3.0.1"
)
=======
libraryDependencies += "org.scalatest" % "scalatest_2.13" % "3.1.0" % "test"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "3.2.0"
>>>>>>> 53a3e02748bd5357c8f202c8dbc4e5f176f84d96
