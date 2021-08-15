lazy val chapter01 = (project in file("./Chapter01/skeleton-sbt"))
lazy val chapter02 = (project in file("./Chapter02/skeleton-sbt"))
lazy val chapter03 = (project in file("./Chapter03/skeleton-sbt"))
lazy val chapter04 = (project in file("./Chapter04/skeleton-sbt"))
lazy val chapter05 = (project in file("./Chapter05/skeleton-sbt"))
lazy val chapter06 = (project in file("./Chapter06/skeleton-sbt"))
lazy val chapter07 = (project in file("./Chapter07/skeleton-sbt"))
lazy val chapter08 = (project in file("./Chapter08/skeleton-sbt"))
lazy val chapter09 = (project in file("./Chapter09/skeleton-sbt"))
lazy val chapter10 = (project in file("./Chapter10/skeleton-sbt"))
lazy val chapter11 = (project in file("./Chapter11/skeleton-sbt"))
lazy val chapter12 = (project in file("./Chapter12/skeleton-sbt"))

lazy val root = (project in file("."))
  .aggregate(chapter01, chapter02, chapter03, chapter04, chapter05, chapter06, chapter07, chapter08, chapter09, chapter10, chapter11, chapter12)