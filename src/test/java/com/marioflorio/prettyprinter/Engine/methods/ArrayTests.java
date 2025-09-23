package com.marioflorio.prettyprinter.Engine.methods;

import static org.junit.jupiter.api.Assertions.*;

import com.marioflorio.prettyprinter.interfaceadapters.Engine;
import org.junit.jupiter.api.Test;

public class ArrayTests {
  private static Engine engine = new Engine();

  @Test
  void formatsEmptyArrayCorrectly() {
    String[] arr = {};

    String result = engine.run(arr);
    String expected = "[]";

    assertEquals(expected, result);
  }

  @Test
  void formatsSingleElementArrayCorrectly() {
    String[] arr = {"String"};

    String result = engine.run(arr);
    String expected = "['String']";

    assertEquals(expected, result);
  }

  @Test
  void formatsMultiElementArrayCorrectly() {
    int[] arr = {1, 2, 3, 4};

    String result = engine.run(arr);
    String expected = "[1, 2, 3, 4]";

    assertEquals(expected, result);
  }

  @Test
  void formatsNestedArrayCorrectly() {
    String[][] arr = {{"String 1", "String 2"}, {"String 1", "String 2"}};

    String result = engine.run(arr);
    String expected = "[['String 1', 'String 2'], ['String 1', 'String 2']]";

    assertEquals(expected, result);
  }
}
