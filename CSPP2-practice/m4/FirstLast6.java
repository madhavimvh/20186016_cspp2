/**
 * { item_description }.
 */
import java.util.Scanner;
/**
 * .
 */
public final class FirstLast6 {
    /**
     * { item_description }.
     */
    private FirstLast6() {
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
        System.out.println(checkSix(arr, n));
    }
    /**
     * { function description }.
     *
     * @param      arr   The arr
     * @param      n     { parameter description }
     *
     * @return     { descriptionofthereturnvalue }
     */
    public static boolean checkSix(final int[] arr, final int n) {
        return arr[0] == SIX || arr[n - 1] == SIX;
        }
}
