package com.marioflorio.prettyprinter.Engine.methods;

import static org.junit.jupiter.api.Assertions.*;

import com.marioflorio.prettyprinter.interfaceadapters.Engine;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class MapTests {
  private static Engine engine = new Engine();

  @Test
  void formatsEmptyMapCorrectly() {
    Map<String, Integer> map = new HashMap<>();

    String result = engine.run(map);
    String expected = "{}";

    assertEquals(expected, result);
  }

  @Test
  void formatsSingleElementMapCorrectly() {
    Map<String, Integer> map = new HashMap<>();
    map.put("prop", 1);

    String result = engine.run(map);
    String expected = "{prop: 1}";

    assertEquals(expected, result);
  }

  @Test
  void formatsMultiElementMapCorrectly() {
    Map<String, Integer> map = new LinkedHashMap<>();
    map.put("prop", 1);
    map.put("prop2", 2);
    map.put("prop3", 3);
    map.put("prop4", 4);

    String result = engine.run(map);
    String expected = "{prop: 1, prop2: 2, prop3: 3, prop4: 4}";

    assertEquals(expected, result);
  }
}
