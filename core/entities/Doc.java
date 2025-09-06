package core.entities;

import java.util.List;

public sealed interface Doc permits
    Doc.Text, Doc.Wrapper, Doc.Concat, Doc.LineBreak, Doc.IndentBlock {

    enum WrapperType {
        SINGLE_QUOTE, SQUARE_BRACKETS, CURLY_BRACKETS,
        FG_COLOR_GREEN, FG_COLOR_CYAN, FG_COLOR_YELLOW
    }

    public record Text(String value) implements Doc {}

    public record Wrapper(Doc doc, WrapperType type) implements Doc {}

    public record Concat(List<Doc> children) implements Doc {}

    public record LineBreak() implements Doc {
        public static final String value = "\n";
    }

    public record IndentBlock(List<Doc> children) implements Doc {
        public static String INDENT = "  ";
    }
}
