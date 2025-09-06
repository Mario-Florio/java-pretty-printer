package core.usecases;

import core.entities.Doc;
import core.entities.Doc.Text;
import core.entities.Doc.Wrapper;
import core.entities.Doc.WrapperType;

public class Modeler {
    public static final Doc model(Object obj) {
        if (obj == null)                     return modelNull(obj);
        if (obj instanceof Integer ||
            obj instanceof Byte    ||
            obj instanceof Short   ||
            obj instanceof Long    ||
            obj instanceof Float   ||
            obj instanceof Double)           return modelNum(obj);
        if (obj instanceof Boolean bool)     return modelBoolean(bool);
                                             return new Text(obj.toString());
    }
    private static final Doc modelNull(Object obj) {
        return new Text("null");
    }
    private static final Doc modelNum(Object num) {
        return new Wrapper(new Text(num.toString()), WrapperType.FG_COLOR_YELLOW);
    }
    private static final Doc modelBoolean(Boolean bool) {
        return new Wrapper(new Text(bool.toString()), WrapperType.FG_COLOR_YELLOW);
    }
}
