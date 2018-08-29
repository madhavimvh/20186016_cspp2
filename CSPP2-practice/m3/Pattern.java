/**
 * { item_description }.
 */
public final class Pattern {
    /**
     * Empty constructor.
     */
    private static final int FIVE = 5;
    /**
     * Constructs the object..
     */
    private Pattern() {
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        int i, j;
        for (i = 1; i <= FIVE; i++) {
            for (j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
