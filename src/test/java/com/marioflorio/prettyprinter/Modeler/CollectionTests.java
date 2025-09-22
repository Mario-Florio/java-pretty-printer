package com.marioflorio.prettyprinter.Modeler;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import com.marioflorio.prettyprinter.core.entities.Doc;
import com.marioflorio.prettyprinter.core.entities.Doc.Concat;
import com.marioflorio.prettyprinter.core.entities.Doc.IndentBlock;
import com.marioflorio.prettyprinter.core.entities.Doc.LineBreak;
import com.marioflorio.prettyprinter.core.entities.Doc.Text;
import com.marioflorio.prettyprinter.core.entities.Doc.Wrapper;
import com.marioflorio.prettyprinter.core.entities.Doc.WrapperType;
import com.marioflorio.prettyprinter.core.usecases.Modeler;

public class CollectionTests {

    @Test
    void modelsEmptyCollectionCorrectly() {
        Collection<String> collection = new HashSet<String>();

        Doc result = Modeler.model(collection);
        Doc expected = new Wrapper(new Concat(List.of()), WrapperType.SQUARE_BRACKETS);

        assertEquals(expected, result);
    }

    @Test
    void modelsSingleElementCollectionCorrectly() {
        Collection<String> collection = new HashSet<String>();
        collection.add("String");

        Doc result = Modeler.model(collection);
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
    void modelsMultiElementCollectionCorrectly() {
        Collection<String> collection = new HashSet<String>();
        collection.add("String 1");
        collection.add("String 2");
        collection.add("String 3");
        collection.add("String 4");

        Doc result = Modeler.model(collection);
        Doc expected = new Wrapper(new Concat(List.of(
            new LineBreak(),
            new IndentBlock(List.of(
                new Concat(List.of(
                    new Wrapper(new Wrapper(new Text("String 1"), WrapperType.SINGLE_QUOTE), WrapperType.FG_COLOR_GREEN),
                    new Text(", ")
                )),
                new LineBreak(),
                new Concat(List.of(
                    new Wrapper(new Wrapper(new Text("String 2"), WrapperType.SINGLE_QUOTE), WrapperType.FG_COLOR_GREEN),
                    new Text(", ")
                )),
                new LineBreak(),
                new Concat(List.of(
                    new Wrapper(new Wrapper(new Text("String 3"), WrapperType.SINGLE_QUOTE), WrapperType.FG_COLOR_GREEN),
                    new Text(", ")
                )),
                new LineBreak(),
                new Concat(List.of(
                    new Wrapper(new Wrapper(new Text("String 4"), WrapperType.SINGLE_QUOTE), WrapperType.FG_COLOR_GREEN)
                )),
                new LineBreak()
            ))
        )), WrapperType.SQUARE_BRACKETS);

        assertEquals(expected, result);
    }

    @Test
    void modelsNestedCollectionCorrectly() {
        Collection<Collection<String>> collection = new HashSet<>();
        Collection<String> innerCollectionA = new HashSet<String>();
        innerCollectionA.add("String 1");
        innerCollectionA.add("String 2");
        Collection<String> innerCollectionB = new HashSet<String>();
        innerCollectionB.add("String 3");
        innerCollectionB.add("String 4");
        collection.add(innerCollectionA);
        collection.add(innerCollectionB);

        Doc result = Modeler.model(collection);
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
                                    new Wrapper(new Wrapper(new Text("String 3"), WrapperType.SINGLE_QUOTE), WrapperType.FG_COLOR_GREEN),
                                    new Text(", ")
                                )),
                                new LineBreak(),
                                new Concat(List.of(
                                    new Wrapper(new Wrapper(new Text("String 4"), WrapperType.SINGLE_QUOTE), WrapperType.FG_COLOR_GREEN)
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
