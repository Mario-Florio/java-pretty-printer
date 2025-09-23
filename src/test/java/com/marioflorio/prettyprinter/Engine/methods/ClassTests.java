package com.marioflorio.prettyprinter.Engine.methods;

import static org.junit.jupiter.api.Assertions.*;

import com.marioflorio.prettyprinter.__utils__.TestClass;
import com.marioflorio.prettyprinter.__utils__.TestClass2;
import com.marioflorio.prettyprinter.interfaceadapters.Engine;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ClassTests {
  private static Engine engine = new Engine();

  @Test
  void formatsClassCorreclty() {
    String result = engine.run(ArrayList.class);
    String expected = "[class ArrayList]";

    assertEquals(expected, result);
  }

  @Test
  void formatsAbstractClassCorrectly() {
    String result = engine.run(AbstractList.class);
    String expected = "[class AbstractList]";

    assertEquals(expected, result);
  }

  @Test
  void formatsInterfaceClassCorrectly() {
    String result = engine.run(List.class);
    String expected = "[interface List]";

    assertEquals(expected, result);
  }

  @Test
  void formatsCustomClassCorrectly() {
    String result = engine.run(TestClass.class);
    String expected =
        "[class TestClass] {staticProp: 'Static prop', staticMethod: [Method: staticMethod]}";

    assertEquals(expected, result);
  }

  @Test
  void formatsCustomClassCorrectly2() {
    String result = engine.run(TestClass2.class);
    String expected =
        "[class TestClass2] {staticProp2: 'Static prop', staticMethod2: [Method: staticMethod2]}";

    assertEquals(expected, result);
  }
}
