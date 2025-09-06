package shared.testing;

public class Test {
    private static final String GREEN_FG = "\u001B[32m";
    private static final String RED_FG = "\u001B[31m";
    private static final String RESET_FG = "\u001B[0m";
    private static final String CHECKMARK = "\u2714";
    private static final String X = "\u2716";

    public static final void it(String name, ThrowingRunnable test) {
        try {
            test.run();
            System.out.println(GREEN_FG+CHECKMARK+" "+name+RESET_FG);
        } catch (Exception exception) {
            System.out.println(RED_FG+X+" "+name+RESET_FG);
        }
    }
    public static final void expect(Boolean condition) throws RuntimeException {
        if (!condition) {
            throw new RuntimeException();
        }
    }

    @FunctionalInterface
    public static interface ThrowingRunnable {
        void run() throws Exception;
    }
}
