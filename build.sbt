organization := "com.github.biopet"
name := "biopetReport"

lazy val biopetReport = (project in file(".")).enablePlugins(PlayScala)

resolvers += Resolver.mavenLocal

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
      
resolvers += "Akka Snapshot Repository" at "http://repo.akka.io/snapshots/"

scalaVersion := "2.11.11"

libraryDependencies += "com.typesafe.play" %% "play-slick" % "3.0.0"

libraryDependencies ++= Seq( jdbc , ehcache , ws , specs2 % Test , guice )

libraryDependencies += "com.github.biopet" %% "biopet-summary" % "0.1.0-SNAPSHOT"

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )
