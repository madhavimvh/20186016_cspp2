import java.util.Scanner;

public class Solution {
	/*
	Do not modify this main function.
	*/
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);      
        long base = s.nextLong();
        int exponent = s.nextInt();
        long result=power(base,exponent);
        System.out.println(result);
	}
	/*
	Need to write the power function and print the output.
	*/
	public static long power(long base, int exponent) {
		if (exponent == 0 ){
			return(1);
		} else {
			base = base * power(base, exponent - 1);
			return (base);
		}
		
		
	}
}
