/**
 * { item_description }.
 */
import java.util.Scanner;
//import java.util.Arrays;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Empty constructor.
     */
    private Solution() {
    }
    /**
     * Fill this main function to print maximum of given array.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        //System.out.println("enter the size of array");
        int n = sc.nextInt();
        int[] arr = new int[n];
        //System.out.println("enter the array elements");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        //System.out.println(Arrays.toString(arr));
        System.out.println(maxnum(arr));
    }
    /**
     * { function_description }.
     *
     * @param      arr   The arr
     *
     * @return     { description_of_the_return_value }
     */
    public static int maxnum(final int[] arr) {
        int max = arr[0];
        for (int element : arr) {
            if (element > max) {
                max = element;
            }
        }
        return max;
    }
}
