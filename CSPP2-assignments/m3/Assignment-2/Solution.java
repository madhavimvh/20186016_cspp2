/**
 * { item_description }.
 */
import java.util.Scanner;
/*
	Do not modify this main function.
	*/
public class Solution {
/* Fill the main function to print the number of 7's between 1 to n*/
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);      
        int n = s.nextInt();
        System.out.println(returnSevenCount(n));
    }

    public static int returnSevenCount(int n) {
    	int i = 1; 
        int count = 0;
        for(i = 1; i <= n; i++) {
        	count += returnCountOfNumber(i);
	    }
	    return count;
    }

    public static int returnCountOfNumber(int n) {
    	int count = 0;
    	while(n > 0) {
    		if (n % 10 == 7) {
    			count += 1;
    		}
    		n = n/10;
    	}
    	return count;
    }
}