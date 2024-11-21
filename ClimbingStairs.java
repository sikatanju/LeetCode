// Climbing Stairs -- https://leetcode.com/problems/climbing-stairs/ 

public class ClimbingStairs {
    public int climbStairs(int n) {
        int[] ara = new int[n+1];
        ara[0] = 1;
        ara[1] = 1;
        if (n < 2)
            return 1;

        for (int i=2; i<=n; i++)
            ara[i] = ara[i-1]+ara[i-2];

        return ara[n];
    }

    // private int[] fiboNum;
    // private int num = 0;
    /*public int climbStairs(int n)   {
        fiboNum = new int[n+1];
        fibo(n);
        int temp = num + 1;
        return temp;
    }*/
//    private int[] fibo;
//    public int climbStairs(int n)   {
//        fibo = new int[n+1];
//        int sum = 0;
//        for (int i=0; i<n; i++) {
//            sum += fiboo(i);
//        }
//        return ++sum;
//    }
//    private int fiboo(int n)    {
//        if (n <= 1)
//            return n;
//
//        if (fibo[n] != 0)
//            return fibo[n];
//
//        fibo[n] = (fiboo(n-1) + fiboo(n-2));
//        return fibo[n];
//    }
}
