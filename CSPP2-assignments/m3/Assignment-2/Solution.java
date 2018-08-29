/**
 * { item_description }.
 */
import java.util.Scanner;
/*
*Do not modify this main function.
*/
public class Solution {
    /**
    *Empty constructor.
    */
    private Solution() {
    }
    private static final int TEN = 10;
    private static final int SEVEN = 7;
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(String[] args) {
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
    public static int returnSevenCount(int n) {
        int i = 1; 
        int count = 0;
        for(i = 1; i <= n; i++) {
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
    public static int returnCountOfNumber(int n) {
        int count = 0;
        while(n > 0) {
            if (n % TEN == SEVEN) {
                count += 1;
            }
            n = n / TEN;
        }
        return count;
    }
}