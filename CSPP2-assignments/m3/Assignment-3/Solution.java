
import java.util.Scanner;
/*
	Do not modify this main function.
	*/
public final class Solution {
    /**
     * empty constructor.
     */
    private Solution(){
    }
    /**
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(String[] args) {

        Scanner s=new Scanner(System.in);      
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        //gcd(n1,n2);
        System.out.println(gcd(n1, n2));
    }
    static int gcd(int n1, int n2) {
        int temp = 1;
        int i;
        for(i=1;i<=n1 && i <=n2;i++){
            if(n1 % i == 0 && n2 == 0){
                temp = i;

            }
            
        }
        return temp;
    }
}


