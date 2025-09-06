package __tests__.StringRenderer.methods;

import java.util.List;

import core.entities.Doc;
import core.entities.Doc.Text;
import core.entities.Doc.Concat;
import core.usecases.StringRenderer;
import shared.testing.Test;

public class ConcatTests {

    private static StringRenderer renderer = new StringRenderer();

    public static final void run() {
        System.out.println("CONCAT");

        Test.it("Renders concat correctly", () -> {
            String prefix = "Name";
            String colon = ": ";
            String content = "Bob";
            String suffix = ";";

            Doc doc = new Concat(List.of(
                new Text(prefix), new Text(colon), new Text(content), new Text(suffix)));

            String result = renderer.render(doc);

            Test.expect(result.equals(prefix+colon+content+suffix));
        });
    }
}
