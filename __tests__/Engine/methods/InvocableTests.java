package __tests__.Engine.methods;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import interfaceadapters.Engine;
import shared.testing.Test;

public class InvocableTests {
    private static Engine engine = new Engine();

    // ===== Regular static method =====
    public static final void method() {}

    // ===== Constructor =====
    public InvocableTests() {}

    public static final void run() {
        System.out.println("INVOCABLE");

        Test.it("Formats Method correctly", () -> {
            Method m = InvocableTests.class.getMethod("method");
            String result = engine.run(m);

            Test.expect(result.equals("[Method: method]"));
        });

        Test.it("Formats Constructor correctly", () -> {
            Constructor<?> constructor = InvocableTests.class.getConstructor();
            String result = engine.run(constructor);

            Test.expect(result.equals("[Constructor: InvocableTests]"));
        });
    }
}
