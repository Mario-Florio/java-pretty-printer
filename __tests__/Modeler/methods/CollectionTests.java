package __tests__.Modeler.methods;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import core.entities.Doc;
import core.entities.Doc.Concat;
import core.entities.Doc.IndentBlock;
import core.entities.Doc.LineBreak;
import core.entities.Doc.Text;
import core.entities.Doc.Wrapper;
import core.entities.Doc.WrapperType;
import core.usecases.Modeler;
import shared.testing.Test;

public class CollectionTests {

    public static final void run() {
        System.out.println("COLLECTION");

        Test.it("Models empty Collection correctly", () -> {
            Collection<String> collection = new HashSet<String>();

            Doc result = Modeler.model(collection);

            Test.expect(result.equals(
                new Wrapper(new Concat(List.of()), WrapperType.SQUARE_BRACKETS)
            ));
        });

        Test.it("Models single-element Collection correctly", () -> {
            Collection<String> collection = new HashSet<String>();
            collection.add("String");

            Doc result = Modeler.model(collection);

            Test.expect(result.equals(
                new Wrapper(new Concat(List.of(
                    new LineBreak(),
                    new IndentBlock(List.of(
                        new Concat(List.of(
                            new Wrapper(new Wrapper(new Text("String"), WrapperType.SINGLE_QUOTE), WrapperType.FG_COLOR_GREEN)
                        )),
                        new LineBreak()
                    ))
                )), WrapperType.SQUARE_BRACKETS)
            ));
        });

        Test.it("Models multi-element Collection correctly", () -> {
            Collection<String> collection = new HashSet<String>();
            collection.add("String 1");
            collection.add("String 2");
            collection.add("String 3");
            collection.add("String 4");

            Doc result = Modeler.model(collection);

            Test.expect(result.equals(
                new Wrapper(new Concat(List.of(
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
                )), WrapperType.SQUARE_BRACKETS)
            ));
        });

        Test.it("Models nested Collection correctly", () -> {
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

            Test.expect(result.equals(
                new Wrapper(new Concat(List.of(
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
                )), WrapperType.SQUARE_BRACKETS)
            ));
        });
    }
}
