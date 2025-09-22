package com.marioflorio.prettyprinter.Modeler;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.marioflorio.prettyprinter.core.entities.Doc;
import com.marioflorio.prettyprinter.core.entities.Doc.Text;
import com.marioflorio.prettyprinter.core.entities.Doc.Wrapper;
import com.marioflorio.prettyprinter.core.entities.Doc.WrapperType;
import com.marioflorio.prettyprinter.core.usecases.Modeler;

public class PrimitiveTests {

    @Test
    void modelsNullCorrectly() {
        Doc result = Modeler.model(null);
        Doc expected = new Text("null");

        assertEquals(expected, result);
    }

    @Test
    void modelsByteCorrectly() {
        for (int i = 0; i < 10; i++) {
            Doc result = Modeler.model((byte) i);
            Doc expected = getYellowWrappedTextNode(Integer.toString(i));

            assertEquals(expected, result);
        }
    }

    @Test
    void modelsShortCorrectly() {
        for (int i = 0; i < 10; i++) {
            Doc result = Modeler.model((short) i);
            Doc expected = getYellowWrappedTextNode(Integer.toString(i));

            assertEquals(expected, result);
        }
    }

    @Test
    void modelsIntCorrectly() {
        for (int i = 0; i < 10; i++) {
            Doc result = Modeler.model(i);
            Doc expected = getYellowWrappedTextNode(Integer.toString(i));

            assertEquals(expected, result);
        }
    }

    @Test
    void modelsLongCorrectly() {
        for (int i = 0; i < 10; i++) {
            long l = i;
            Doc result = Modeler.model(l);
            Doc expected = getYellowWrappedTextNode(Integer.toString(i));

            assertEquals(expected, result);
        }
    }

    @Test
    void modelsFloatCorrectly() {
        for (int i = 0; i < 10; i++) {
            float f = i;
            Doc result = Modeler.model(f);
            Doc expected = getYellowWrappedTextNode(String.valueOf(f));

            assertEquals(expected, result);
        }
    }

    @Test
    void modelsDoubleCorrectly() {
        for (int i = 0; i < 10; i++) {
            double d = i;
            Doc result = Modeler.model(d);
            Doc expected = getYellowWrappedTextNode(String.valueOf(d));

            assertEquals(expected, result);
        }
    }

    @Test
    void modelsCharCorrectly() {
        for (int i = 0; i < 100; i++) {
            char c = (char) i;
            Doc result = Modeler.model(c);
            Doc expected = new Text(String.valueOf(c));

            assertEquals(expected, result);
        }
    }

    @Test
    void modelsBooleanCorrectly() {
        boolean t = true;
        boolean f = false;

        Doc resultA = Modeler.model(t);
        Doc resultB = Modeler.model(f);

        Doc expectedA = getYellowWrappedTextNode(Boolean.toString(t));
        Doc expectedB = getYellowWrappedTextNode(Boolean.toString(f));

        assertEquals(expectedA, resultA);
        assertEquals(expectedB, resultB);
    }

    private static Doc getYellowWrappedTextNode(String textVal) {
        return new Wrapper(new Text(textVal), WrapperType.FG_COLOR_YELLOW);
    }
}
