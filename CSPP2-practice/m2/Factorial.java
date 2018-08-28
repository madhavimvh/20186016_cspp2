import java.util.Scanner;
/**
 * Class for factorial.
 */
public final class Factorial {
    /**
     * Empty constructor.
     */
    private Factorial(){

    }
    /**
     * parameters.
     *
     * @param args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int f = fact(n);
        System.out.println(f);

    }
    /**
     * { function_description }.
     *
     * @param      n     { parameter_description }
     */
    public static int fact(final int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else
        {
        int fact = n * fact(n -1);
        return fact;
        }
    }
}