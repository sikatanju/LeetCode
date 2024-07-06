public class NthTribonacciNumber {
    public int tribonacci(int n) {
        int[] ara = new int[38];
        ara[0] = 0;
        ara[1] = 1;
        ara[2] = 1;

        if (n==0)
            return 0;
        if (n <= 2)
            return 1;

        for (int i=3; i<=n; i++) {
            ara[i] = ara[i-1]+ara[i-2]+ara[i-3];
        }
        return ara[n];
    }
}
