import java.util.Scanner;
/**
 * Class for input validator.
 */
class InputValidator {
    /**
     * { var_description }.
     */
    private static final int SIX = 6;
    /**
     * { var_description }.
     */
    private String aa;
    /**
     * { var_description }.
     */
    private int inputlength;
    /**
     * Constructs the object.
     *
     * @param      a            { parameter_description }.
     * @param      inputLength  The input length
     */
    public InputValidator(String a, int inputLength) {
        this.aa = a;
        this.inputlength = inputLength;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public boolean validateData() {
        return inputlength >= SIX;
    }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * { item_description }.
     */
    private Solution() {
    }
    /**
     * @param      args  { parameter_description }.
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        InputValidator i = new InputValidator(input, input.length());
        System.out.println(i.validateData());
    }
}
//other way to write the same program.
// class InputValidator{
//  private String s;
//  private int inputLength;
//  public InputValidator(String s) {
//      this.s = s;
//      this.inputLength = s.length();
//  }
//  public boolean validateData() {
//      return inputLength >= 6;
//  }
// }
// public class Solution
// {
//  public static void main(String args[])
//     {
//      Scanner s=new Scanner(System.in);
//      String input=s.next();
//      InputValidator i=new InputValidator(input);
//      System.out.println(i.validateData());
//     }
// }
