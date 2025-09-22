package com.marioflorio.prettyprinter.Modeler;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.marioflorio.prettyprinter.core.entities.Doc;
import com.marioflorio.prettyprinter.core.entities.Doc.Concat;
import com.marioflorio.prettyprinter.core.entities.Doc.IndentBlock;
import com.marioflorio.prettyprinter.core.entities.Doc.LineBreak;
import com.marioflorio.prettyprinter.core.entities.Doc.Text;
import com.marioflorio.prettyprinter.core.entities.Doc.Wrapper;
import com.marioflorio.prettyprinter.core.entities.Doc.WrapperType;
import com.marioflorio.prettyprinter.core.usecases.Modeler;

public class MapTests {

    @Test
    void modelsEmptyMapCorrectly() {
        Map<String, Integer> map = new HashMap<>();

        Doc result = Modeler.model(map);
        Doc expected = new Wrapper(new Concat(List.of()), WrapperType.CURLY_BRACKETS);

        assertEquals(expected, result);
    }

    @Test
    void modelsEmptySingleElementMapCorrectly() {
        Map<String, Integer> map = new HashMap<>();
        map.put("prop", 1);

        Doc result = Modeler.model(map);
        Doc expected = new Wrapper(new Concat(List.of(
            new LineBreak(),
            new IndentBlock(List.of(
                new Concat(List.of(
                    new Text("prop"), new Text(": "), new Wrapper(new Text("1"), WrapperType.FG_COLOR_YELLOW)
                )),
                new LineBreak()
            ))
        )), WrapperType.CURLY_BRACKETS);

        assertEquals(expected, result);
    }

    @Test
    void modelsMultiElementMapCorrectly() {
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("prop", 1);
        map.put("prop2", 2);
        map.put("prop3", 3);
        map.put("prop4", 4);

        Doc result = Modeler.model(map);
        Doc expected = new Wrapper(new Concat(List.of(
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
        )), WrapperType.CURLY_BRACKETS);

        assertEquals(expected, result);
    }

}
