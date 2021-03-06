/**
 * { item_description }.
 */
import java.util.Scanner;
/**
 * Do not modify this main function.
 */
public final class Solution {
    /**
     * Empty constructor.
     */
    private Solution() {
    }
    /**
     * { var_description }.
     */
    private static final int TEN = 10;
    /**
     * { var_description }.
     */
    private static final int SEVEN = 7;
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(returnSevenCount(n));
    }
    /**
     * Returns seven count.
     *
     * @param      n     { parameter_description }.
     *
     * @return     { description_of_the_return_value }.
     */
    public static int returnSevenCount(final int n) {
        int i = 1;
        int count = 0;
        for (i = 1; i <= n; i++) {
            count += returnCountOfNumber(i);
        }
        return count;
    }
    /**
     * Returns a count of number.
     *
     * @param      n     { parameter_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public static int returnCountOfNumber(final int n) {
        int temp = n;
        int count = 0;
        while (temp > 0) {
            if (temp % TEN == SEVEN) {
                count += 1;
            }
            temp /= TEN;
        }
        return count;
    }
}
