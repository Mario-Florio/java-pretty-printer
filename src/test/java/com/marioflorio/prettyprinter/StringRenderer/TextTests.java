package com.marioflorio.prettyprinter.StringRenderer;

import static org.junit.jupiter.api.Assertions.*;

import com.marioflorio.prettyprinter.core.entities.Doc;
import com.marioflorio.prettyprinter.core.entities.Doc.Text;
import com.marioflorio.prettyprinter.core.usecases.StringRenderer;
import org.junit.jupiter.api.Test;

public class TextTests {

  private static StringRenderer renderer = new StringRenderer();

  @Test
  void rendersTextCorrectly() {
    for (int i = 0; i < 10; i++) {
      String text = "Text " + i;

      Doc doc = new Text(text);

      String result = renderer.render(doc);
      String expected = text;

      assertEquals(expected, result);
    }
  }
}
