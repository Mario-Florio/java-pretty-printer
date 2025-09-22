package com.marioflorio.prettyprinter.StringRenderer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.marioflorio.prettyprinter.core.entities.Doc;
import com.marioflorio.prettyprinter.core.entities.Doc.Text;
import com.marioflorio.prettyprinter.core.entities.Doc.Wrapper;
import com.marioflorio.prettyprinter.core.entities.Doc.WrapperType;
import com.marioflorio.prettyprinter.core.usecases.StringRenderer;

public class WrapperTests {

    private static final StringRenderer renderer = new StringRenderer();
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String CYAN = "\u001B[36m";
    private static final String RESET = "\u001B[0m";

    @Test
    void rendersSingleQuoteWrapperCorrectly() {
        String text = "Text";

        Doc doc = new Wrapper(new Text(text), WrapperType.SINGLE_QUOTE);

        String result = renderer.render(doc);
        String expected = "'"+text+"'";

        assertEquals(expected, result);
    }

    @Test
    void rendersSquareBracketWrapperCorrectly() {
        String text = "Text";

        Doc doc = new Wrapper(new Text(text), WrapperType.SQUARE_BRACKETS);

        String result = renderer.render(doc);
        String expected = "["+text+"]";

        assertEquals(expected, result);
    }

    @Test
    void rendersCurlyBracketWrapperCorrectly() {
        String text = "Text";

        Doc doc = new Wrapper(new Text(text), WrapperType.CURLY_BRACKETS);

        String result = renderer.render(doc);
        String expected = "{"+text+"}";

        assertEquals(expected, result);
    }

    @Test
    void rendersGreenWrapperCorrectly() {
        String text = "Text";

        Doc doc = new Wrapper(new Text(text), WrapperType.FG_COLOR_GREEN);

        renderer.setApplyColor(true);
        String resultWithColor = renderer.render(doc);
        String expectedWithColor = GREEN+text+RESET;

        assertEquals(expectedWithColor, resultWithColor);

        renderer.setApplyColor(false);
        String resultWithoutColor = renderer.render(doc);
        String expectedWithoutColor = text;

        assertEquals(expectedWithoutColor, resultWithoutColor);
    }

    @Test
    void rendersYellowWrapperCorrectly() {
        String text = "Text";

        Doc doc = new Wrapper(new Text(text), WrapperType.FG_COLOR_YELLOW);

        renderer.setApplyColor(true);
        String resultWithColor = renderer.render(doc);
        String expectedWithColor = YELLOW+text+RESET;

        assertEquals(expectedWithColor, resultWithColor);

        renderer.setApplyColor(false);
        String resultWithoutColor = renderer.render(doc);
        String expectedWithoutColor = text;

        assertEquals(expectedWithoutColor, resultWithoutColor);
    }

    @Test
    void rendersCyanWrapperCorrectly() {
        String text = "Text";

        Doc doc = new Wrapper(new Text(text), WrapperType.FG_COLOR_CYAN);

        renderer.setApplyColor(true);
        String resultWithColor = renderer.render(doc);
        String expectedWithColor = CYAN+text+RESET;

        assertEquals(expectedWithColor, resultWithColor);

        renderer.setApplyColor(false);
        String resultWithoutColor = renderer.render(doc);
        String expectedWithoutColor = text;

        assertEquals(expectedWithoutColor, resultWithoutColor);
    }

}
