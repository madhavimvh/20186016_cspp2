import java.util.Scanner;
class InputValidator {
    /**
     * { var_description }.
     */
    private static final int SIX = 6;
    private String s;
    private int inputLength;
    /**
     * Constructs the object.
     *
     * @param      s            { parameter_description }
     * @param      inputLength  The input length
     */
    public InputValidator(final String s, final int inputLength) {
        this.s = s;
        this.inputLength = inputLength;
    }
    public boolean validateData() {
        return inputLength >= SIX;
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

