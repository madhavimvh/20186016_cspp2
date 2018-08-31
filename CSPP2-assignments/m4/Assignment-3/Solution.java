
// Given an String, Write a java method that returns the decimal value for the given binary string.


import java.util.Scanner;
import java.lang.Math;
public class Solution
{/*
	Do not modify this main function.
	*/
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n= sc.nextInt();
		for(int i=0;i<=n;i++){
			String s=sc.next();
			int res=binaryToDecimal(s);//Write binaryToDecimal function
			System.out.println(res);
		}
	}
	public static int binaryToDecimal(String s) {
		int decimal = 0;
		for (int i = 0; i < s.length(); i++) {
			decimal += Math.pow(2, i); 
		}
		return decimal;
	}

}
