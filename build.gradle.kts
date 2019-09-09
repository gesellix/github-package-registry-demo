plugins {
  `java-library`
  groovy
  `maven-publish`
  id("io.freefair.github.package-registry-maven-publish") version "4.0.2"
  id("com.github.ben-manes.versions") version "0.24.0"
}

repositories {
  jcenter()
}

dependencies {
  // This dependency is exported to consumers, that is to say found on their compile classpath.
  api("org.apache.commons:commons-math3:3.6.1")
  // This dependency is used internally, and not exposed to consumers on their own compile classpath.
  implementation("com.google.guava:guava:28.1-jre")
  // Use the latest Groovy version for Spock testing
  testImplementation("org.codehaus.groovy:groovy-all:2.5.7")
  // Use the awesome Spock testing and specification framework even with Java
  testImplementation("org.spockframework:spock-core:1.3-groovy-2.5")
  testImplementation("junit:junit:4.12")
}

fun findProperty(s: String) = project.findProperty(s) as String?

github {
  slug.set("${property("github.package-registry.owner")}/${property("github.package-registry.repository")}")
  username.set(System.getenv("GITHUB_ACTOR") ?: findProperty("github.package-registry.username"))
  token.set(System.getenv("GITHUB_TOKEN") ?: findProperty("github.package-registry.password"))
}

publishing {
  publications {
    register("publication-name", MavenPublication::class) {
      from(components["java"])
      groupId = "de.gesellix"
      artifactId = "pkg-registry-demo"
      version = "0.0.1"
    }
  }
}
