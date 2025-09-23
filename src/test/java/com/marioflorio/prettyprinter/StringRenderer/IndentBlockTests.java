package com.marioflorio.prettyprinter.StringRenderer;

import static org.junit.jupiter.api.Assertions.*;

import com.marioflorio.prettyprinter.core.entities.Doc;
import com.marioflorio.prettyprinter.core.entities.Doc.IndentBlock;
import com.marioflorio.prettyprinter.core.entities.Doc.Text;
import com.marioflorio.prettyprinter.core.usecases.StringRenderer;
import java.util.List;
import org.junit.jupiter.api.Test;

public class IndentBlockTests {
  private static StringRenderer renderer = new StringRenderer();
  private static final String INDENT = IndentBlock.INDENT;

  @Test
  void rendersIndentCorrectly() {
    String entry = "Entry";

    Doc doc = new IndentBlock(List.of(new Text(entry), new Text(entry), new Text(entry)));

    renderer.setApplyFormat(true);
    String resultWithFormat = renderer.render(doc);
    String expectedWithFormat = INDENT + entry + INDENT + entry + INDENT + entry;

    assertEquals(expectedWithFormat, resultWithFormat);

    renderer.setApplyFormat(false);
    String resultWithoutFormat = renderer.render(doc);
    String expectedWithoutFormat = entry + entry + entry;

    assertEquals(expectedWithoutFormat, resultWithoutFormat);
  }
}
