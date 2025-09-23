package com.marioflorio.prettyprinter.Modeler;

import static org.junit.jupiter.api.Assertions.*;

import com.marioflorio.prettyprinter.core.entities.Doc;
import com.marioflorio.prettyprinter.core.entities.Doc.Text;
import com.marioflorio.prettyprinter.core.entities.Doc.Wrapper;
import com.marioflorio.prettyprinter.core.entities.Doc.WrapperType;
import com.marioflorio.prettyprinter.core.usecases.Modeler;
import java.util.concurrent.Callable;
import java.util.function.*;
import org.junit.jupiter.api.Test;

public class FunctionTests {

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
  void modelsRunnableCorrectly() {
    Runnable runnable = FunctionTests::runnableMethod;
    Doc result = Modeler.model(runnable);
    Doc expected = getCyanWrappedTextNode("[Runnable]");

    assertEquals(expected, result);
  }

  @Test
  void modelsCallableCorrectly() {
    Callable<String> callable = FunctionTests::callableMethod;
    Doc result = Modeler.model(callable);
    Doc expected = getCyanWrappedTextNode("[Callable]");

    assertEquals(expected, result);
  }

  @Test
  void modelsFunctionCorrectly() {
    Function<String, Integer> f = FunctionTests::functionMethod;
    Doc result = Modeler.model(f);
    Doc expected = getCyanWrappedTextNode("[Function]");

    assertEquals(expected, result);
  }

  @Test
  void modelsConsumerCorrectly() {
    Consumer<String> cons = FunctionTests::consumerMethod;
    Doc result = Modeler.model(cons);
    Doc expected = getCyanWrappedTextNode("[Consumer]");

    assertEquals(expected, result);
  }

  @Test
  void modelsBiFunctionCorrectly() {
    BiFunction<String, String, Integer> bf = FunctionTests::biFunctionMethod;
    Doc result = Modeler.model(bf);
    Doc expected = getCyanWrappedTextNode("[BiFunction]");

    assertEquals(expected, result);
  }

  @Test
  void modelsBiConsumerCorrectly() {
    BiConsumer<String, String> bc = FunctionTests::biConsumerMethod;
    Doc result = Modeler.model(bc);
    Doc expected = getCyanWrappedTextNode("[BiConsumer]");

    assertEquals(expected, result);
  }

  @Test
  void modelsSupplierCorrectly() {
    Supplier<String> sup = FunctionTests::supplierMethod;
    Doc result = Modeler.model(sup);
    Doc expected = getCyanWrappedTextNode("[Supplier]");

    assertEquals(expected, result);
  }

  private static Doc getCyanWrappedTextNode(String textVal) {
    return new Wrapper(new Text(textVal), WrapperType.FG_COLOR_CYAN);
  }
}
