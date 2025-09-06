package core.entities;

public sealed interface Doc permits
    Doc.Text, Doc.Wrapper {

    enum WrapperType {
        SINGLE_QUOTE, SQUARE_BRACKETS, CURLY_BRACKETS,
        FG_COLOR_GREEN, FG_COLOR_CYAN, FG_COLOR_YELLOW
    }

    public record Text(String value) implements Doc {}

    public record Wrapper(Doc doc, WrapperType type) implements Doc {}

}
