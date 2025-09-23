package com.marioflorio.prettyprinter.Modeler;

import static org.junit.jupiter.api.Assertions.*;

import com.marioflorio.prettyprinter.core.entities.Doc;
import com.marioflorio.prettyprinter.core.entities.Doc.Concat;
import com.marioflorio.prettyprinter.core.entities.Doc.IndentBlock;
import com.marioflorio.prettyprinter.core.entities.Doc.LineBreak;
import com.marioflorio.prettyprinter.core.entities.Doc.Text;
import com.marioflorio.prettyprinter.core.entities.Doc.Wrapper;
import com.marioflorio.prettyprinter.core.entities.Doc.WrapperType;
import com.marioflorio.prettyprinter.core.usecases.Modeler;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ListTests {

  @Test
  void modelsEmptyListCorrectly() {
    List<String> list = new ArrayList<>();

    Doc result = Modeler.model(list);
    Doc expected = new Wrapper(new Concat(List.of()), WrapperType.SQUARE_BRACKETS);

    assertEquals(expected, result);
  }

  @Test
  void modelsSingleElementListCorrectly() {
    List<String> list = new ArrayList<>();
    list.add("String 1");

    Doc result = Modeler.model(list);
    Doc expected =
        new Wrapper(
            new Concat(
                List.of(
                    new LineBreak(),
                    new IndentBlock(
                        List.of(
                            new Concat(
                                List.of(
                                    new Wrapper(
                                        new Wrapper(new Text("String 1"), WrapperType.SINGLE_QUOTE),
                                        WrapperType.FG_COLOR_GREEN))),
                            new LineBreak())))),
            WrapperType.SQUARE_BRACKETS);

    assertEquals(expected, result);
  }

  @Test
  void modelsMultiElementListCorrectly() {
    List<String> list = new ArrayList<>();
    list.add("String 1");
    list.add("String 2");
    list.add("String 3");
    list.add("String 4");

    Doc result = Modeler.model(list);
    Doc expected =
        new Wrapper(
            new Concat(
                List.of(
                    new LineBreak(),
                    new IndentBlock(
                        List.of(
                            new Concat(
                                List.of(
                                    new Wrapper(
                                        new Wrapper(new Text("String 1"), WrapperType.SINGLE_QUOTE),
                                        WrapperType.FG_COLOR_GREEN),
                                    new Text(", "))),
                            new LineBreak(),
                            new Concat(
                                List.of(
                                    new Wrapper(
                                        new Wrapper(new Text("String 2"), WrapperType.SINGLE_QUOTE),
                                        WrapperType.FG_COLOR_GREEN),
                                    new Text(", "))),
                            new LineBreak(),
                            new Concat(
                                List.of(
                                    new Wrapper(
                                        new Wrapper(new Text("String 3"), WrapperType.SINGLE_QUOTE),
                                        WrapperType.FG_COLOR_GREEN),
                                    new Text(", "))),
                            new LineBreak(),
                            new Concat(
                                List.of(
                                    new Wrapper(
                                        new Wrapper(new Text("String 4"), WrapperType.SINGLE_QUOTE),
                                        WrapperType.FG_COLOR_GREEN))),
                            new LineBreak())))),
            WrapperType.SQUARE_BRACKETS);

    assertEquals(expected, result);
  }

  @Test
  void modelsNestedListCorrectly() {
    List<List<?>> list = new ArrayList<>();
    List<String> innerListA = new ArrayList<>();
    List<Integer> innerListB = new ArrayList<>();
    innerListA.add("String 1");
    innerListA.add("String 2");
    innerListB.add(1);
    innerListB.add(2);
    list.add(innerListA);
    list.add(innerListB);

    Doc result = Modeler.model(list);
    Doc expected =
        new Wrapper(
            new Concat(
                List.of(
                    new LineBreak(),
                    new IndentBlock(
                        List.of(
                            new Concat(
                                List.of(
                                    new Wrapper(
                                        new Concat(
                                            List.of(
                                                new LineBreak(),
                                                new IndentBlock(
                                                    List.of(
                                                        new Concat(
                                                            List.of(
                                                                new Wrapper(
                                                                    new Wrapper(
                                                                        new Text("String 1"),
                                                                        WrapperType.SINGLE_QUOTE),
                                                                    WrapperType.FG_COLOR_GREEN),
                                                                new Text(", "))),
                                                        new LineBreak(),
                                                        new Concat(
                                                            List.of(
                                                                new Wrapper(
                                                                    new Wrapper(
                                                                        new Text("String 2"),
                                                                        WrapperType.SINGLE_QUOTE),
                                                                    WrapperType.FG_COLOR_GREEN))),
                                                        new LineBreak())))),
                                        WrapperType.SQUARE_BRACKETS),
                                    new Text(", "))),
                            new LineBreak(),
                            new Concat(
                                List.of(
                                    new Wrapper(
                                        new Concat(
                                            List.of(
                                                new LineBreak(),
                                                new IndentBlock(
                                                    List.of(
                                                        new Concat(
                                                            List.of(
                                                                new Wrapper(
                                                                    new Text("1"),
                                                                    WrapperType.FG_COLOR_YELLOW),
                                                                new Text(", "))),
                                                        new LineBreak(),
                                                        new Concat(
                                                            List.of(
                                                                new Wrapper(
                                                                    new Text("2"),
                                                                    WrapperType.FG_COLOR_YELLOW))),
                                                        new LineBreak())))),
                                        WrapperType.SQUARE_BRACKETS))),
                            new LineBreak())))),
            WrapperType.SQUARE_BRACKETS);

    assertEquals(expected, result);
  }
}
