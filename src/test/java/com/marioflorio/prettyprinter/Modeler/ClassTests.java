package com.marioflorio.prettyprinter.Modeler;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.AbstractList;
import java.util.ArrayList;
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

public class ClassTests {

    @Test
    void modelsClassCorrectly() {
        Doc result = Modeler.model(ArrayList.class);
        Doc expected = new Text("[class ArrayList]");

        assertEquals(expected, result);
    }

    @Test
    void modelsAbstractClassCorrectly() {
        Doc result = Modeler.model(AbstractList.class);
        Doc expected = new Text("[class AbstractList]");

        assertEquals(expected, result);
    }

    @Test
    void modelsInterfaceClassCorrectly() {
        Doc result = Modeler.model(List.class);
        Doc expected = new Text("[interface List]");

        assertEquals(expected, result);
    }

    @Test
    void modelsCustomClassCorrectly() {
        Doc result = Modeler.model(TestClass.class);
        Doc expected = new Concat(List.of(
            new Text("[class TestClass] "),
            new Wrapper(new Concat(List.of(
                new LineBreak(),
                new IndentBlock(List.of(
                    new Concat(List.of(
                        new Text("staticProp"),
                        new Text(": "),
                        new Wrapper(new Wrapper(new Text("Static prop"), WrapperType.SINGLE_QUOTE), WrapperType.FG_COLOR_GREEN),
                        new Text(", "))
                    ),
                    new LineBreak(),
                    new Concat(List.of(
                        new Text("staticMethod"),
                        new Text(": "),
                        new Wrapper(new Text("[Method: staticMethod]"), WrapperType.FG_COLOR_CYAN)
                    )),
                    new LineBreak()
                ))
            )), WrapperType.CURLY_BRACKETS)
        ));

        assertEquals(expected, result);
    }

    @Test
    void modelsCustomClassCorrectly2() {
        Doc result = Modeler.model(TestClass2.class);
        Doc expected = new Concat(List.of(
            new Text("[class TestClass2] "),
            new Wrapper(new Concat(List.of(
                new LineBreak(),
                new IndentBlock(List.of(
                    new Concat(List.of(
                        new Text("staticProp2"),
                        new Text(": "),
                        new Wrapper(new Wrapper(new Text("Static prop"), WrapperType.SINGLE_QUOTE), WrapperType.FG_COLOR_GREEN),
                        new Text(", "))
                    ),
                    new LineBreak(),
                    new Concat(List.of(
                        new Text("staticMethod2"),
                        new Text(": "),
                        new Wrapper(new Text("[Method: staticMethod2]"), WrapperType.FG_COLOR_CYAN)
                    )),
                    new LineBreak()
                ))
            )), WrapperType.CURLY_BRACKETS)
        ));

        assertEquals(expected, result);
    }
    
}
