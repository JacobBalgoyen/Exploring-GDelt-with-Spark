val sparkVersion = "2.1.0"

val sparkCore = "org.apache.spark" %% "spark-core" % sparkVersion
val sparkSQL = "org.apache.spark" %% "spark-sql" % sparkVersion

scalaVersion := "2.11.6"

lazy val commonSettings = Seq(
		//organization := "com.example",
		version := "1.0",
		scalaVersion := "2.12.1"
	)

lazy val root = (project in file(".")).
	settings(
    	name := "hello",
    	libraryDependencies ++= Seq(
    		sparkCore,
    		sparkSQL
    	)
  	)