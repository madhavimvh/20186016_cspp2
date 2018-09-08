import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for set.
 * @author : 
 */
class Set {
	private static final int TWO = 2;
	private static final int TEN = 10;
	private int size;
	private int[] set;

	public Set() {
		set = new int[TEN];
		size = 0;
	}

	public Set(final int capacity) {
		size = 0;
		set = new int[capacity];
	}

	public int size() {
		return size;
	}
	public boolean contains(final int item) {
		for (int i = 0; i < size; i++) {
			if ((set[i]) == item) {
				return true;
			}
		}
		return false;
	}
	public String toString() {
	        if (size == 0) {
	            return "{}";
	        }
	        String str = "{";
	        int i = 0;
	        for (i = 0; i < size - 1; i++) {
	            str = str + set[i] + ",";
	        }
	        str = str + set[i] + "}";
	        return str;
	    }
	public void add(final int[] item) {
	        if (size == set.length) {
	            resize();
	        }
	        set[size++] = item[0]; 
	}
	private void resize() {
	        set = Arrays.copyOf(set, TWO * size);
	    }
	public void add(final int items) {
		for (int i = 0; i < size; i++) {
			add(items);
		}
	}
	public String[] intersection(final Set other) {
		return null;
		// String[] set1 = new String[size];
		// for (int i = 0; i < size; i++) {
		// 	for (int j = 0; j < other.size(); i++) {
		// 		if (set[i] == other[j]) {
		// 			set1[i] += set[i];
		// 		}
				
		// 	}
		// }
		// return set1;
	}
	public String[] retainAll(final int[] other) {
		return null;
		// String[] set1 = new String[set.length];
		// for (int i = 0; i < size; i++) {
		// 	for (int j = 0; j < other.length; i++) {
		// 		if (set[i] == other[j]) {
		// 			set1[i] += set[i];
		// 		}
				
		// 	}
		// }
		// return set1;
	}
	public int[][] cartesianProduct(final Set other) {
		return null;
		// int n = size * other.length;
		// int[][] array = new int[n];
		// for (int i = 0; i < size; i++) {
		// 	for (int j = 0; j < other.length; j++) {
		// 		array[i][j] = combine(set[i], other[i]);
				
		// 	}

			
		// }
	}
	}
/**
 * Solution class for code-eval.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * helper function to convert string input to int array.
     *
     * @param      s     { string input from test case file }
     *
     * @return     { int array from the given string }
     */
    public static int[] intArray(final String s) {
        String input = s;
        if (input.equals("[]")) {
            return new int[0];
        }
        if (s.contains("[")) {
            input = s.substring(1, s.length() - 1);
        }
        return Arrays.stream(input.split(","))
                            .mapToInt(Integer::parseInt)
                            .toArray();
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // instantiate this set
        Set s = new Set();
        // code to read the test cases input file
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        // check if there is one more line to process
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
                case "size":
                System.out.println(s.size());
                break;
                case "contains":
                System.out.println(s.contains(Integer.parseInt(tokens[1])));
                break;
                case "print":
                System.out.println(s);
                break;
                case "add":
                int[] intArray = intArray(tokens[1]);
                if (intArray.length == 1) {
                    s.add(intArray[0]);
                } else {
                    s.add(intArray);
                    System.out.println(intArray);
                }
                break;
                case "intersection":
                s = new Set();
                Set t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(s.intersection(t));
                break;
                case "retainAll":
                s = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                System.out.println(s.retainAll(intArray));
                break;
                case "cartesianProduct":
                s = new Set();
                t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(Arrays.deepToString(s.cartesianProduct(t)));
                break;
                default:
                break;
            }
        }
    }
}
