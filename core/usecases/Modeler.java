package core.usecases;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.regex.Pattern;

import core.entities.Doc;
import core.entities.Doc.Concat;
import core.entities.Doc.IndentBlock;
import core.entities.Doc.LineBreak;
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
        if (obj instanceof Class cls)        return modelClass(cls);
        if (isCustomClass(obj.getClass()))   return modelCustomObj(obj);
        if (obj instanceof Map map)          return modelMap(map);
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
    private static final Doc modelClass(Class<?> cls) {
        Pattern p = Pattern.compile("(?<=\\s)(?:.*\\.)");
        String fullName = cls.toString();
        String simpleName = p.matcher(fullName).replaceAll("");
        String nameLabel = "["+simpleName+"]";

        if (!isCustomClass(cls)) return new Text(nameLabel);

        Map<String, Object> entries = new LinkedHashMap<>();

        try {
            for (Field field : cls.getDeclaredFields()) {
                if (java.lang.reflect.Modifier.isStatic(field.getModifiers())) {
                    field.setAccessible(true);
                    entries.put(field.getName(), field.get(cls));
                }
            }
            for (Method method : cls.getDeclaredMethods()) {
                if (java.lang.reflect.Modifier.isStatic(method.getModifiers())) 
                    entries.put(method.getName(), method);
            }
        } catch (Exception e) {
            // Handle Exception
        }

        return new Concat(List.of(new Text(nameLabel+" "), model(entries)));
    }
    private static final Doc modelCustomObj(Object obj) {
        Class<?> cls = obj.getClass();
        String nameLabel = cls.getSimpleName()+" ";

        Map<String, Object> entries = new LinkedHashMap<>();

        try {
            for (Field field : cls.getDeclaredFields()) {
                if (java.lang.reflect.Modifier.isStatic(field.getModifiers())) continue;
                field.setAccessible(true);
                entries.put(field.getName(), field.get(obj));
            }
            for (Method method : cls.getDeclaredMethods()) {
                if (java.lang.reflect.Modifier.isStatic(method.getModifiers())) continue;
                entries.put(method.getName(), method);
            }
        } catch (Exception e) {
            // Handle Exception
        }

        return new Concat(List.of(new Text(nameLabel), model(entries)));
    }
    private static final Doc modelMap(Map<?, ?> map) {
        List<Doc> children = new ArrayList<>();

        if (!map.isEmpty()) {
            // Lead with line break
            children.add(new LineBreak());

            List<Doc> entries = new ArrayList<>();
            Iterator<? extends Map.Entry<?, ?>> it = map.entrySet().iterator();

            while (it.hasNext()) {
                Map.Entry<?, ?> e = it.next();
                Object key = e.getKey();
                Object val = e.getValue();
                Doc k = null;
                Doc v = null;

                if (key instanceof String str && str.contains(" "))
                    k = new Wrapper(new Wrapper(model(str), WrapperType.SINGLE_QUOTE), WrapperType.FG_COLOR_GREEN);
                else k = model(key);

                if (val instanceof String str)
                    v = new Wrapper(new Wrapper(model(str), WrapperType.SINGLE_QUOTE), WrapperType.FG_COLOR_GREEN);
                else v = model(val);

                // entry
                List<Doc> entry = new ArrayList<>();
                entry.add(k);
                entry.add(new Text(": "));
                entry.add(v);

                if (it.hasNext()) entry.add(new Text(", ")); // comma after all but last

                entries.add(new Concat(entry));
                entries.add(new LineBreak());
            }

            // Wrap all entries in one IndentBlock
            children.add(new IndentBlock(entries));
        }

        return new Wrapper(new Concat(children), WrapperType.CURLY_BRACKETS);
    }
    // UTILS
    private static final Boolean isCustomClass(Class<?> c) {
        return !c.getPackageName().startsWith("java.");
    }
}
