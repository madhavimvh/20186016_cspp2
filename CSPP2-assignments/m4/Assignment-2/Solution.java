import java.util.Scanner;
/**
 * { item_description }.
 */
public final class Solution {
    /**
     * { item_description }.
     */
    private Solution() {
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int m1 = sc.nextInt();
        int[][] arr1 = getMatrix(n1, m1);
        System.out.println();
        int n2 = sc.nextInt();
        int m2 = sc.nextInt();
        int[][] arr2 = getMatrix(n2, m2);
        System.out.println(addition(arr1, arr2, n1, m1));
    }
    /**
     * Gets the matrix.
     *
     * @param      n     { parameter_description }.
     * @param      m     { parameter_description }.
     *
     * @return     The matrix.
     */
    public static int[][] getMatrix(final int n, final int m) {
        Scanner scan = new Scanner(System.in);
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // arr[i][j] = scan.nextInt();
                System.out.println(scan.nextInt());
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.println(arr[i][j]);
            }
        }
        return arr;
    }
    /**
     * { function_description }.
     *
     * @param      arr1  The arr 1
     * @param      arr2  The arr 2
     * @param      n     { parameter_description }
     * @param      m     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public static int[][] addition(final int[][] arr1,
                                    final int[][] arr2,
                                    final int n, final int m) {
         int c[][] = new int[n][m];
         for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                c[i][j] = arr1[i][j] + arr2[i][j];
         }
    }
    return c;
}
}
