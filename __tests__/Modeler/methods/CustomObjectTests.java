package __tests__.Modeler.methods;

import java.util.List;

import __tests__.__utils__.TestClass;
import __tests__.__utils__.TestClass2;
import core.entities.Doc;
import core.entities.Doc.Concat;
import core.entities.Doc.IndentBlock;
import core.entities.Doc.LineBreak;
import core.entities.Doc.Text;
import core.entities.Doc.Wrapper;
import core.entities.Doc.WrapperType;
import core.usecases.Modeler;
import shared.testing.Test;

public class CustomObjectTests {

    public static final void run() {
        System.out.println("CUSTOM OBJECT");

        Test.it("Models custom object correctly", () -> {
            Doc result = Modeler.model(new TestClass());

            Test.expect(result.equals(
                new Concat(List.of(
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
                ))
            ));
        });

        Test.it("Models custom object correctly", () -> {
            Doc result = Modeler.model(new TestClass2());

            Test.expect(result.equals(
                new Concat(List.of(
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
                ))
            ));
        });

    }
}
