/**
 * { item_description }.
 */
import java.util.*;
/**
 * Class for solution.
 */
public final class Solution {
	/**
	*Fill this main function to print maximum of given array
	*/
	public static void main(final String[] args)
	{
		Scanner sc=new Scanner(System.in);
		//System.out.println("enter the size of array");
		int n= sc.nextInt();
		int[] arr = new int[n];
		//System.out.println("enter the array elements");
		for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(maxnum(arr));
		

	}
	public static int maxnum(final int[] arr) {
		int max = arr[0];
		for (int element : arr){
			if (element > max) {
				max = element;
			}
		}
		return max;
	}
}
