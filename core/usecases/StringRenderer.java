package core.usecases;

import core.entities.Doc;
import core.entities.Doc.Concat;
import core.entities.Doc.IndentBlock;
import core.entities.Doc.LineBreak;
import core.entities.Doc.Renderer;
import core.entities.Doc.Text;
import core.entities.Doc.Wrapper;
import core.entities.Doc.WrapperType;

public class StringRenderer implements Renderer {

    public StringRenderer setApplyColor(boolean bool) {
        return this;
    }

    public StringRenderer setApplyFormat(boolean bool) {
        return this;
    }

    @Override
    public String render(Doc doc, int indentLevel) {
        return doc.render(this, indentLevel);
    }

    @Override
    public String renderText(Text text, int indentLevel) {
        return text.value();
    }

    @Override
    public String renderWrapper(Wrapper wrapper, int indentLevel) {
        switch (wrapper.type()) {

            case WrapperType.SINGLE_QUOTE:
                return singleQuoteWrapper(wrapper.doc().render(this, indentLevel));

            case WrapperType.SQUARE_BRACKETS:
                return squareBracketWrapper(wrapper.doc().render(this, indentLevel));

            case WrapperType.CURLY_BRACKETS:
                return curlyBracketWrapper(wrapper.doc().render(this, indentLevel));

            case WrapperType.FG_COLOR_GREEN:
                return fgGreenWrapper(wrapper.doc().render(this, indentLevel));

            case WrapperType.FG_COLOR_YELLOW:
                return fgYellowWrapper(wrapper.doc().render(this, indentLevel));

            case WrapperType.FG_COLOR_CYAN:
                return fgCyanWrapper(wrapper.doc().render(this, indentLevel));

            default:
                return wrapper.doc().render(this, indentLevel);

        }
    }

    @Override
    public String renderConcat(Concat concat, int indentLevel) {
        StringBuilder sb = new StringBuilder();

        for (Doc child : concat.children())
            sb.append(child.render(this, indentLevel));

        return sb.toString();
    }

    @Override
    public String renderLineBreak(LineBreak lb, int indentLevel) {
        return LineBreak.value;
    }

    @Override
    public String renderIndentBlock(IndentBlock ib, int indentLevel) {

        StringBuilder sb = new StringBuilder();
        int newLevel = indentLevel+1;

        for (Doc child : ib.children()) {

            if (!(child instanceof LineBreak))
                sb.append(IndentBlock.INDENT.repeat(newLevel));

            sb.append(child.render(this, newLevel));

        }

        return sb.toString();
    }

    // UTILS
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String CYAN = "\u001B[36m";
    public static final String RESET = "\u001B[0m";

    private static final String singleQuoteWrapper(String str) {
        return "'"+str+"'";
    }
    private static final String squareBracketWrapper(String str) {
        return "["+str+"]";
    }
    private static final String curlyBracketWrapper(String str) {
        return "{"+str+"}";
    }
    private static final String fgGreenWrapper(String str) {
        return GREEN+str+RESET;
    }
    private static final String fgYellowWrapper(String str) {
        return YELLOW+str+RESET;
    }
    private static final String fgCyanWrapper(String str) {
        return CYAN+str+RESET;
    }
}
