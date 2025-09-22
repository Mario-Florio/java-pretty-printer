package com.marioflorio.prettyprinter.Engine.methods;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.marioflorio.prettyprinter.interfaceadapters.Engine;

public class StringTests {
    private static Engine engine = new Engine();

    @Test
    void formatsStringCorrectly() {
        for (int i = 0; i < 10; i++) {
            String string = "String "+i;

            String result = engine.run(string);
            String expected = string;

            assertEquals(expected, result);
        }
    }

}
