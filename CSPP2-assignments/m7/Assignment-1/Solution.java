import java.util.*;
class InputValidator{
	private String s;
	private int inputLength;

	public InputValidator(String s) {
		this.s = s;
		this.inputLength = s.length();
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
    	InputValidator i=new InputValidator(input);    	
    	System.out.println(i.validateData());

    }

}
