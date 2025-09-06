package __tests__.StringRenderer.methods;

import java.util.List;

import core.entities.Doc;
import core.entities.Doc.Text;
import core.entities.Doc.IndentBlock;
import core.usecases.StringRenderer;
import shared.testing.Test;

public class IndentBlockTests {
    private static StringRenderer renderer = new StringRenderer();
    private static final String INDENT = IndentBlock.INDENT;

    public static final void run() {
        System.out.println("INDENT BLOCK");

        Test.it("Renders indent correctly", () -> {
            String entry = "Entry";

            Doc doc = new IndentBlock(List.of(
                new Text(entry),
                new Text(entry),
                new Text(entry)
            ));

            String result = renderer.render(doc);

            Test.expect(result.equals(INDENT+entry+INDENT+entry+INDENT+entry));
        });
    }
}
