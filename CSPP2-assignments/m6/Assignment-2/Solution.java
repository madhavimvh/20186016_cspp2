import java.util.Scanner;
/**
 * Write a java program to round the
 * elements of a matrix to the nearest 100.
 *
 * @author :
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //not used
    }
    private static final int HUN = 100;
    private static final int NIN = 90;
    private static final int FIF = 50;
    /**
     * Function to round the
     * elements of a matrix to the nearest 100.
     *
     * @param      a     Matrix of which the elements to be rounded
     * @param      rows     Number of rows
     * @param      columns     Number of columns
     *
     * @return     Matrix of the rounded elements
     */
    static int[][] roundHundred(final int[][] a,
                                final int rows,
                                final int columns) {
        int n = 0;
        int[][] nn = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int rem = a[i][j] % HUN;
                if (a[i][j] > FIF) {
                if (rem > FIF) {
                n = ((a[i][j] + NIN) / HUN) * HUN;
                nn[i][j] = (n / HUN) * HUN;
                // System.out.println(nn[i][j]);
                } else {
                    nn[i][j] = (a[i][j] / HUN) * HUN;
                    // System.out.println(nn[i][j]);
                }
            } else {
                nn[i][j] = 0;
                // System.out.println(nn[i][j]);
            }
            }
        }
        return nn;
    }
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scan.nextInt();
            }
        }
        int[][] b = roundHundred(a, m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 1; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println(b[i][n - 1]);
        }
    }
}
