package com.marioflorio.prettyprinter.Engine.methods;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import com.marioflorio.prettyprinter.interfaceadapters.Engine;

public class InvocableTests {
    private static Engine engine = new Engine();

    // ===== Regular static method =====
    public static final void method() {}

    // ===== Constructor =====
    public InvocableTests() {}

    @Test
    void formatsMethodCorrectly() throws NoSuchMethodException, SecurityException {
        Method m = InvocableTests.class.getMethod("method");
        String result = engine.run(m);
        String expected = "[Method: method]";

        assertEquals(expected, result);
    }

    @Test
    void formatsConstructorCorrectly() throws NoSuchMethodException, SecurityException {
        Constructor<?> constructor = InvocableTests.class.getConstructor();
        String result = engine.run(constructor);
        String expected = "[Constructor: InvocableTests]";

        assertEquals(expected, result);
    }

}
