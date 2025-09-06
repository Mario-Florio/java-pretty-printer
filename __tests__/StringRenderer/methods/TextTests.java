package __tests__.StringRenderer.methods;

import core.entities.Doc;
import core.entities.Doc.Text;
import core.usecases.StringRenderer;
import shared.testing.Test;

public class TextTests {

    private static StringRenderer renderer = new StringRenderer();

    public static final void run() {
        System.out.println("TEXT");

        Test.it("Renders text correctly", () -> {
            for (int i = 0; i < 10; i++) {
                String text = "Text "+i;

                Doc doc = new Text(text);

                String result = renderer.render(doc);

                Test.expect(result.equals(text));
            }
        });
    }

}
