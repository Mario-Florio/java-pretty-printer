package __tests__.Engine.methods;

import interfaceadapters.Engine;
import shared.testing.Test;

public class ArrayTests {
    private static Engine engine = new Engine();

    public static final void run() {
        System.out.println("ARRAY");

        Test.it("Formats empty Array correctly", () -> {
            String[] arr = {};

            String result = engine.run(arr);

            Test.expect(result.equals("[]"));
        });

        Test.it("Formats single-element Array correctly", () -> {
            String[] arr = {"String"};

            String result = engine.run(arr);

            Test.expect(result.equals("['String']"));
        });

        Test.it("Formats multi-element Array correctly", () -> {
            int[] arr = {1, 2, 3, 4};

            String result = engine.run(arr);

            Test.expect(result.equals("[1, 2, 3, 4]"));
        });

        Test.it("Formats nested Array correctly", () -> {
            String[][] arr = {{ "String 1", "String 2" }, { "String 1", "String 2" }};

            String result = engine.run(arr);

            Test.expect(result.equals("[['String 1', 'String 2'], ['String 1', 'String 2']]"));
        });
    }
}
