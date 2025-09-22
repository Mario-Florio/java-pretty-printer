package com.marioflorio.prettyprinter.Modeler;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import com.marioflorio.prettyprinter.core.entities.Doc;
import com.marioflorio.prettyprinter.core.entities.Doc.Text;
import com.marioflorio.prettyprinter.core.entities.Doc.Wrapper;
import com.marioflorio.prettyprinter.core.entities.Doc.WrapperType;
import com.marioflorio.prettyprinter.core.usecases.Modeler;

public class InvocableTests {

    // ===== Regular static method =====
    public static final void method() {}

    // ===== Constructor =====
    public InvocableTests() {}

    @Test
    void modelsMethodCorrectly() throws NoSuchMethodException, SecurityException {
        Method m = InvocableTests.class.getMethod("method");
        Doc result = Modeler.model(m);
        Doc expected = getCyanWrappedTextNode("[Method: method]");

        assertEquals(expected, result);
    }

    @Test
    void modelsConstructorCorrectly() throws NoSuchMethodException, SecurityException {
        Constructor<?> constructor = InvocableTests.class.getConstructor();
        Doc result = Modeler.model(constructor);
        Doc expected = getCyanWrappedTextNode("[Constructor: InvocableTests]");

        assertEquals(expected, result);
    }

    private static Doc getCyanWrappedTextNode(String textVal) {
        return new Wrapper(new Text(textVal), WrapperType.FG_COLOR_CYAN);
    }
}
