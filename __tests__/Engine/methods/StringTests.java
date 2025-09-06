package __tests__.Engine.methods;

import interfaceadapters.Engine;
import shared.testing.Test;

public class StringTests {
    private static Engine engine = new Engine();

    public static final void run() {
        System.out.println("STRING");

        Test.it("Formats String correctly", () -> {
            for (int i = 0; i < 10; i++) {
                String string = "String "+i;

                String result = engine.run(string);

                Test.expect(result.equals(string));
            }
        });
    }

}
