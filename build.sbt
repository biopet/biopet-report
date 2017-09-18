organization := "nl.biopet"
name := "biopetReport"
 
version := "1.0"

lazy val biopetReport = (project in file(".")).enablePlugins(PlayScala)

resolvers += Resolver.mavenLocal

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
      
resolvers += "Akka Snapshot Repository" at "http://repo.akka.io/snapshots/"

scalaVersion := "2.11.11"

libraryDependencies ++= Seq( jdbc , ehcache , ws , specs2 % Test , guice )

libraryDependencies += "nl.biopet" % "biopet-summary_2.11" % "0.1.0-SNAPSHOT"

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  

