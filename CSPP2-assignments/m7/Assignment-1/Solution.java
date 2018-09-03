import java.util.*;
class InputValidator
{
	private String s;
	private int inputLength;

	public InputValidator(String s, int inputLength) {
		this.s = s;
		this.inputLength = inputLength;
	}
	public boolean validateData() {
		return inputLength >= 6;
	}
}
public class Solution
{
	public static void main(String args[])
    {
    	Scanner s=new Scanner(System.in);
    	String input=s.next();
    	InputValidator i=new InputValidator(input, input.length());    	
    	System.out.println(i.validateData());

    }

}
