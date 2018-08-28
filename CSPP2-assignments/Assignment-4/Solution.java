import java.util.Scanner;

public class Solution {
	/*
	Do not modify this main function.
	*/
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double degreesCelsius = scan.nextDouble();
		double a = calculateFromDegreesToFarenheit(degreesCelsius);
		System.out.println(a);
	}
	public static double calculateFromDegreesToFarenheit(double degreesCelsius) {
		double fahrenheit = (1.8*degreesCelsius) + 32;
		return (fahrenheit);	
	}
	/*
	Need to fill the calculateFromDegreesToFarenheit function and print the output
	of fahrenheit.
	*/
}