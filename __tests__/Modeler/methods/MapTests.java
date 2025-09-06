package __tests__.Modeler.methods;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import core.entities.Doc;
import core.entities.Doc.Text;
import core.entities.Doc.Concat;
import core.entities.Doc.IndentBlock;
import core.entities.Doc.LineBreak;
import core.entities.Doc.Wrapper;
import core.entities.Doc.WrapperType;
import core.usecases.Modeler;
import shared.testing.Test;

public class MapTests {

    public static final void run() {
        System.out.println("MAP");

        Test.it("Models empty Map correctly", () -> {
            Map<String, Integer> map = new HashMap<>();

            Doc result = Modeler.model(map);

            Test.expect(result.equals(
                new Wrapper(new Concat(List.of()), WrapperType.CURLY_BRACKETS)
            ));
        });

        Test.it("Models single-element Map correctly", () -> {
            Map<String, Integer> map = new HashMap<>();
            map.put("prop", 1);

            Doc result = Modeler.model(map);

            Test.expect(result.equals(
                new Wrapper(new Concat(List.of(
                    new LineBreak(),
                    new IndentBlock(List.of(
                        new Concat(List.of(
                            new Text("prop"), new Text(": "), new Wrapper(new Text("1"), WrapperType.FG_COLOR_YELLOW)
                        )),
                        new LineBreak()
                    ))
                )), WrapperType.CURLY_BRACKETS)
            ));
        });

        Test.it("Models multi-element Map correctly", () -> {
            Map<String, Integer> map = new LinkedHashMap<>();
            map.put("prop", 1);
            map.put("prop2", 2);
            map.put("prop3", 3);
            map.put("prop4", 4);

            Doc result = Modeler.model(map);

            Test.expect(result.equals(
                new Wrapper(new Concat(List.of(
                    new LineBreak(),
                    new IndentBlock(List.of(
                        new Concat(List.of(
                            new Text("prop"), new Text(": "), new Wrapper(new Text("1"), WrapperType.FG_COLOR_YELLOW), new Text(", ")
                        )),
                        new LineBreak(),
                        new Concat(List.of(
                            new Text("prop2"), new Text(": "), new Wrapper(new Text("2"), WrapperType.FG_COLOR_YELLOW), new Text(", ")
                        )),
                        new LineBreak(),
                        new Concat(List.of(
                            new Text("prop3"), new Text(": "), new Wrapper(new Text("3"), WrapperType.FG_COLOR_YELLOW), new Text(", ")
                        )),
                        new LineBreak(),
                        new Concat(List.of(
                            new Text("prop4"), new Text(": "), new Wrapper(new Text("4"), WrapperType.FG_COLOR_YELLOW)
                        )),
                        new LineBreak()
                    ))
                )), WrapperType.CURLY_BRACKETS)
            ));
        });
    
    }
}
