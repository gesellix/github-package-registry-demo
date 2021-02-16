plugins {
  `java-library`
}

repositories {
  jcenter()
  maven {
    // works
    setUrl("https://maven.pkg.github.com/gesellix/github-package-registry-demo")
    // doesn't work
//    setUrl("https://maven.pkg.github.com/gesellix")

    credentials {
      username = System.getenv("GITHUB_ACTOR") ?: findProperty("github.package-registry.username") as String
      password = System.getenv("GITHUB_TOKEN") ?: findProperty("github.package-registry.password") as String
    }
  }
}

dependencies {
  // works
  api("de.gesellix:pkg-registry-demo:0.0.1")
  // doesn't work
//  api("de.gesellix:pkg-registry-demo:+")
//  api("de.gesellix:pkg-registry-demo:latest")
//  api("de.gesellix:pkg-registry-demo:latest.release")
//  api("de.gesellix:pkg-registry-demo:(0+,)")
}
