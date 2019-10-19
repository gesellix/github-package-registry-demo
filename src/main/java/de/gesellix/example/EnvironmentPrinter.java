package de.gesellix.example;

import java.util.Map;

public class EnvironmentPrinter {

  public static void main(String[] args) {
    System.getenv()
        .entrySet()
        .stream()
        .sorted(Map.Entry.comparingByKey())
        .forEach(System.out::println);
  }
}
