import sbt._
import Keys._

object BuildSettings {
  val buildSettings = Defaults.defaultSettings ++ Seq(
    organization := "org.scalamacros",
    version := "1.0.0",
    scalaVersion := "2.10.0",
    scalacOptions ++= Seq(),
    // follow the instructions at http://scalamacros.org/download.html to obtain a build of macro paradise
    // make sure you use SBT 0.13, because otherwise you'll have problems with https://github.com/harrah/xsbt/issues/626
    // upd: actually, SBT 0.12.2-RC1 is good enough
    scalaHome := Some(file("/Users/xeno_by/Projects/Kepler_typemacros/build/pack")),
    unmanagedBase := file("/Users/xeno_by/Projects/Kepler_typemacros/build/pack/lib")
  )
}

object MyBuild extends Build {
  import BuildSettings._

  lazy val root: Project = Project(
    "root",
    file("core"),
    settings = buildSettings
  ) aggregate(macros, core)

  lazy val macros: Project = Project(
    "macros",
    file("macros"),
    settings = buildSettings ++ Seq(
      libraryDependencies <+= (scalaVersion)("org.scala-lang" % "scala-reflect" % _))
  )

  lazy val core: Project = Project(
    "core",
    file("core"),
    settings = buildSettings
  ) dependsOn(macros)
}