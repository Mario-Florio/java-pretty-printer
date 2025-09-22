package com.marioflorio.prettyprinter.Engine.methods;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.marioflorio.prettyprinter.__utils__.TestClass;
import com.marioflorio.prettyprinter.__utils__.TestClass2;
import com.marioflorio.prettyprinter.interfaceadapters.Engine;

public class CustomObjectTests {
    private static Engine engine = new Engine();

    @Test
    void formatsCustomObjectCorrectly() {
        String result = engine.run(new TestClass());
        String expected = "TestClass {prop: 'Prop', method: [Method: method]}";

        assertEquals(expected, result);
    }

    @Test
    void formatsCustomObjectCorrectly2() {
        String result = engine.run(new TestClass2());
        String expected = "TestClass2 {prop2: 'Prop', method2: [Method: method2]}";

        assertEquals(expected, result);
    }

}
