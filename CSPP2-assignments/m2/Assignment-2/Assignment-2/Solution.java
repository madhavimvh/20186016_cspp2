import java.util.Scanner;
/**
*To take the input from the user.
*/
public final class Solution {
    /**
    *@variable FOUR.
    */
    private static final int FOUR = 4;
    /**
    *Do not modify this main function.
    *@param args as variable
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        rootsOfQuadraticEquation(a, b, c);
        //System.out.println(a + " " + b);
    }
    /**
    *To print the roots of a quadratic equation.
    *@param a variable
    *@param b variable
    *@param c variable
    */
    public static void rootsOfQuadraticEquation(final int a,
                                                final int b,
                                                final int c) {
        int determinant = (b * b) - (FOUR * a * c);
        if (determinant > 0) {
            double root1 = (-b + Math.sqrt(determinant)) / (2 * a);
            double root2 = (-b - Math.sqrt(determinant)) / (2 * a);
            System.out.println(root1 + " " + root2);
        }
        else if(determinant == 0) {
            double b_double = b;
            double root = -b_double / (2 * a);
            System.out.println(root + " " + root);
        }
    }
    /*
    Need to write the rootsOfQuadraticEquation function and print the output.
    */
}
