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
  }
}

dependencies {
  // works
  api("de.gesellix:pkg-registry-demo:0.0.1")
  // doesn't work
//  api("de.gesellix:pkg-registry-demo:+")
}
