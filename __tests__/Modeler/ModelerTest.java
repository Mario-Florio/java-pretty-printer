package __tests__.Modeler;

import __tests__.Modeler.methods.ArrayTests;
import __tests__.Modeler.methods.ClassTests;
import __tests__.Modeler.methods.CustomObjectTests;
import __tests__.Modeler.methods.FunctionTests;
import __tests__.Modeler.methods.InvocableTests;
import __tests__.Modeler.methods.ListTests;
import __tests__.Modeler.methods.MapTests;
import __tests__.Modeler.methods.PrimitiveTests;
import __tests__.Modeler.methods.StringTests;

public class ModelerTest {

    public static void run() {
        System.out.println("MODELER");

        PrimitiveTests.run();
        StringTests.run();
        InvocableTests.run();
        FunctionTests.run();
        ClassTests.run();
        CustomObjectTests.run();
        MapTests.run();
        ArrayTests.run();
        ListTests.run();
    }
}
