package __tests__.Modeler.methods;

import core.entities.Doc;
import core.entities.Doc.Text;
import core.entities.Doc.Wrapper;
import core.entities.Doc.WrapperType;
import core.usecases.Modeler;
import shared.testing.Test;

public class PrimitiveTests {

    public static void run() {
        System.out.println("PRIMITIVES");

        Test.it("Models null correctly", () -> {
            Doc result = Modeler.model(null);

            Test.expect(result.equals(new Text("null")));
        });

        Test.it("Models byte correctly", () -> {
            for (int i = 0; i < 10; i++) {
                Doc result = Modeler.model((byte) i);

                Test.expect(result.equals(getYellowWrappedTextNode(Integer.toString(i))));
            }
        });

        Test.it("Models short correctly", () -> {
            for (int i = 0; i < 10; i++) {
                Doc result = Modeler.model((short) i);

                Test.expect(result.equals(getYellowWrappedTextNode(Integer.toString(i))));
            }
        });

        Test.it("Models int correctly", () -> {
            for (int i = 0; i < 10; i++) {
                Doc result = Modeler.model(i);

                Test.expect(result.equals(getYellowWrappedTextNode(Integer.toString(i))));
            }
        });

        Test.it("Models long correctly", () -> {
            for (int i = 0; i < 10; i++) {
                long l = i;
                Doc result = Modeler.model(l);

                Test.expect(result.equals(getYellowWrappedTextNode(Integer.toString(i))));
            }
        });

        Test.it("Models float correctly", () -> {
            for (int i = 0; i < 10; i++) {
                float f = i;
                Doc result = Modeler.model(f);

                Test.expect(result.equals(getYellowWrappedTextNode(String.valueOf(f))));
            }
        });

        Test.it("Models double correctly", () -> {
            for (int i = 0; i < 10; i++) {
                double d = i;
                Doc result = Modeler.model(d);

                Test.expect(result.equals(getYellowWrappedTextNode(String.valueOf(d))));
            }
        });

        Test.it("Models char correctly", () -> {
            for (int i = 0; i < 100; i++) {
                char c = (char) i;
                Doc result = Modeler.model(c);

                Test.expect(result.equals(new Text(String.valueOf(c))));
            }
        });

        Test.it("Models boolean correctly", () -> {
            boolean t = true;
            boolean f = false;

            Doc resultA = Modeler.model(t);
            Doc resultB = Modeler.model(f);

            Test.expect(resultA.equals(getYellowWrappedTextNode(Boolean.toString(t))));
            Test.expect(resultB.equals(getYellowWrappedTextNode(Boolean.toString(f))));
        });
    }

    private static Doc getYellowWrappedTextNode(String textVal) {
        return new Wrapper(new Text(textVal), WrapperType.FG_COLOR_YELLOW);
    }
}
