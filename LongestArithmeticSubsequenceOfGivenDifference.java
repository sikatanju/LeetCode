import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSubsequenceOfGivenDifference {
    public int longestSubsequence(int[] arr, int difference) {
        int len = arr.length, max = -1;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<len; i++)	{
            int diff = arr[i]-difference;
            map.put(arr[i], map.getOrDefault(diff, 0)+1);
            max = Math.max(map.get(arr[i]), max);
        }
        return max == -1 ? 0 : max;
    }
}

/* Best runtime: 3ms:
class Solution {
   public int longestSubsequence(int[] arr, int difference) {
        int[] dp = new int[40002];
        int ans = 0;
        // difference += 10000;
        for (int i = 0; i < arr.length; i++) {
            // working with overflow of array size
            arr[i] += 20000;
        }

        for (int i : arr) {
            dp[i] = 1 + dp[i - difference];
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
 */