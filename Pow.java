public class Pow {
    public double myPow(double x, int n) {
        if (x == 0)
            return 0;
        if (n == 0)
            return 1;

        return n > 0 ? myPower(x, n) : 1/myPower(x, Math.abs(n));
    }

    private double myPower(double x, int n) {
        if (n == 0)
            return 1;

        double result = myPower(x, n/2);
        result *= result;

        return (n % 2 == 0) ? result : result * x;
    }
}
