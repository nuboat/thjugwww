name := """THJUG"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  jdbc,
  cache
)

libraryDependencies ++= Seq(
  "com.google.inject" % "guice" % "4.0",
  "com.google.inject.extensions" % "guice-multibindings" % "4.0",
  "net.codingwell" %% "scala-guice" % "4.0.0-beta5"
    exclude("com.google.inject","guice")
    exclude("com.google.inject.extensions","guice-multibindings")
)

//fork in run := true
