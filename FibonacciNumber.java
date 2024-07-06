public class FibonacciNumber {
    public int fib(int n) {
        int[] ara = new int[31];
        ara[0] = 0;
        ara[1] = 1;

        if (n <= 1)
            return ara[n];

        for (int i=2; i<=n; i++) {
            ara[i] = ara[i-1]+ara[i-2];
        }
        return ara[n];
    }
}
