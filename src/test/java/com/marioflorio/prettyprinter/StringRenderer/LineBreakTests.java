package com.marioflorio.prettyprinter.StringRenderer;

import static org.junit.jupiter.api.Assertions.*;

import com.marioflorio.prettyprinter.core.entities.Doc;
import com.marioflorio.prettyprinter.core.entities.Doc.LineBreak;
import com.marioflorio.prettyprinter.core.usecases.StringRenderer;
import org.junit.jupiter.api.Test;

public class LineBreakTests {

  private static StringRenderer renderer = new StringRenderer();

  @Test
  void rendersLineBreakCorrectly() {
    Doc doc = new LineBreak();

    renderer.setApplyFormat(true);
    String resultWithFormat = renderer.render(doc);
    String expectedWithFormat = LineBreak.value;

    assertEquals(expectedWithFormat, resultWithFormat);

    renderer.setApplyFormat(false);
    String resultWithoutFormat = renderer.render(doc);
    String expectedWithoutFormat = "";

    assertEquals(expectedWithoutFormat, resultWithoutFormat);
  }
}
