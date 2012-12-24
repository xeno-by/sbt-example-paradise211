An example SBT project which uses macro paradise (Scala macro-paradise, SBT 0.13)

Follow the instructions at http://scalamacros.org/download.html to obtain a build of macro paradise.
Make sure you use SBT 0.13, because otherwise you'll have problems with https://github.com/harrah/xsbt/issues/626.
Update: Actually, SBT 0.12.2-RC1 is good enough.

Also note that currently SBT doesn't support recompilation of macro clients if macro implementation has changed: https://github.com/harrah/xsbt/issues/399.

Huge thanks to Paul Butcher, who set up and kindly published his paradise build at https://github.com/paulbutcher/ScalaMock/blob/typemacros/project/Build.scala.
