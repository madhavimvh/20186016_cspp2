import java.util.Scanner;
/**
 * { item_description }.
 */
public final class SumOfNNumbers {
    /**
     * { item_description }.
     */
    private SumOfNNumbers() {
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        int i, n;
        String sum = "";
        System.out.println("enter the values of i and n");
        Scanner scan = new Scanner(System.in);
        i = scan.nextInt();
        n = scan.nextInt();
        for (i = 0; i <= n; i++) {
            sum = sum + i;
        }
        System.out.println(sum);
    }
}
