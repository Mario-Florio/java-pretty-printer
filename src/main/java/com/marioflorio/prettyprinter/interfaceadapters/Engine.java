package com.marioflorio.prettyprinter.interfaceadapters;

import com.marioflorio.prettyprinter.core.entities.Doc;
import com.marioflorio.prettyprinter.core.entities.Doc.Renderer;
import com.marioflorio.prettyprinter.core.usecases.Modeler;
import com.marioflorio.prettyprinter.core.usecases.StringRenderer;

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
