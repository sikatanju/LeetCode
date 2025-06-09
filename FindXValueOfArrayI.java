public class FindXValueOfArrayI {
    public long[] resultArray(int[] nums, int k) {
        long[] res = new long[k];
        long[] prev = new long[k];
        for (int num: nums) {
            int numm = num % k;
            long[] curr = new long[k];
            curr[numm]++;
            for (int i=0; i<k; i++) {
                if (prev[i] > 0)    {
                    int j = (i * numm) % k;
                    curr[j] += prev[i];
                }
            }
            for (int i=0; i<k; i++) {
                res[i] += curr[i];
            }
            prev = curr;
        }
        return res;
    }
}