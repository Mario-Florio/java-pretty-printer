package __tests__.StringRenderer.methods;

import core.entities.Doc;
import core.entities.Doc.Text;
import core.entities.Doc.Wrapper;
import core.entities.Doc.WrapperType;
import core.usecases.StringRenderer;
import shared.testing.Test;

public class WrapperTests {

    private static final StringRenderer renderer = new StringRenderer();
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String CYAN = "\u001B[36m";
    private static final String RESET = "\u001B[0m";

    public static final void run() {
        System.out.println("WRAPPER");

        Test.it("Renders single-quote wrapper correctly", () -> {
            String text = "Text";

            Doc doc = new Wrapper(new Text(text), WrapperType.SINGLE_QUOTE);

            String result = renderer.render(doc);

            Test.expect(result.equals("'"+text+"'"));
        });

        Test.it("Renders square-bracket wrapper correctly", () -> {
            String text = "Text";

            Doc doc = new Wrapper(new Text(text), WrapperType.SQUARE_BRACKETS);

            String result = renderer.render(doc);

            Test.expect(result.equals("["+text+"]"));
        });

        Test.it("Renders curly-bracket wrapper correctly", () -> {
            String text = "Text";

            Doc doc = new Wrapper(new Text(text), WrapperType.CURLY_BRACKETS);

            String result = renderer.render(doc);

            Test.expect(result.equals("{"+text+"}"));
        });

        Test.it("Renders green wrapper correctly", () -> {
            String text = "Text";

            Doc doc = new Wrapper(new Text(text), WrapperType.FG_COLOR_GREEN);

            String result = renderer.render(doc);

            Test.expect(result.equals(GREEN+text+RESET));
        });

        Test.it("Renders yellow wrapper correctly", () -> {
            String text = "Text";

            Doc doc = new Wrapper(new Text(text), WrapperType.FG_COLOR_YELLOW);

            String result = renderer.render(doc);

            Test.expect(result.equals(YELLOW+text+RESET));
        });

        Test.it("Renders cyan wrapper correctly", () -> {
            String text = "Text";

            Doc doc = new Wrapper(new Text(text), WrapperType.FG_COLOR_CYAN);

            String result = renderer.render(doc);

            Test.expect(result.equals(CYAN+text+RESET));
        });
    }
}
