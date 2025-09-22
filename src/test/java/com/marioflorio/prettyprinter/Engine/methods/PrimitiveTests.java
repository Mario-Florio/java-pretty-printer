package com.marioflorio.prettyprinter.Engine.methods;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.marioflorio.prettyprinter.interfaceadapters.Engine;

public class PrimitiveTests {
    private static Engine engine = new Engine();

    @Test
    void formatsNullCorrectly() {
        String result = engine.run(null);
        String expected = "null";

        assertEquals(expected, result);
    }

    @Test
    void formatsByteCorrectly() {
        for (int i = 0; i < 10; i++) {
            String result = engine.run((byte) i);
            String expected = Integer.toString(i);

            assertEquals(expected, result);
        }
    }

    @Test
    void formatsShortCorrectly() {
        for (int i = 0; i < 10; i++) {
            String result = engine.run((short) i);
            String expected = Integer.toString(i);

            assertEquals(expected, result);
        }
    }

    @Test
    void formatsIntCorrectly() {
        for (int i = 0; i < 10; i++) {
            String result = engine.run(i);
            String expected = Integer.toString(i);

            assertEquals(expected, result);
        }
    }

    @Test
    void formatsLongCorrectly() {
        for (int i = 0; i < 10; i++) {
            long l = i;
            String result = engine.run(l);
            String expected = Integer.toString(i);

            assertEquals(expected, result);
        }
    }

    @Test
    void formatsFloatCorrectly() {
        for (int i = 0; i < 10; i++) {
            float f = i;
            String result = engine.run(f);
            String expected = String.valueOf(f);

            assertEquals(expected, result);
        }
    }

    @Test
    void formatsDoubleCorrectly() {
        for (int i = 0; i < 10; i++) {
            double d = i;
            String result = engine.run(d);
            String expected = String.valueOf(d);

            assertEquals(expected, result);
        }
    }

    @Test
    void formatsCharCorrectly() {
        for (int i = 0; i < 100; i++) {
            char c = (char) i;
            String result = engine.run(c);
            String expected = String.valueOf(c);

            assertEquals(expected, result);
        }
    }

    @Test
    void formatsBooleanCorrectly() {
        boolean t = true;
        boolean f = false;

        String resultA = engine.run(t);
        String resultB = engine.run(f);

        String expectedA = "true";
        String expectedB = "false";

        assertEquals(expectedA, resultA);
        assertEquals(expectedB, resultB);
    }

}
