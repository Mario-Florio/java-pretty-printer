package __tests__.Engine.methods;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import interfaceadapters.Engine;
import shared.testing.Test;

public class MapTests {
    private static Engine engine = new Engine();

    public static final void run() {
        System.out.println("MAP");

        Test.it("Formats empty Map correctly", () -> {
            Map<String, Integer> map = new HashMap<>();

            String result = engine.run(map);

            Test.expect(result.equals("{}"));
        });

        Test.it("Formats single-element Map correctly", () -> {
            Map<String, Integer> map = new HashMap<>();
            map.put("prop", 1);

            String result = engine.run(map);

            Test.expect(result.equals("{prop: 1}"));
        });

        Test.it("Formats multi-element Map correctly", () -> {
            Map<String, Integer> map = new LinkedHashMap<>();
            map.put("prop", 1);
            map.put("prop2", 2);
            map.put("prop3", 3);
            map.put("prop4", 4);

            String result = engine.run(map);

            Test.expect(result.equals("{prop: 1, prop2: 2, prop3: 3, prop4: 4}"));
        });
    
    }
}
