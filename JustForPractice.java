
// import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class JustForPractice    {
    private static int[] fibo;

    public static int fiboo(int n)   {
        if (n<=1)
            return n;
        
        if (fibo[n] != 0)
            return fibo[n];

        fibo[n] = (fiboo(n-1) + fiboo(n-2));
        // System.out.print(fibo[n] + ", ");
        return fibo[n];
    }

    public static void main(String[] args)  {
        int n = 6;
        // System.out.print ("0, 1, ");
        fibo = new int[n+1];        
        System.out.println (fiboo(n));
        // JustForPractice obj = new JustForPractice();
    }
}