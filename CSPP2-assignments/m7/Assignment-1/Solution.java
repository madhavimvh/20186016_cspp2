import java.util.Scanner;
/**
 * Class for input validator.
 */
class InputValidator {
    /**
     * { var_description }.
     */
    private static final int SIX = 6;
    private String aa;
    private int inputlength;
    /**
     * Constructs the object.
     *
     * @param      s            { parameter_description }.
     * @param      inputLength  The input length
     */
    public InputValidator(final String a, final int inputLength) {
        this.aa = a;
        this.inputlength = inputLength;
    }
    public boolean validateData() {
        return inputlength >= SIX;
    }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * @param      args  { parameter_description }.
     */
    public static void main(final String args[]) {
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