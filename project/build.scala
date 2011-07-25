import sbt._
import Keys._

object TheBuild extends Build {

	lazy val root = Project("root", file("."))
		.settings(ScctPlugin.scctSettings :_*)
}