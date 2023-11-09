public class TheKthFactorOfN {
    public int kthFactor(int n, int k) {
        int doesMatch = 1;
        for (int i=1; i<=n; i++)    {
            if (n % i == 0) {
                if (doesMatch == k)
                    return i;

                doesMatch++;
            }
        }
        return -1;
    }
}
