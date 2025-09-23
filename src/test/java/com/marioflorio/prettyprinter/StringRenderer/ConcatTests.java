package com.marioflorio.prettyprinter.StringRenderer;

import static org.junit.jupiter.api.Assertions.*;

import com.marioflorio.prettyprinter.core.entities.Doc;
import com.marioflorio.prettyprinter.core.entities.Doc.Concat;
import com.marioflorio.prettyprinter.core.entities.Doc.Text;
import com.marioflorio.prettyprinter.core.usecases.StringRenderer;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ConcatTests {

  private static StringRenderer renderer = new StringRenderer();

  @Test
  void rendersConcatCorrectly() {
    String prefix = "Name";
    String colon = ": ";
    String content = "Bob";
    String suffix = ";";

    Doc doc =
        new Concat(List.of(new Text(prefix), new Text(colon), new Text(content), new Text(suffix)));

    String result = renderer.render(doc);
    String expected = prefix + colon + content + suffix;

    assertEquals(expected, result);
  }
}
