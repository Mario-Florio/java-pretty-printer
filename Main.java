import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import __tests__.Engine.EngineTests;
import __tests__.Modeler.ModelerTests;
import __tests__.StringRenderer.StringRendererTests;
import infrastructure.PrettyPrinter;

public class Main {
    private static PrettyPrinter console = new PrettyPrinter(System.out);
    public static void main(String[] args) {
        // Demo
        Map<Object, Object> map = new HashMap<>();
        Map<Object, Object> innerMap = new HashMap<>();
        List<Object> list = new ArrayList<>();

        map.put("prop", 1);
        map.put("innerMap", innerMap);

        innerMap.put("prop", 1);
        innerMap.put("prop2", "String");
        innerMap.put("list", list);

        list.add(1);
        list.add((double) 2.0);

        console.log(map);
    }
    // Test runner
    private static void tests() {
        ModelerTests.run();
        StringRendererTests.run();
        EngineTests.run();
    }
}
