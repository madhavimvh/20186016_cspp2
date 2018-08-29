/**
 * Class for convertto while loop.
 */
public final class ConverttoWhileLoop {
    /**
     * Empty constructor.
     */
    private ConverttoWhileLoop() {
    }
    /**
     * { var_description }.
     */
    private static final int VALUE = 11;
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        int i = 2;
        while (i < VALUE) {
            System.out.println(i);
            i += 2;
        }
        System.out.println("Goodbye");
    }
}
