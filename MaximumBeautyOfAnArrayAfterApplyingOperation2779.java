public class MaximumBeautyOfAnArrayAfterApplyingOperation2779 {
    /*
    public int maximumBeauty(int[] nums, int k) {
        int[] res = new int[200002];
        for (int num: nums)   {
            int low = num-k < 0 ? 0 : num-k;
            int high = num+k;
            res[low]++;
            res[high+1]--;
        }
        int max = res[0];
        for (int i=1; i<res.length; i++)    {
            res[i] += res[i-1];
            max = Math.max(res[i], max);
        }
        return max;
    }
     */
}

/* Best runtime: 7ms:
class Solution {
    public int maximumBeauty(int[] nums, int k) {
        int sum = 0, n = nums.length;
        int min = Integer.MAX_VALUE, max = 0;

        // Step 1: Calculate the range of possible values after operations
        for(int i: nums) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        // Step 2: Update k to be the effective window size
        k = k * 2 + 1;

        // If the range that can be covered by k includes all possible values, return n
        if(k >= max - min + 1)
            return n;

        // Step 3: Create frequency array for all possible transformed values
        int[] freq = new int[max - min + 1];
        for(int i: nums)
            freq[i - min]++;

        // Step 4: Apply sliding window to calculate maximum beauty
        for(int i = 0; i < k; i++)
            sum += freq[i];

        int res = sum;
        for(int i = k; i < freq.length; i++) {
            res = Math.max(res, sum += freq[i] - freq[i - k]);
        }

        return res;
    }
}
 */