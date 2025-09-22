package com.marioflorio.prettyprinter.Modeler;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import com.marioflorio.prettyprinter.core.entities.Doc;
import com.marioflorio.prettyprinter.core.entities.Doc.Concat;
import com.marioflorio.prettyprinter.core.entities.Doc.IndentBlock;
import com.marioflorio.prettyprinter.core.entities.Doc.LineBreak;
import com.marioflorio.prettyprinter.core.entities.Doc.Text;
import com.marioflorio.prettyprinter.core.entities.Doc.Wrapper;
import com.marioflorio.prettyprinter.core.entities.Doc.WrapperType;
import com.marioflorio.prettyprinter.core.usecases.Modeler;

public class ArrayTests {

    @Test
    void modelsEmptyArrayCorrectly() {
        String[] arr = {};

        Doc result = Modeler.model(arr);
        Doc expected = new Wrapper(new Concat(List.of()), WrapperType.SQUARE_BRACKETS);

        assertEquals(expected, result);
    }

    @Test
    void modelsSingleElementArrayCorrectly() {
        String[] arr = {"String"};

        Doc result = Modeler.model(arr);
        Doc expected = new Wrapper(new Concat(List.of(
            new LineBreak(),
            new IndentBlock(List.of(
                new Concat(List.of(
                    new Wrapper(new Wrapper(new Text("String"), WrapperType.SINGLE_QUOTE), WrapperType.FG_COLOR_GREEN)
                )),
                new LineBreak()
            ))
        )), WrapperType.SQUARE_BRACKETS);

        assertEquals(expected, result);
    }

    @Test
    void modelsMultiElementArrayCorrectly() {
        int[] arr = {1, 2, 3, 4};

        Doc result = Modeler.model(arr);
        Doc expected = new Wrapper(new Concat(List.of(
            new LineBreak(),
            new IndentBlock(List.of(
                new Concat(List.of(
                    new Wrapper(new Text("1"), WrapperType.FG_COLOR_YELLOW),
                    new Text(", ")
                )),
                new LineBreak(),
                new Concat(List.of(
                    new Wrapper(new Text("2"), WrapperType.FG_COLOR_YELLOW),
                    new Text(", ")
                )),
                new LineBreak(),
                new Concat(List.of(
                    new Wrapper(new Text("3"), WrapperType.FG_COLOR_YELLOW),
                    new Text(", ")
                )),
                new LineBreak(),
                new Concat(List.of(
                    new Wrapper(new Text("4"), WrapperType.FG_COLOR_YELLOW)
                )),
                new LineBreak()
            ))
        )), WrapperType.SQUARE_BRACKETS);

        assertEquals(expected, result);
    }

    @Test
    void modelsNestedArrayCorrectly() {
        String[][] arr = {{ "String 1", "String 2" }, { "String 1", "String 2" }};

        Doc result = Modeler.model(arr);
        Doc expected = new Wrapper(new Concat(List.of(
            new LineBreak(),
            new IndentBlock(List.of(
                new Concat(List.of(
                    new Wrapper(
                        new Concat(List.of(
                            new LineBreak(),
                            new IndentBlock(List.of(
                                new Concat(List.of(
                                    new Wrapper(new Wrapper(new Text("String 1"), WrapperType.SINGLE_QUOTE), WrapperType.FG_COLOR_GREEN),
                                    new Text(", ")
                                )),
                                new LineBreak(),
                                new Concat(List.of(
                                    new Wrapper(new Wrapper(new Text("String 2"), WrapperType.SINGLE_QUOTE), WrapperType.FG_COLOR_GREEN)
                                )),
                                new LineBreak()
                            ))
                        )),
                    WrapperType.SQUARE_BRACKETS),
                    new Text(", ")
                )),
                new LineBreak(),
                new Concat(List.of(
                    new Wrapper(
                        new Concat(List.of(
                            new LineBreak(),
                            new IndentBlock(List.of(
                                new Concat(List.of(
                                    new Wrapper(new Wrapper(new Text("String 1"), WrapperType.SINGLE_QUOTE), WrapperType.FG_COLOR_GREEN),
                                    new Text(", ")
                                )),
                                new LineBreak(),
                                new Concat(List.of(
                                    new Wrapper(new Wrapper(new Text("String 2"), WrapperType.SINGLE_QUOTE), WrapperType.FG_COLOR_GREEN)
                                )),
                                new LineBreak()
                            ))
                        )),
                    WrapperType.SQUARE_BRACKETS)
                )),
                new LineBreak()
            ))
        )), WrapperType.SQUARE_BRACKETS);

        assertEquals(expected, result);
    }

}
