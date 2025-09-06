package core.usecases;

import core.entities.Doc;
import core.entities.Doc.Text;

public class Modeler {
    public static final Doc model(Object obj) {
        return new Text(obj.toString());
    }
}
