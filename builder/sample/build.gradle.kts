plugins {
  kotlin("jvm")
  kotlin("kapt")
}

apply { from("generated-kotlin-sources.gradle.kts") }

dependencies {
  compile(kotlin("stdlib"))
  compile(project(":builder:annotations"))
  kapt(project(":builder:processor"))
  testCompile("org.junit.jupiter:junit-jupiter-api:5.2.0")
  testCompile("com.pholser:junit-quickcheck-core:0.8")
  testCompile("com.pholser:junit-quickcheck-generators:0.8")
}
