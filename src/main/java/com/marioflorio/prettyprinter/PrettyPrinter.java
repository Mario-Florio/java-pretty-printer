package com.marioflorio.prettyprinter;

import com.marioflorio.prettyprinter.interfaceadapters.Engine;
import java.io.PrintStream;

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
