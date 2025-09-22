package com.marioflorio.prettyprinter.Modeler;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import com.marioflorio.prettyprinter.__utils__.TestClass;
import com.marioflorio.prettyprinter.__utils__.TestClass2;
import com.marioflorio.prettyprinter.core.entities.Doc;
import com.marioflorio.prettyprinter.core.entities.Doc.Concat;
import com.marioflorio.prettyprinter.core.entities.Doc.IndentBlock;
import com.marioflorio.prettyprinter.core.entities.Doc.LineBreak;
import com.marioflorio.prettyprinter.core.entities.Doc.Text;
import com.marioflorio.prettyprinter.core.entities.Doc.Wrapper;
import com.marioflorio.prettyprinter.core.entities.Doc.WrapperType;
import com.marioflorio.prettyprinter.core.usecases.Modeler;

public class CustomObjectTests {

    @Test
    void modelsCustomObjectCorrectly() {
        Doc result = Modeler.model(new TestClass());
        Doc expected = new Concat(List.of(
            new Text("TestClass "),
            new Wrapper(new Concat(List.of(
                new LineBreak(),
                new IndentBlock(List.of(
                    new Concat(List.of(
                        new Text("prop"),
                        new Text(": "),
                        new Wrapper(new Wrapper(new Text("Prop"), WrapperType.SINGLE_QUOTE), WrapperType.FG_COLOR_GREEN),
                        new Text(", "))
                    ),
                    new LineBreak(),
                    new Concat(List.of(
                        new Text("method"),
                        new Text(": "),
                        new Wrapper(new Text("[Method: method]"), WrapperType.FG_COLOR_CYAN)
                    )),
                    new LineBreak()
                ))
            )), WrapperType.CURLY_BRACKETS)
        ));

        assertEquals(expected, result);
    }

    @Test
    void modelsCustomObjecCorrectly() {
        Doc result = Modeler.model(new TestClass2());
        Doc expected = new Concat(List.of(
            new Text("TestClass2 "),
            new Wrapper(new Concat(List.of(
                new LineBreak(),
                new IndentBlock(List.of(
                    new Concat(List.of(
                        new Text("prop2"),
                        new Text(": "),
                        new Wrapper(new Wrapper(new Text("Prop"), WrapperType.SINGLE_QUOTE), WrapperType.FG_COLOR_GREEN),
                        new Text(", "))
                    ),
                    new LineBreak(),
                    new Concat(List.of(
                        new Text("method2"),
                        new Text(": "),
                        new Wrapper(new Text("[Method: method2]"), WrapperType.FG_COLOR_CYAN)
                    )),
                    new LineBreak()
                ))
            )), WrapperType.CURLY_BRACKETS)
        ));

        assertEquals(expected, result);
    }

}
