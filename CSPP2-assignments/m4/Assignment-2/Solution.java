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
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr1 = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr1[i][j] = sc.nextInt();
            }
        }
        int[][] arr2 = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr2[i][j] = sc.nextInt();
            }
        }
        int[][] d = addition(arr1, arr2, n, m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.println(d[i][j]);
            }
        }
    }
    
    /**
     * { function_description }.
     *
     * @param      arr1  The arr 1
     * @param      arr2  The arr 2
     * @param      n     { parameter_description }.
     * @param      m     { parameter_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public static int[][] addition (final int[][] arr1, final int[][] arr2, final int n, final int m) {
         int[][] c = new int[n][m];
         for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                c[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
    return c;
}


}
