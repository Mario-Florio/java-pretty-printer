package com.marioflorio.prettyprinter.Engine.methods;

import static org.junit.jupiter.api.Assertions.*;

import com.marioflorio.prettyprinter.interfaceadapters.Engine;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ListTests {
  private static Engine engine = new Engine();

  @Test
  void formatsEmptyListCorrectly() {
    List<String> list = new ArrayList<>();

    String result = engine.run(list);
    String expected = "[]";

    assertEquals(expected, result);
  }

  @Test
  void formatsSingleElementListCorrectly() {
    List<String> list = new ArrayList<>();
    list.add("String 1");

    String result = engine.run(list);
    String expected = "['String 1']";

    assertEquals(expected, result);
  }

  @Test
  void formatsMulitElementArrayCorrectly() {
    List<String> list = new ArrayList<>();
    list.add("String 1");
    list.add("String 2");
    list.add("String 3");
    list.add("String 4");

    String result = engine.run(list);
    String expected = "['String 1', 'String 2', 'String 3', 'String 4']";

    assertEquals(expected, result);
  }

  @Test
  void formatsNestedListCorrectly() {
    List<List<?>> list = new ArrayList<>();
    List<String> innerListA = new ArrayList<>();
    List<Integer> innerListB = new ArrayList<>();
    innerListA.add("String 1");
    innerListA.add("String 2");
    innerListB.add(1);
    innerListB.add(2);
    list.add(innerListA);
    list.add(innerListB);

    String result = engine.run(list);
    String expected = "[['String 1', 'String 2'], [1, 2]]";

    assertEquals(expected, result);
  }
}
