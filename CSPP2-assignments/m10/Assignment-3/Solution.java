/**
 * @author : madhavimvh
 */
import java.io.BufferedInputStream;
import java.util.Scanner;
// A Class is implemented for Student details
/**
 * class Student.
 */
final class Student {
    /**
     * name is a String data type.
     */
    private String name;
    /**
     * Constructs the object.
     *
     * @param      namee  The name
     */
    Student(final String namee) { //A constructor used to initialize
        //the instance variables
        this.name = namee;
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() { //Getter method which returns the value
        //of instance variable
        return this.name;
    }
    /**
     * returns true if both the items are equal.
     *
     * @param      other  The other
     *
     * @return     returns boolean.
     */
    @Override
    public boolean equals(final Object other) { //This method is to check
        //if two students names are equal or not
        if (!(other instanceof Student)) {
            return false;
        }
        Student that = (Student) other;
        return this.getName().equals(that.getName());
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public int hashCode() {
      return 0;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return this.name;
    }
}
/**
 * class Solution.
 */
public final class Solution {
  /**
   * empty constructor.
   */
  private Solution() {
  }
  /**
   * Constructs the object.
   *
   * @param      stdin  The stdin
   */
  public static void executeListString(final Scanner stdin) {
    List<String> listString = new List();
                while (stdin.hasNext()) {
                    // read the line
                    String line = stdin.nextLine();
                    // split the line using space
                    String[] tokens = line.split(" ");
                    // based on the list operation invoke the corresponding
                    //method
                    switch (tokens[0]) {
                        case "add":
                            listString.add(tokens[1]);
                        break;
                        case "addAll":
                        if (tokens.length == 2) {
                        String[] t1 = tokens[1].split(",");
                        listString.addAll(t1);
                        }
                        break;
                        case "size":
                        // invoke size method and print the list size
                        // BTW, list size is not the array size
                        // it is the number of items in the list
                        System.out.println(listString.size());
                        break;
                        case "print":
                        // print the list (implement toString in List class
                        //for this to work)
                        // expected format is [item-1,item-2,...,item-n]
                        // review the output testcase file
                        System.out.println(listString);
                        break;
                        case "remove":
                        listString.remove(Integer.parseInt(tokens[1]));
                        break;
                        case "indexOf":
                        System.out.println(listString.indexOf(tokens[1]));
                        break;
                        case "get":
                        System.out.println(listString.get(
                          Integer.parseInt(tokens[1])));
                        break;
                        case "contains":
                        System.out.println(listString.contains(tokens[1]));
                        break;
                        default:
                        break;
                    }
                }
            }
    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // create an object of the list to invoke methods on it
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        String objectType = stdin.nextLine();
        switch (objectType) {
            case "S"://This case will be executed for String type list
            case "I"://This case will be executed for Integer type list
            case "F"://This case will be executed for Float type list
            case "C"://This case will be executed for Character type list
            case "D"://This case will be executed for Double type list
            case "O"://This case will be executed for Student type list
            //i.e to store List of Student Objects
                List<Student> listStudent = new List();
                while (stdin.hasNext()) {
                    // read the line
                    String line = stdin.nextLine();
                    // split the line using space
                    String[] tokens = line.split(" ");
                    // based on the list operation invoke the corresponding
                    //method
                    switch (tokens[0]) {
                        case "add":
                            listStudent.add(new Student(tokens[1]));
                        break;
                        case "addAll":
                        if (tokens.length == 2) {
                        String[] t1 = tokens[1].split(",");
                        Student[] temp = new Student[t1.length];
                        for (int i = 0; i < t1.length; i++) {
                            temp[i] = new Student(t1[i]);
                        }
                        listStudent.addAll(temp);
                        }
                        break;
                        case "size":
                        // invoke size method and print the list size
                        // BTW, list size is not the array size
                        // it is the number of items in the list
                        System.out.println(listStudent.size());
                        break;
                        case "print":
                        // print the list (implement toString in List class
                        //for this to work)
                        // expected format is [item-1,item-2,...,item-n]
                        // review the output testcase file
                        System.out.println(listStudent);
                        break;
                        case "remove":
                        listStudent.remove(Integer.parseInt(tokens[1]));
                        break;
                        case "indexOf":
                        System.out.println(listStudent.indexOf(
                          new Student(tokens[1])));
                        break;
                        case "get":
                        System.out.println(listStudent.get(
                          Integer.parseInt(tokens[1])));
                        break;
                        case "contains":
                        System.out.println(listStudent.contains(
                          new Student(tokens[1])));
                        break;
                        default:
                        break;
                    }
                }
                break;
            default:
            break;
        }
    }
}
