package __tests__.Modeler.methods;

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

public class ArrayTests {

    public static final void run() {
        System.out.println("ARRAY");

        Test.it("Models empty Array correctly", () -> {
            String[] arr = {};

            Doc result = Modeler.model(arr);

            Test.expect(result.equals(
                new Wrapper(new Concat(List.of()), WrapperType.SQUARE_BRACKETS)
            ));
        });

        Test.it("Models single-element Array correctly", () -> {
            String[] arr = {"String"};

            Doc result = Modeler.model(arr);

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

        Test.it("Models multi-element Array correctly", () -> {
            int[] arr = {1, 2, 3, 4};

            Doc result = Modeler.model(arr);

            Test.expect(result.equals(
                new Wrapper(new Concat(List.of(
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
                )), WrapperType.SQUARE_BRACKETS)
            ));
        });

        Test.it("Models nested Array correctly", () -> {
            String[][] arr = {{ "String 1", "String 2" }, { "String 1", "String 2" }};

            Doc result = Modeler.model(arr);

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
                )), WrapperType.SQUARE_BRACKETS)
            ));
        });
    }
}
