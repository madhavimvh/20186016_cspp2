import java.util.Scanner;

public class Solution {
	/*
	Do not modify this main function.
	*/
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int base = scan.nextInt();
		int height = scan.nextInt();
		double a = areaOfTriangle(base, height);
		System.out.println(a);
	}

	public static double areaOfTriangle(int base, int height) {
		return(0.5*base*height);
	}
	/*
	Need to fill the areaOfTriangle function and print the output
	of fahrenheit.
	*/
}