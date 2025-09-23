package com.marioflorio.prettyprinter.Engine.methods;

import static org.junit.jupiter.api.Assertions.*;

import com.marioflorio.prettyprinter.interfaceadapters.Engine;
import java.util.Collection;
import java.util.HashSet;
import org.junit.jupiter.api.Test;

public class CollectionTests {
  private static Engine engine = new Engine();

  @Test
  void formatsEmptyCollectionCorrectly() {
    Collection<String> collection = new HashSet<String>();

    String result = engine.run(collection);
    String expected = "[]";

    assertEquals(expected, result);
  }

  @Test
  void formatsEmptySingleElementCollectionCorrectly() {
    Collection<String> collection = new HashSet<String>();
    collection.add("String");

    String result = engine.run(collection);
    String expected = "['String']";

    assertEquals(expected, result);
  }

  @Test
  void formatsMultiElementCollectionCorrectly() {
    Collection<String> collection = new HashSet<String>();
    collection.add("String 1");
    collection.add("String 2");
    collection.add("String 3");
    collection.add("String 4");

    String result = engine.run(collection);
    String expected = "['String 1', 'String 2', 'String 3', 'String 4']";

    assertEquals(expected, result);
  }

  @Test
  void formatsNestedCollectionCorrectly() {
    Collection<Collection<String>> collection = new HashSet<>();
    Collection<String> innerCollectionA = new HashSet<String>();
    innerCollectionA.add("String 1");
    innerCollectionA.add("String 2");
    Collection<String> innerCollectionB = new HashSet<String>();
    innerCollectionB.add("String 3");
    innerCollectionB.add("String 4");
    collection.add(innerCollectionA);
    collection.add(innerCollectionB);

    String result = engine.run(collection);
    String expected = "[['String 1', 'String 2'], ['String 3', 'String 4']]";

    assertEquals(expected, result);
  }
}
