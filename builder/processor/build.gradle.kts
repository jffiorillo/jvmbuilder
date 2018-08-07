plugins {
  kotlin("jvm")
  kotlin("kapt")
}

dependencies {
  compile(kotlin("stdlib"))
  compileOnly("com.google.auto.service:auto-service:1.0-rc4")
  kapt("com.google.auto.service:auto-service:1.0-rc4")
  compileOnly(project(":builder:annotations"))
  compile("me.eugeniomarletti.kotlin.metadata:kotlin-metadata:1.4.0")

  compile("com.squareup:kotlinpoet:1.0.0-RC1")
}
