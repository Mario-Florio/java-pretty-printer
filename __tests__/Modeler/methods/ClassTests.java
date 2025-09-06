package __tests__.Modeler.methods;

import java.util.AbstractList;
import java.util.ArrayList;
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

public class ClassTests {
    
    public static final void run() {
        System.out.println("CLASS");

        Test.it("Models Class correctly (class)", () -> {
            Doc result = Modeler.model(ArrayList.class);

            Test.expect(result.equals(new Text("[class ArrayList]")));
        });

        Test.it("Models Class correctly (abstract)", () -> {
            Doc result = Modeler.model(AbstractList.class);

            Test.expect(result.equals(new Text("[class AbstractList]")));
        });

        Test.it("Models Class correctly (interface)", () -> {
            Doc result = Modeler.model(List.class);

            Test.expect(result.equals(new Text("[interface List]")));
        });

        Test.it("Models Class correctly (custom)", () -> {
            Doc result = Modeler.model(TestClass.class);

            Test.expect(result.equals(
                new Concat(List.of(
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
                ))
            ));
        });

        Test.it("Models Class correctly (custom 2)", () -> {
            Doc result = Modeler.model(TestClass2.class);

            Test.expect(result.equals(
                new Concat(List.of(
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
                ))
            ));
        });
    }
}
