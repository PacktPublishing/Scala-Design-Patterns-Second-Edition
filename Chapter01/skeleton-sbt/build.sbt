organization := "com.ivan.nikolov"

name := "skeleton-sbt"

scalaVersion := "2.12.4"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

javaOptions ++= Seq("-target", "1.8", "-source", "1.8")

publishMavenStyle := true

libraryDependencies ++= {
  val sparkVersion = "2.2.0"
  Seq(
    "org.apache.spark" % "spark-core_2.11" % sparkVersion % "provided",
    "com.datastax.spark" % "spark-cassandra-connector_2.11" % "2.0.13",
    "org.scalatest" %% "scalatest" % "3.0.4" % "test",
    "org.mockito" % "mockito-all" % "1.10.19" % "test" // mockito for tests
  )
}