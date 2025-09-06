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

            renderer.setApplyFormat(true);
            String resultWithFormat = renderer.render(doc);

            Test.expect(resultWithFormat.equals(LineBreak.value));

            renderer.setApplyFormat(false);
            String resultWithoutFormat = renderer.render(doc);

            Test.expect(resultWithoutFormat.equals(""));
        });
    }
}
