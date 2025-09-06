package __tests__.Modeler.methods;

import core.entities.Doc;
import core.entities.Doc.Text;
import core.usecases.Modeler;
import shared.testing.Test;

public class StringTests {

    public static final void run() {
        System.out.println("STRING");

        Test.it("Models String correctly", () -> {
            for (int i = 0; i < 10; i++) {
                String string = "String "+i;

                Doc result = Modeler.model(string);

                Test.expect(result.equals(new Text(string)));
            }
        });
    }

}
