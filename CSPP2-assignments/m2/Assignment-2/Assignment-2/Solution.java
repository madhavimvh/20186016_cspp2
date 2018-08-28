import java.util.Scanner;

public class Solution {
	/*
	Do not modify this main function.
	*/
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		rootsOfQuadraticEquation(a, b, c);
		//System.out.println(a + " " + b);
	}
	public static void rootsOfQuadraticEquation(int a, int b, int c) {
		int determinant = (b*b) - (4*a*c);
		if (determinant > 0){
			double root1 = (-b + Math.sqrt(determinant))/(2*a);
			double root2 = (-b - Math.sqrt(determinant))/(2*a);
			System.out.println(root1 + " " + root2);
		}
		else if (determinant == 0){
			double root = -b/2*a;
			System.out.println(root + " " + root);
		}
	}
	/*
	Need to write the rootsOfQuadraticEquation function and print the output.
	*/
}
