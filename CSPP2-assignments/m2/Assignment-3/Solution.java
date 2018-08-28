import java.util.Scanner;

public class Solution {
	/*
	Do not modify this main function.
	*/
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);      
        int base = s.nextInt();
        int exponent = s.nextInt();
        //double result=power(base,exponent);
        long result = power(base,exponent);
        System.out.println((long)result);
	}
	/*
	Need to write the power function and print the output.
	*/
	//public static double power(int base, int exponent) {
	public static long power(long base, int exponent) {	
		if (exponent == 0 ) {
			return(1);
		} else {
			//double result = base * power(base, exponent - 1);
			base = base * power(base, exponent - 1);
			//return result;
			return base;
		}
		
		
	}
}
