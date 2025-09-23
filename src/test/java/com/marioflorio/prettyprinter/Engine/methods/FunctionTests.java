package com.marioflorio.prettyprinter.Engine.methods;

import static org.junit.jupiter.api.Assertions.*;

import com.marioflorio.prettyprinter.interfaceadapters.Engine;
import java.util.concurrent.Callable;
import java.util.function.*;
import org.junit.jupiter.api.Test;

public class FunctionTests {
  private static Engine engine = new Engine();

  // ===== Functional interfaces =====
  private static final void runnableMethod() {}

  private static final String callableMethod() {
    return "ok";
  }

  private static final Integer functionMethod(String s) {
    return s.length();
  }

  private static final void consumerMethod(String s) {}

  private static final Integer biFunctionMethod(String s, String t) {
    return s.length() + t.length();
  }

  private static final void biConsumerMethod(String s, String t) {}

  private static final String supplierMethod() {
    return "supplied";
  }

  @Test
  void formatsRunnableCorrectly() {
    Runnable runnable = FunctionTests::runnableMethod;
    String result = engine.run(runnable);
    String expected = "[Runnable]";

    assertEquals(expected, result);
  }

  @Test
  void formatsCallableCorrectly() {
    Callable<String> callable = FunctionTests::callableMethod;
    String result = engine.run(callable);
    String expected = "[Callable]";

    assertEquals(expected, result);
  }

  @Test
  void formatsFunctionCorrectly() {
    Function<String, Integer> f = FunctionTests::functionMethod;
    String result = engine.run(f);
    String expected = "[Function]";

    assertEquals(expected, result);
  }

  @Test
  void formatsConsumerCorrectly() {
    Consumer<String> cons = FunctionTests::consumerMethod;
    String result = engine.run(cons);
    String expected = "[Consumer]";

    assertEquals(expected, result);
  }

  @Test
  void formatsBiFunctionCorrectly() {
    BiFunction<String, String, Integer> bf = FunctionTests::biFunctionMethod;
    String result = engine.run(bf);
    String expected = "[BiFunction]";

    assertEquals(expected, result);
  }

  @Test
  void formatsBiConsumerCorrectly() {
    BiConsumer<String, String> bc = FunctionTests::biConsumerMethod;
    String result = engine.run(bc);
    String expected = "[BiConsumer]";

    assertEquals(expected, result);
  }

  @Test
  void formatsSupplierCorrectly() {
    Supplier<String> sup = FunctionTests::supplierMethod;
    String result = engine.run(sup);
    String expected = "[Supplier]";

    assertEquals(expected, result);
  }
}
