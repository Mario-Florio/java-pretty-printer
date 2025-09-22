package com.marioflorio.prettyprinter.Modeler;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.marioflorio.prettyprinter.core.entities.Doc;
import com.marioflorio.prettyprinter.core.entities.Doc.Text;
import com.marioflorio.prettyprinter.core.usecases.Modeler;

public class StringTests {

    @Test
    void modelsStringCorrectly() {
        for (int i = 0; i < 10; i++) {
            String string = "String "+i;

            Doc result = Modeler.model(string);
            Doc expected = new Text(string);

            assertEquals(expected, result);
        }
    }

}
