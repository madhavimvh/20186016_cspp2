import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for set.
 * @author : 
 */
class SortedSetADT {
	/**
	 * Empty constructor.
	 */
	public SortedSetADT() {
		sortedset = new int[10];
		size = 0;
	}
	private int[] sortedset;
	private int size;
	public SortedSetADT(final int capacity) {
		sortedset = new int[capacity];
		size = 0;
	}
	public int size() {
		return size;
	}
	public String toString() {
		if (size == 0) {
			return "{}";
		}
		String str = "{";
		int i = 0;
		for (i = 0; i < size - 1; i++) {
			str = str + sortedset[i] + ", ";
			
		}
		str = str + sortedset[i] + "}";
		return str;
	}
	public void resize() {
		System.out.println(size);
		sortedset = Arrays.copyOf(sortedset, 2 * size);
	}
	public void add(final int item) {
		if (size == sortedset.length) {
			resize();
		}
		if (contains(item) == false) {
			sortedset[size++] = item;
			System.out.println(Arrays.toString(sortedset));
		}
	}

	public void addAll(final int[] item) {
		System.out.println("addAll");
		for (int i = 0; i < item.length; i++) {
			System.out.println(item[i]);
			add(item[i]);
		}
		Arrays.sort(sortedset);
		// System.out.println("fs" + Arrays.toString(sortedset));
	}
	public boolean contains(final int item) {
		for (int i = 0; i < size; i++) {
			if (item == sortedset[i]) {
				return true;
			}
			}
			return false;
		}
	public SortedSetADT intersection(final SortedSetADT that) {
		if (that.size() == 0 || this.size() == 0) {
			return new SortedSetADT();
		}
		SortedSetADT newsortedset = new SortedSetADT();
		for (int i = 0; i < this.size(); i++) {
			for (int j = 0; j < that.size(); j++) {
					if (that.sortedset[j] == this.sortedset[i]) {
						newsortedset.add(this.sortedset[i]);
					}
				}	
			}
			return newsortedset;
		}
	

	public SortedSetADT retainAll(final int[] items) {
			SortedSetADT newsortedset = new SortedSetADT();
			newsortedset.addAll(items);
			return this.intersection(newsortedset);			
		}
	public int[][] cartesianProduct(final SortedSetADT that) {
		int[][] array = new int[this.size() * that.size()][2];
		if (this.size() == 0 || that.size() == 0) {
			return null;
		}
		int x = 0;
		for (int i = 0; i < this.size(); i++) {
			for (int j = 0; j < that.size(); j++) {
				array[x][0] = this.sortedset[i];
				array[x++][1] = that.sortedset[j];
			}
		}
		return array;
	}
	public SortedSetADT subSet(int fromElement, int toElement) {
		System.out.println("subset");
		SortedSetADT set = new SortedSetADT();
		if (fromElement > toElement) {
			System.out.println("Invalid Arguments to Subset Exception");
			return null;
		} else {
			for (int i = fromElement; i < toElement; i++) {
			set.add(sortedset[i]);
		}
	}
	return set;
	}
	public SortedSetADT headSet(int toElement) {
		SortedSetADT set = new SortedSetADT();
		if (toElement > size || toElement <= 0) {
			return null;
		} else {
			for (int i = 0; i < toElement; i++) {
				set.add(sortedset[i]);
			}
		}
		return set;
	}
	public int last() {
		return sortedset[size - 1];
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
        SortedSetADT s = new SortedSetADT();
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
                }
                break;
                case "addAll":
                int[] intArray1 = intArray(tokens[1]);
                s.addAll(intArray1);
                break;
                case "intersection":
                s = new SortedSetADT();
                SortedSetADT t = new SortedSetADT();
                intArray = intArray(tokens[1]);
                s.addAll(intArray);
                intArray = intArray(tokens[2]);
                t.addAll(intArray);
                System.out.println(s.intersection(t));
                break;
                case "retainAll":
                s = new SortedSetADT();
                intArray = intArray(tokens[1]);
                s.addAll(intArray);
                intArray = intArray(tokens[2]);
                System.out.println(s.retainAll(intArray));
                break;
                case "cartesianProduct":
                s = new SortedSetADT();
                t = new SortedSetADT();
                intArray = intArray(tokens[1]);
                s.addAll(intArray);
                intArray = intArray(tokens[2]);
                t.addAll(intArray);
                System.out.println(Arrays.deepToString(s.cartesianProduct(t)));
                break;
                case "subSet":
                if (tokens.length != 2) {
                    break;
                }
                String[] arrstring3 = tokens[1].split(",");
                SortedSetADT object = s.subSet(Integer.parseInt(arrstring3[0]),
                                        Integer.parseInt(arrstring3[1]));
                if (object != null) {
                    System.out.println(object);
                }
                break;
                case "headSet":
                System.out.println(s.headSet(Integer.parseInt(tokens[2])));
                break;
                case "last":
                System.out.println(s.last());
                default:
                break;
            }
        }
    }
}
