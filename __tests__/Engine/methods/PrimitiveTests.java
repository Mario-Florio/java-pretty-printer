package __tests__.Engine.methods;

import interfaceadapters.Engine;
import shared.testing.Test;

public class PrimitiveTests {
    private static Engine engine = new Engine();

    public static final void run() {
        System.out.println("PRIMITIVES");

        Test.it("Formats null correctly", () -> {
            String result = engine.run(null);

            Test.expect(result.equals("null"));
        });

        Test.it("Formats byte correctly", () -> {
            for (int i = 0; i < 10; i++) {
                String result = engine.run((byte) i);

                Test.expect(result.equals(Integer.toString(i)));
            }
        });

        Test.it("Formats short correctly", () -> {
            for (int i = 0; i < 10; i++) {
                String result = engine.run((short) i);

                Test.expect(result.equals(Integer.toString(i)));
            }
        });

        Test.it("Formats int correctly", () -> {
            for (int i = 0; i < 10; i++) {
                String result = engine.run(i);

                Test.expect(result.equals(Integer.toString(i)));
            }
        });

        Test.it("Formats long correctly", () -> {
            for (int i = 0; i < 10; i++) {
                long l = i;
                String result = engine.run(l);

                Test.expect(result.equals(Integer.toString(i)));
            }
        });

        Test.it("Formats float correctly", () -> {
            for (int i = 0; i < 10; i++) {
                float f = i;
                String result = engine.run(f);

                Test.expect(result.equals(String.valueOf(f)));
            }
        });

        Test.it("Formats double correctly", () -> {
            for (int i = 0; i < 10; i++) {
                double d = i;
                String result = engine.run(d);

                Test.expect(result.equals(String.valueOf(d)));
            }
        });

        Test.it("Formats char correctly", () -> {
            for (int i = 0; i < 100; i++) {
                char c = (char) i;
                String result = engine.run(c);

                Test.expect(result.equals(String.valueOf(c)));
            }
        });

        Test.it("Formats boolean correctly", () -> {
            boolean t = true;
            boolean f = false;

            String resultA = engine.run(t);
            String resultB = engine.run(f);

            Test.expect(resultA.equals("true"));
            Test.expect(resultB.equals("false"));
        });
    }
}
