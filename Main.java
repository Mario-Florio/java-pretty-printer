import __tests__.Modeler.ModelerTests;
import __tests__.StringRenderer.StringRendererTests;

public class Main {
    public static void main(String[] args) {
        tests();
    }
    private static void tests() {
        ModelerTests.run();
        StringRendererTests.run();
    }
}
