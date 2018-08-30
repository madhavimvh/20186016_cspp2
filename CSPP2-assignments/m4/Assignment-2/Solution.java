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
        int[][] arr1 = new int[n1][m1];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m1; j++) {
                arr1[i][j] = sc.nextInt();
            }
        }
        int n2 = sc.nextInt();
        int m2 = sc.nextInt();
        int[][] arr2 = new int[n2][m2];
        for (int i = 0; i < n2; i++) {
            for (int j = 0; j < m2; j++) {
                arr2[i][j] = sc.nextInt();
            }
        }
        addition(arr1, arr2, n1, m1, n2, m2);
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
    public static void addition (final int[][] arr1, final int[][] arr2, final int n1, final int m1, final int n2, final int m2) {
        if (n1 == n1 && m1 ==m2) {
            int[][] c = new int[n1][m1];
                for (int i = 0; i < n1; i++) {
                    for (int j = 0; j < m1; j++) {
                        c[i][j] = arr1[i][j] + arr2[i][j];
                }
            }
            printMatrix(c, n1, m1);
        } else {
            System.out.println("not possible");
        }
    }
    /**
     * { function_description }.
     *
     * @param      d     { parameter_description }
     * @param      n1    The n 1
     * @param      m1    The m 1
     */
    public static void printMatrix(final int[][] d, final int n1, final int m1) {
        String temp = "";
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m1; j++) {
                temp += d[i][j] + " ";
            }
            temp = temp.trim();
            temp += "\n";
        }
        System.out.println(temp);
    }
}
