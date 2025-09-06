package core.usecases;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

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
        if (obj instanceof Method m)         return modelMethod(m);
        if (obj instanceof Constructor c)    return modelConstructor(c);
        if (obj instanceof Runnable r)       return modelRunnable(r);
        if (obj instanceof Callable c)       return modelCallable(c);
        if (obj instanceof Function f)       return modelFunc(f);
        if (obj instanceof Consumer c)       return modelConsumer(c);
        if (obj instanceof BiFunction bf)    return modelBiFunc(bf);
        if (obj instanceof BiConsumer bc)    return modelBiConsumer(bc);
        if (obj instanceof Supplier s)       return modelSupplier(s);
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
    private static final Doc modelMethod(Method m) {
        return new Wrapper(new Text("[Method: "+m.getName()+"]"), WrapperType.FG_COLOR_CYAN);
    }
    private static final Doc modelConstructor(Constructor<?> c) {
        return new Wrapper(new Text("[Constructor: "+c.getDeclaringClass().getSimpleName()+"]"), WrapperType.FG_COLOR_CYAN);
    }
    private static final Doc modelRunnable(Runnable r) {
        return new Wrapper(new Text("[Runnable]"), WrapperType.FG_COLOR_CYAN);
    }
    private static final Doc modelCallable(Callable<?> c) {
        return new Wrapper(new Text("[Callable]"), WrapperType.FG_COLOR_CYAN);
    }
    private static final Doc modelFunc(Function<?, ?> f) {
        return new Wrapper(new Text("[Function]"), WrapperType.FG_COLOR_CYAN);
    }
    private static final Doc modelConsumer(Consumer<?> c) {
        return new Wrapper(new Text("[Consumer]"), WrapperType.FG_COLOR_CYAN);
    }
    private static final Doc modelBiFunc(BiFunction<?, ?, ?> bf) {
        return new Wrapper(new Text("[BiFunction]"), WrapperType.FG_COLOR_CYAN);
    }
    private static final Doc modelBiConsumer(BiConsumer<?, ?> bc) {
        return new Wrapper(new Text("[BiConsumer]"), WrapperType.FG_COLOR_CYAN);
    }
    private static final Doc modelSupplier(Supplier<?> s) {
        return new Wrapper(new Text("[Supplier]"), WrapperType.FG_COLOR_CYAN);
    }
}
