/**
 * { item_description }.
 */
import java.util.Scanner;
/**
 * .
 */
public final class Average {
    /**
     * { item_description }.
     */
    private Average() {
    }
    /**
     * { var_description }.
     */
    private static final int SIX = 6;
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of array");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("enter the elements");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(calAverage(arr, n));
    }
    /**
     * { function_description }.
     *
     * @param      arr   The arr
     * @param      n     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public static double calAverage(final int[] arr, final int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + arr[i];
        }
        double average = sum / n;
        return average;
    }
}
