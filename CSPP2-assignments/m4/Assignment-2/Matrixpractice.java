import java.util.Scanner;
/**
 * { item_description }.
 */
public final class Matrixpractice {
	/**
	 * { item_description }.
	 */
	private Matrixpractice() {
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1, m1;
		n1 = sc.nextInt();
		m1 = sc.nextInt();
		int[][] arr1 = new int[n1][m1];
		for (int i = 0; i < n1; i++) {
			for (int j = 0; j < m1; j++) {
				arr1[i][j] = sc.nextInt();
			}
		}
		int n2, m2;
		n2 = sc.nextInt();
		m2 = sc.nextInt();
		int[][] arr2 = new int[n2][m2];
		for (int i = 0; i < n2; i++) {
			for (int j = 0; j < m2; j++) {
				arr2[i][j] = sc.nextInt();
			}
		}
		addition(arr1, arr2, n1, m1, n2, m2);
	}
	public static void addition(int[][] arr1, int[][] arr2, int n1, int m1, int n2, int m2) {
		int[][] c = new int[n1][m1];
		for (int i = 0; i < n1; i++) {
			for (int j = 0; j < m1; j++) {
				c[i][j] += arr1[i][j] + arr2[i][j];
			}
		}
		System.out.println(printMatrix(c, n1, m1));
	}
	public static int[][] createMatrix(final int n1, final int m1) {
		return new int[n1][m1];
		//int[][] arrray = new int[n1][m1];
		//System.out.println(array);
	}
	public static String printMatrix(final int[][] c, final int n1, final int m1) {
		String temp = "";
		for (int i = 0; i < n1; i++){
			for (int j = 0; j < m1; j++){
				temp += c[i][j] + " ";
			}
			temp = temp.trim();
			temp += "\n";
		}
		return temp;
		
	}
}