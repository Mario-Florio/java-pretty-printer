package core.entities;

import java.util.List;

public sealed interface Doc permits
    Doc.Text, Doc.Wrapper, Doc.Concat, Doc.LineBreak, Doc.IndentBlock {

    public String render(Renderer renderer, int indentLevel);

    enum WrapperType {
        SINGLE_QUOTE, SQUARE_BRACKETS, CURLY_BRACKETS,
        FG_COLOR_GREEN, FG_COLOR_CYAN, FG_COLOR_YELLOW
    }

    interface Renderer {
        default String render(Doc docTree) { return docTree.render(this, 0); };
        public String render(Doc docTree, int indentLevel);
        public String renderText(Text text, int indentLevel);
        public String renderWrapper(Wrapper wrapper, int indentLevel);
        public String renderConcat(Concat concat, int indentLevel);
        public String renderLineBreak(LineBreak lb, int indentLevel);
        public String renderIndentBlock(IndentBlock ib, int indentLevel);
    }

    public record Text(String value) implements Doc {
        @Override
        public String render(Renderer renderer, int indentLevel) {
            return renderer.renderText(this, indentLevel);
        }
    }

    public record Wrapper(Doc doc, WrapperType type) implements Doc {
        @Override
        public String render(Renderer renderer, int indentLevel) {
            return renderer.renderWrapper(this, indentLevel);
        }
    }

    public record Concat(List<Doc> children) implements Doc {
        @Override
        public String render(Renderer renderer, int indentLevel) {
            return renderer.renderConcat(this, indentLevel);
        }
    }

    public record LineBreak() implements Doc {
        public static final String value = "\n";

        @Override
        public String render(Renderer renderer, int indentLevel) {
            return renderer.renderLineBreak(this, indentLevel);
        }
    }

    public record IndentBlock(List<Doc> children) implements Doc {
        public static String INDENT = "  ";

        @Override
        public String render(Renderer renderer, int indentLevel) {
            return renderer.renderIndentBlock(this, indentLevel);
        }
    }
}
