package de.gesellix.example

import spock.lang.Specification

class LibraryTest extends Specification {

  def "someLibraryMethod returns true"() {
    setup:
    def lib = new Library()

    expect:
    true == lib.someLibraryMethod()
  }
}
