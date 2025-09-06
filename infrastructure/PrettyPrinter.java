package infrastructure;
import java.io.PrintStream;

import interfaceadapters.Engine;

public class PrettyPrinter {
    private final PrintStream out;
    private final Engine engine = new Engine().configure(true, true);

    public PrettyPrinter(PrintStream out) {
        this.out = out;
    }

    public final void log(Object object) {
        String result = engine.run(object);
        out.println(result);
    }
}
