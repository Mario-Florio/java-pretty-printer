package __tests__.Modeler.methods;

import java.util.ArrayList;
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

public class ListTests {

    public static final void run() {
        System.out.println("LIST");

        Test.it("Models empty List correctly", () -> {
            List<String> list = new ArrayList<>();

            Doc result = Modeler.model(list);

            Test.expect(result.equals(
                new Wrapper(new Concat(List.of()), WrapperType.SQUARE_BRACKETS)
            ));
        });

        Test.it("Models single-element List correctly", () -> {
            List<String> list = new ArrayList<>();
            list.add("String 1");

            Doc result = Modeler.model(list);

            Test.expect(result.equals(
                new Wrapper(new Concat(List.of(
                    new LineBreak(),
                    new IndentBlock(List.of(
                        new Concat(List.of(
                            new Wrapper(new Wrapper(new Text("String 1"), WrapperType.SINGLE_QUOTE), WrapperType.FG_COLOR_GREEN)
                        )),
                        new LineBreak()
                    ))
                )), WrapperType.SQUARE_BRACKETS)
            ));
        });

        Test.it("Models multi-element List correctly", () -> {
            List<String> list = new ArrayList<>();
            list.add("String 1");
            list.add("String 2");
            list.add("String 3");
            list.add("String 4");

            Doc result = Modeler.model(list);

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

        Test.it("Models nested List correctly", () -> {
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
                                            new Wrapper(new Text("1"), WrapperType.FG_COLOR_YELLOW),
                                            new Text(", ")
                                        )),
                                        new LineBreak(),
                                        new Concat(List.of(
                                            new Wrapper(new Text("2"), WrapperType.FG_COLOR_YELLOW)
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
