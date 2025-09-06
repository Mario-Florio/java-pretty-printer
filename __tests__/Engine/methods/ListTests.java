package __tests__.Engine.methods;

import java.util.ArrayList;
import java.util.List;

import interfaceadapters.Engine;
import shared.testing.Test;

public class ListTests {
    private static Engine engine = new Engine();

    public static final void run() {
        System.out.println("LIST");

        Test.it("Formats empty List correctly", () -> {
            List<String> list = new ArrayList<>();

            String result = engine.run(list);

            Test.expect(result.equals("[]"));
        });

        Test.it("Formats single-element List correctly", () -> {
            List<String> list = new ArrayList<>();
            list.add("String 1");

            String result = engine.run(list);

            Test.expect(result.equals("['String 1']"));
        });

        Test.it("Formats multi-element List correctly", () -> {
            List<String> list = new ArrayList<>();
            list.add("String 1");
            list.add("String 2");
            list.add("String 3");
            list.add("String 4");

            String result = engine.run(list);

            Test.expect(result.equals("['String 1', 'String 2', 'String 3', 'String 4']"));
        });

        Test.it("Formats nested List correctly", () -> {
            List<List<?>> list = new ArrayList<>();
            List<String> innerListA = new ArrayList<>();
            List<Integer> innerListB = new ArrayList<>();
            innerListA.add("String 1");
            innerListA.add("String 2");
            innerListB.add(1);
            innerListB.add(2);
            list.add(innerListA);
            list.add(innerListB);

            String result = engine.run(list);

            Test.expect(result.equals("[['String 1', 'String 2'], [1, 2]]"));
        });
    }
}
