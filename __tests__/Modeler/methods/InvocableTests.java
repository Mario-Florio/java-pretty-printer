package __tests__.Modeler.methods;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import core.entities.Doc;
import core.entities.Doc.Text;
import core.entities.Doc.Wrapper;
import core.entities.Doc.WrapperType;
import core.usecases.Modeler;
import shared.testing.Test;

public class InvocableTests {

    // ===== Regular static method =====
    public static final void method() {}

    // ===== Constructor =====
    public InvocableTests() {}

    public static final void run() {
        System.out.println("INVOCABLE");

        Test.it("Models Method correctly", () -> {
            Method m = InvocableTests.class.getMethod("method");
            Doc result = Modeler.model(m);

            Test.expect(result.equals(getCyanWrappedTextNode("[Method: method]")));
        });

        Test.it("Models Constructor correctly", () -> {
            Constructor<?> constructor = InvocableTests.class.getConstructor();
            Doc result = Modeler.model(constructor);

            Test.expect(result.equals(getCyanWrappedTextNode("[Constructor: InvocableTests]")));
        });
    }
    private static Doc getCyanWrappedTextNode(String textVal) {
        return new Wrapper(new Text(textVal), WrapperType.FG_COLOR_CYAN);
    }
}
