organization := "com.ivan.nikolov"

name := "aop-sbt"

scalaVersion := "2.12.4"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

javaOptions ++= Seq("-target", "1.8", "-source", "1.8")

publishMavenStyle := true

libraryDependencies ++= {
  Seq(
    "org.json4s" %% "json4s-jackson" % "3.6.11",
    "org.scalatest" %% "scalatest" % "3.0.4" % "test",
    "org.mockito" % "mockito-all" % "1.10.19" % "test" // mockito for tests
  )
}