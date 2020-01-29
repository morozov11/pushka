import sbt.Keys.publishArtifact

licenses      += ("Apache-2.0", url("http://www.apache.org/licenses/"))

scalaVersion := "2.13.1"

version := "0.8.1-sevts"


val commonSettings = Seq(
  organization := "jellical",
  version := "0.8.1-sevts",
  scalaVersion := "2.13.1",
  libraryDependencies += "org.scalatest" %%% "scalatest" % "3.1.0" % "test",
  scalacOptions ++= Seq(
    "-deprecation",
    "-feature",
    "-language:postfixOps",
    "-language:implicitConversions",
    "-Ymacro-annotations"
  )
)

lazy val core = crossProject.crossType(CrossType.Pure).
  settings(commonSettings: _*).
  settings(
    scalaVersion := "2.13.1",
    normalizedName := "pushka-core",
    libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-compiler" % scalaVersion.value % "provided",
      "org.scala-lang" % "scala-reflect" % scalaVersion.value % "provided"
    ),
    //addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.full),
    sourceGenerators in Compile += sourceManaged in Compile map GenTuples,
    licenses      += ("Apache-2.0", url("http://www.apache.org/licenses/")),
    version := "0.8.1-sevts",
    publishMavenStyle := true,
    publishArtifact in Test := false,
    pomIncludeRepository := { _ => false },
    publishMavenStyle       := true,
    bintrayOrganization     := None,
    bintrayRepository := "pushka"
  )

lazy val coreJS = core.js
lazy val coreJVM = core.jvm

lazy val json = crossProject.crossType(CrossType.Full).
  settings(commonSettings: _*).
  settings(
    scalaVersion := "2.13.1",
    normalizedName := "pushka-json",
    unmanagedSourceDirectories in Test += baseDirectory.value / ".." / "test-src",
    licenses      += ("Apache-2.0", url("http://www.apache.org/licenses/")),
    version := "0.8.1-sevts",
    publishMavenStyle := true,
    publishArtifact in Test := false,
    pomIncludeRepository := { _ => false },
    publishMavenStyle       := true,
    bintrayOrganization     := None,
    bintrayRepository := "pushka"
  ).
  jvmSettings(
    libraryDependencies += "org.typelevel" %% "jawn-parser" % "1.0.0",
    libraryDependencies += "org.typelevel" %% "jawn-ast" % "1.0.0"
  ).
  dependsOn(core)

lazy val jsonJS = json.js
lazy val jsonJVM = json.jvm

