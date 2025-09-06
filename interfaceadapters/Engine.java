package interfaceadapters;

import core.entities.Doc;
import core.entities.Doc.Renderer;
import core.usecases.Modeler;
import core.usecases.StringRenderer;

public class Engine {
    private Renderer renderer = new StringRenderer();

    public String run(Object obj) {
        Doc docTree = Modeler.model(obj);

        return renderer.render(docTree);
    }
    public Engine configure(boolean applyFormat, boolean applyColor) {
        StringRenderer stringRenderer = (StringRenderer) renderer;
        stringRenderer
            .setApplyFormat(applyFormat)
            .setApplyColor(applyColor);
        
        return this;
    }
}
