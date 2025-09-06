package __tests__.Engine;

import __tests__.Engine.methods.ArrayTests;
import __tests__.Engine.methods.ClassTests;
import __tests__.Engine.methods.CollectionTests;
import __tests__.Engine.methods.CustomObjectTests;
import __tests__.Engine.methods.FunctionTests;
import __tests__.Engine.methods.InvocableTests;
import __tests__.Engine.methods.ListTests;
import __tests__.Engine.methods.MapTests;
import __tests__.Engine.methods.PrimitiveTests;
import __tests__.Engine.methods.StringTests;

public class EngineTests {
    public static void run() {
        System.out.println("ENGINE");

        PrimitiveTests.run();
        StringTests.run();
        InvocableTests.run();
        FunctionTests.run();
        ClassTests.run();
        CustomObjectTests.run();
        MapTests.run();
        ArrayTests.run();
        ListTests.run();
        CollectionTests.run();
    }
}
