package __tests__.Modeler.methods;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

import core.entities.Doc;
import core.entities.Doc.Text;
import core.usecases.Modeler;
import shared.testing.Test;

public class ClassTests {
    
    public static final void run() {
        System.out.println("CLASS");

        Test.it("Models Class correctly (class)", () -> {
            Doc result = Modeler.model(ArrayList.class);

            Test.expect(result.equals(new Text("[class ArrayList]")));
        });

        Test.it("Models Class correctly (abstract)", () -> {
            Doc result = Modeler.model(AbstractList.class);

            Test.expect(result.equals(new Text("[class AbstractList]")));
        });

        Test.it("Models Class correctly (interface)", () -> {
            Doc result = Modeler.model(List.class);

            Test.expect(result.equals(new Text("[interface List]")));
        });
    }
}
