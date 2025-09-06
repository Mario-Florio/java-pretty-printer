package __tests__.Modeler.methods;

import java.util.concurrent.Callable;
import java.util.function.*;

import core.entities.Doc;
import core.entities.Doc.Text;
import core.entities.Doc.Wrapper;
import core.entities.Doc.WrapperType;
import core.usecases.Modeler;
import shared.testing.Test;

public class FunctionTests {

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

        Test.it("Models Runnable correctly", () -> {
            Runnable runnable = FunctionTests::runnableMethod;
            Doc result = Modeler.model(runnable);

            Test.expect(result.equals(getCyanWrappedTextNode("[Runnable]")));
        });

        Test.it("Models Callable correctly", () -> {
            Callable<String> callable = FunctionTests::callableMethod;
            Doc result = Modeler.model(callable);

            Test.expect(result.equals(getCyanWrappedTextNode("[Callable]")));
        });

        Test.it("Models Fuction correctly", () -> {
            Function<String, Integer> f = FunctionTests::functionMethod;
            Doc result = Modeler.model(f);

            Test.expect(result.equals(getCyanWrappedTextNode("[Function]")));
        });

        Test.it("Models Consumer correctly", () -> {
            Consumer<String> cons = FunctionTests::consumerMethod;
            Doc result = Modeler.model(cons);

            Test.expect(result.equals(getCyanWrappedTextNode("[Consumer]")));
        });

        Test.it("Models BiFunction correctly", () -> {
            BiFunction<String, String, Integer> bf = FunctionTests::biFunctionMethod;
            Doc result = Modeler.model(bf);
            
            Test.expect(result.equals(getCyanWrappedTextNode("[BiFunction]")));
        });

        Test.it("Models BiConsumer correctly", () -> {
            BiConsumer<String, String> bc = FunctionTests::biConsumerMethod;
            Doc result = Modeler.model(bc);

            Test.expect(result.equals(getCyanWrappedTextNode("[BiConsumer]")));
        });

        Test.it("Models Supplier correctly", () -> {
            Supplier<String> sup = FunctionTests::supplierMethod;
            Doc result = Modeler.model(sup);

            Test.expect(result.equals(getCyanWrappedTextNode("[Supplier]")));
        });

    }
    private static Doc getCyanWrappedTextNode(String textVal) {
        return new Wrapper(new Text(textVal), WrapperType.FG_COLOR_CYAN);
    }
}
