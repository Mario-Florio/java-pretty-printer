package __tests__.Engine.methods;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

import __tests__.__utils__.TestClass;
import __tests__.__utils__.TestClass2;
import interfaceadapters.Engine;
import shared.testing.Test;

public class ClassTests {
    private static Engine engine = new Engine();
    
    public static final void run() {
        System.out.println("CLASS");

        Test.it("Format Class correctly (class)", () -> {
            String result = engine.run(ArrayList.class);

            Test.expect(result.equals("[class ArrayList]"));
        });

        Test.it("Format Class correctly (abstract)", () -> {
            String result = engine.run(AbstractList.class);

            Test.expect(result.equals("[class AbstractList]"));
        });

        Test.it("Format Class correctly (interface)", () -> {
            String result = engine.run(List.class);

            Test.expect(result.equals("[interface List]"));
        });

        Test.it("Format Class correctly (custom)", () -> {
            String result = engine.run(TestClass.class);

            Test.expect(result.equals("[class TestClass] {staticProp: 'Static prop', staticMethod: [Method: staticMethod]}"));
        });

        Test.it("Format Class correctly (custom 2)", () -> {
            String result = engine.run(TestClass2.class);

            Test.expect(result.equals("[class TestClass2] {staticProp2: 'Static prop', staticMethod2: [Method: staticMethod2]}"));
        });
    }
}
