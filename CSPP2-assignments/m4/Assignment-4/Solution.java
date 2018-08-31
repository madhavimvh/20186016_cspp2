
// Given an String, Write a java method that returns the decimal value for the given binary string.


import java.util.Scanner;
public class Solution
{/*
	Do not modify the main function 
	*/
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String reverse=reverseString(s);	
		System.out.println(reverse);
		
	}
	//Write reverseString function
	public static String reverseString(String s) {
		String reverse = ""  ;
		for (int i = 1; i <= s.length(); i++){
			reverse += s.charAt(s.length() - i);
			// System.out.println(s.length() - i);
			// System.out.println(reverse);
		}
	return reverse;
	}
}
