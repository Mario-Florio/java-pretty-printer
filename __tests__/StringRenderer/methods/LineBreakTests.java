package __tests__.StringRenderer.methods;

import core.entities.Doc;
import core.entities.Doc.LineBreak;
import core.usecases.StringRenderer;
import shared.testing.Test;

public class LineBreakTests {

    private static StringRenderer renderer = new StringRenderer();

    public static final void run() {
        System.out.println("LINE BREAK");

        Test.it("Renders line break correctly", () -> {
            Doc doc = new LineBreak();

            String result = renderer.render(doc);

            Test.expect(result.equals(LineBreak.value));
        });
    }
}
