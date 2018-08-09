@file:Suppress("MayBeConstant")

import org.gradle.api.Project

val codeVersion = "0.0.2"

val gitHubUser = "jffiorillo"
val gitHubRepo = "jvmbuilder"
val gitHubRepoDomain = "github.com/$gitHubUser/$gitHubRepo"

val gitTag = "release/$codeVersion"
val gitRepo = "$gitHubRepoDomain.git"

val mainRepoUrl = "https://$gitHubRepoDomain"
val taggedRepoUrl = "$mainRepoUrl/tree/$gitTag"

val Projects.libName
  get() = when (this) {
    Projects.annotations -> "jvmbuilder-annotations"
    Projects.processor -> "jvmbuilder"
  }
val libDescription = "A source code generator for Kotlin data classes to automatically create a Builder class."
val libUrl = mainRepoUrl

val libGroupId = "io.github.jffiorillo"
val libVersion = codeVersion
val Projects.libArtifactId
  get() = when (this) {
    Projects.annotations -> "jvmbuilder-annotations"
    Projects.processor -> "jvmbuilder"
  }

val Projects.publicationName
  get() = this.libArtifactId.split("-").joinToString("") { it -> it.capitalize() }.decapitalize()
val Projects.publicationTaskName
  get() = "publish${publicationName.capitalize()}PublicationToMavenRepository"

val authorName = "Jose Francisco Fiorillo"

val licenseName = "Apache-2.0"
val Project.licenseFile get() = rootDir.resolve("LICENSE")
val Project.licenseUrl get() = "$mainRepoUrl/blob/$gitTag/${licenseFile.toRelativeString(rootDir)}"

val issuesSystem = "GitHub"
val issuesUrl = "$mainRepoUrl/issues"

val bintrayRepo = "jvmbuilder"
val bintrayTags = arrayOf("kotlin", "jvmbuilder")

val Project.bintrayPublish by extraOrDefault(true)
val Project.bintrayOverride by extraOrDefault(false)
val Project.bintrayDryRun by extraOrDefault(false)
val Project.bintrayGpgSign by extraOrDefault(true)
val Project.bintrayMavenCentralSync by extraOrDefault(true)
val Project.bintrayMavenCentralClose by extraOrDefault(true)

val Project.bintrayUser by extraOrEnv("BINTRAY_USER")
val Project.bintrayKey by extraOrEnv("BINTRAY_KEY")

val Project.sonatypeUser by extraOrEnv("SONATYPE_USER")
val Project.sonatypePassword by extraOrEnv("SONATYPE_PASSWORD")

val Project.outputDir get() = buildDir.resolve("out")

enum class Projects { annotations, processor }
