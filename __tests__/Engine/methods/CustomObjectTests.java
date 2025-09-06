package __tests__.Engine.methods;

import __tests__.__utils__.TestClass;
import __tests__.__utils__.TestClass2;
import interfaceadapters.Engine;
import shared.testing.Test;

public class CustomObjectTests {
    private static Engine engine = new Engine();

    public static final void run() {
        System.out.println("CUSTOM OBJECT");

        Test.it("Formats custom object correctly", () -> {
            String result = engine.run(new TestClass());

            Test.expect(result.equals("TestClass {prop: 'Prop', method: [Method: method]}"));
        });

        Test.it("Formats custom object correctly", () -> {
            String result = engine.run(new TestClass2());

            Test.expect(result.equals("TestClass2 {prop2: 'Prop', method2: [Method: method2]}"));
        });

    }
}
