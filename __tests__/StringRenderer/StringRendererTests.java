package __tests__.StringRenderer;

import __tests__.StringRenderer.methods.ConcatTests;
import __tests__.StringRenderer.methods.IndentBlockTests;
import __tests__.StringRenderer.methods.LineBreakTests;
import __tests__.StringRenderer.methods.TextTests;
import __tests__.StringRenderer.methods.WrapperTests;

public class StringRendererTests {

    public static void run() {
        System.out.println("STRING RENDERER");

        TextTests.run();
        WrapperTests.run();
        ConcatTests.run();
        LineBreakTests.run();
        IndentBlockTests.run();
    }
}
