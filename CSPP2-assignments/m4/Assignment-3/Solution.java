// Given an String, Write a java method that returns 
// the decimal value for the given binary string.
import java.util.*;
import java.util.Arrays;
public class Solution {
    /**
    Do not modify this main function.
    
    @param      args  The arguments
    */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        for(int i=0;i<n;i++) {
            String s=sc.next();
            //System.out.println(s);
            // int res=binaryToDecimal(s);//Write binaryToDecimal function
            // int ress = intToDecimal(Integer.parseInt(s));
            int ress = intToDecimal(s);
            System.out.println(ress);
            // System.out.println(res);
        }
    }
    //
    // public static int binaryToDecimal(String s) { double j = 0; for (int i =
    // 0; i < s.length(); i++){ if(s.charAt(i) == '1'){
    // //System.out.println(s.charAt(i)); j = j + Math.pow(2, s.length()-1-i);
    // //System.out.println(j); //System.out.println(s.length()-1-i); } } return
    // (int) j; }
    /**
    *@param      s     { parameter_description }
    *
    * @return     { description_of_the_return_value }
    */
    public static int intToDecimal(String s) {
        int temp = 0;
        // int length = String.valueOf(s).length();
        for (int i = 0; i < s.length(); i++) {
            // System.out.println(s.length());
            int n = Integer.parseInt (String.valueOf (s.charAt(i)));
            temp += n * Math.pow(2, s.length() - 1 - i);
            // System.out.println(temp);
        }
        return temp;
    }
}





