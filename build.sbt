name := """THJUG"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  cache
)

libraryDependencies ++= Seq(
  "com.typesafe.slick" %% "slick" % "2.1.0",
  "net.codingwell" %% "scala-guice" % "4.0.0-beta5"
    exclude("com.google.inject","guice")
    exclude("com.google.inject.extensions","guice-multibindings")
)

libraryDependencies ++= Seq(
  "com.google.inject" % "guice" % "4.0",
  "org.postgresql" % "postgresql" % "9.3-1103-jdbc41",
  "com.google.inject.extensions" % "guice-multibindings" % "4.0"
)

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.2.1" % "test"
)

//fork in run := true
