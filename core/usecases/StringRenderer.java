package core.usecases;

import core.entities.Doc;
import core.entities.Doc.Text;

public class StringRenderer {
    public String render(Doc doc) {
        return renderText((Text) doc);
    }

    public String renderText(Text doc) {
        return doc.value();
    }
}
