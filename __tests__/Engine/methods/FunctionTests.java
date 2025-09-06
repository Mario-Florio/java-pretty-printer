package __tests__.Engine.methods;

import java.util.concurrent.Callable;
import java.util.function.*;

import interfaceadapters.Engine;
import shared.testing.Test;

public class FunctionTests {
    private static Engine engine = new Engine();

    // ===== Functional interfaces =====
    private static final void runnableMethod() {}
    private static final String callableMethod() { return "ok"; }
    private static final Integer functionMethod(String s) { return s.length(); }
    private static final void consumerMethod(String s) {}
    private static final Integer biFunctionMethod(String s, String t) { return s.length() + t.length(); }
    private static final void biConsumerMethod(String s, String t) {}
    private static final String supplierMethod() { return "supplied"; }

    public static final void run() {
        System.out.println("FUNCTION");

        Test.it("Formats Runnable correctly", () -> {
            Runnable runnable = FunctionTests::runnableMethod;
            String result = engine.run(runnable);

            Test.expect(result.equals("[Runnable]"));
        });

        Test.it("Formats Callable correctly", () -> {
            Callable<String> callable = FunctionTests::callableMethod;
            String result = engine.run(callable);

            Test.expect(result.equals("[Callable]"));
        });

        Test.it("Formats Fuction correctly", () -> {
            Function<String, Integer> f = FunctionTests::functionMethod;
            String result = engine.run(f);

            Test.expect(result.equals("[Function]"));
        });

        Test.it("Formats Consumer correctly", () -> {
            Consumer<String> cons = FunctionTests::consumerMethod;
            String result = engine.run(cons);

            Test.expect(result.equals("[Consumer]"));
        });

        Test.it("Formats BiFunction correctly", () -> {
            BiFunction<String, String, Integer> bf = FunctionTests::biFunctionMethod;
            String result = engine.run(bf);
            
            Test.expect(result.equals("[BiFunction]"));
        });

        Test.it("Formats BiConsumer correctly", () -> {
            BiConsumer<String, String> bc = FunctionTests::biConsumerMethod;
            String result = engine.run(bc);

            Test.expect(result.equals("[BiConsumer]"));
        });

        Test.it("Formats Supplier correctly", () -> {
            Supplier<String> sup = FunctionTests::supplierMethod;
            String result = engine.run(sup);

            Test.expect(result.equals("[Supplier]"));
        });

    }
}
