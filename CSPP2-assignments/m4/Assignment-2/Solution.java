import java.util.Scanner;
import java.util.Arrays;

public final class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int m1 = sc.nextInt();
		int[][] arr1 = getMatrix(n1, m1);
		System.out.println();
		int n2 = sc.nextInt();
		int m2 = sc.nextInt();
		int[][] arr2 = getMatrix(n2, m2);
		System.out.println(Addition(arr1, arr2, n1, m1));
	}
	public static int[][] getMatrix(int n, int m) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.println(arr[i][j]);
			}
		}
		return arr;
	}
	public static int[][] Addition(int[][] arr1, int[][] arr2, int n, int m) {
		 int c[][] = new int[n][m];
		 for (int i = 0; i < n; i++) {
		 	for (int j = 0; j < m; j++) {
		 		c[i][j] = arr1[i][j] + arr2[i][j];		
		 }
	}
	return c;
}
}
