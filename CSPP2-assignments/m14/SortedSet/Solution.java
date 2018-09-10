import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for set.
 * @author : 
 */
class SortedSet {
	/**
	 * Empty constructor.
	 */
	public SortedSet() {
		sortedset = new int[10];
		size = 0;
	}
	private int[] sortedset;
	private int size;
	public SortedSet(final int capacity) {
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
		// System.out.println(size);
		sortedset = Arrays.copyOf(sortedset, 2 * size);
	}
	public void add(final int item) {
		if (size == sortedset.length) {
			resize();
		}
		if (contains(item) == false) {
			sortedset[size++] = item;
			// System.out.println(Arrays.toString(sortedset));
		}
		sortedset = Arrays.copyOf(sortedset, size);
		Arrays.sort(sortedset);
		// System.out.println("fs" + Arrays.toString(sortedset));
	}

	public void addAll(final int[] item) {
		// System.out.println("addAll");
		for (int i = 0; i < item.length; i++) {
			// System.out.println(item[i]);
			add(item[i]);
		}
	}
	public boolean contains(final int item) {
		for (int i = 0; i < size; i++) {
			if (item == sortedset[i]) {
				return true;
			}
			}
			return false;
		}
	public SortedSet intersection(final SortedSet that) {
		if (that.size() == 0 || this.size() == 0) {
			return new SortedSet();
		}
		SortedSet newsortedset = new SortedSet();
		for (int i = 0; i < this.size(); i++) {
			for (int j = 0; j < that.size(); j++) {
					if (that.sortedset[j] == this.sortedset[i]) {
						newsortedset.add(this.sortedset[i]);
					}
				}	
			}
			return newsortedset;
		}
	

	public SortedSet retainAll(final int[] items) {
			SortedSet newsortedset = new SortedSet();
			newsortedset.addAll(items);
			return this.intersection(newsortedset);			
		}
	public int[][] cartesianProduct(final SortedSet that) {
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
	public int indexOf(int item) {
		//Write logic for indexOf method
		// System.out.println("item1" + item);
		for (int i = 0; i < size; i++) {
			if (sortedset[i] == item) {
				return i;
			} 
		}
			item--;
			// System.out.println("item2" + item);
			return (indexOf(item) + 1);
		}

	public SortedSet subSet(int fromElement, int toElement) {
		// System.out.println("subset");
		SortedSet set = new SortedSet();
		if (indexOf(fromElement) > indexOf(toElement)) {
			System.out.println("Invalid Arguments to Subset Exception");
			return null;
		} else {
			for (int i = indexOf(fromElement); i < indexOf(toElement); i++) {
			set.add(sortedset[i]);
		}
	}
	return set;
	}
	public SortedSet headSet(int toElement) {
		SortedSet set = new SortedSet();
		for (int i = 0; i < size(); i++) {
			if(sortedset[i] < toElement) {
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
        SortedSet s = new SortedSet();
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
                intArray = intArray(tokens[1]);
                s.addAll(intArray);
                break;
                case "intersection":
                s = new SortedSet();
                SortedSet t = new SortedSet();
                intArray = intArray(tokens[1]);
                s.addAll(intArray);
                intArray = intArray(tokens[2]);
                t.addAll(intArray);
                System.out.println(s.intersection(t));
                break;
                case "retainAll":
                s = new SortedSet();
                intArray = intArray(tokens[1]);
                s.addAll(intArray);
                intArray = intArray(tokens[2]);
                System.out.println(s.retainAll(intArray));
                break;
                case "cartesianProduct":
                s = new SortedSet();
                t = new SortedSet();
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
                SortedSet object = s.subSet(Integer.parseInt(arrstring3[0]),
                                        Integer.parseInt(arrstring3[1]));
                if (object != null) {
                    System.out.println(object);
                }
                break;
                case "headSet":
                System.out.println(s.headSet(Integer.parseInt(tokens[1])));
                break;
                case "last":
                System.out.println(s.last());
                default:
                break;
            }
        }
    }
}
