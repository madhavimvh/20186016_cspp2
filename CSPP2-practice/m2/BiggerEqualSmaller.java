/**
 * { item_description }.
 */
import java.util.Scanner;
/**
 * Class for bigger equal smaller.
 */
public final class BiggerEqualSmaller {
    /**
     * Empty constructor.
     */
    private BiggerEqualSmaller() {
    }
    /**
     * { function_description }.
     *
     * @param args  The arguments
     */
    public static void main(final String[] args) {
        int varA, varB;
        System.out.println("enter a varA and varB");
        Scanner scan = new Scanner(System.in);
        varB = scan.nextInt();
        varA = scan.nextInt();
        greatersmaller(varA, varB);
    }
    /**
     * @param varA as variable.
     * @param varB as variable
     */
    public static void greatersmaller(final int varA, final int varB) {
        if (varA > varB) {
            System.out.println("bigger");
        } else if (varA == varB) {
            System.out.println("equal");
        } else {
            System.out.println("smaller");
        }
    }
}
