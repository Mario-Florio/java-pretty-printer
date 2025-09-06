package __tests__.Modeler;

import __tests__.Modeler.methods.InvocableTests;
import __tests__.Modeler.methods.PrimitiveTests;
import __tests__.Modeler.methods.StringTests;

public class ModelerTest {

    public static void run() {
        System.out.println("MODELER");

        PrimitiveTests.run();
        StringTests.run();
        InvocableTests.run();
    }
}
