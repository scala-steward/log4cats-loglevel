Global / onChangedBuildSource := ReloadOnSourceChanges

inThisBuild(
  List(
    name := "log4cats-loglevel",
    organization := "com.rpiaggio",
    scalaVersion := "2.13.4",
    homepage := Some(url("https://github.com/rpiaggio/log4cats-loglevel")),
    licenses += ("BSD 3-Clause", url(
      "http://opensource.org/licenses/BSD-3-Clause"
    )),
    developers := List(
      Developer(
        "rpiaggio",
        "Raúl Piaggio",
        "rpiaggio@gmail.com",
        url("http://github.com/rpiaggio")
      )
    )
  )
)

lazy val root = project
  .in(file("."))
  .settings(
    name := "log4cats-loglevel",
    moduleName := "log4cats-loglevel",
    libraryDependencies ++= Seq(
      "org.typelevel"     %%% "cats-effect"   % "2.3.2",
      "io.chrisdavenport" %%% "log4cats-core" % "1.1.1"
    ),
    useYarn := true,
    npmDependencies in Compile ++= Seq(
      "loglevel" -> "1.7.1"
    ),
    scmInfo := Some(
      ScmInfo(
        url("https://github.com/rpiaggio/log4cats-loglevel"),
        "scm:git:git@github.com:rpiaggio/log4cats-loglevel.git",
        Some("scm:git:git@github.com:rpiaggio/log4cats-loglevel.git")
      )
    ),
    pomIncludeRepository := { _ => false },
    scalacOptions ~= (_.filterNot(
      Set(
        // By necessity facades will have unused params
        "-Wdead-code",
        "-Wunused:params",
        "-Wunused:explicits"
      )
    ))
  )
  .enablePlugins(ScalaJSBundlerPlugin)

sonatypeProfileName := "com.rpiaggio"
