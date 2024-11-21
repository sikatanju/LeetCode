import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSubsequence {
    public int longestArithSeqLength(int[] nums) {
        int len = nums.length, max = -1;
        Map<Integer, Integer>[] map = new Map[len];

        for (int i=0; i<len; i++)	{
            map[i] = new HashMap<>();
            for (int j=0; j<i; j++)	{
                int temp = nums[i]-nums[j];
                map[i].put(temp, map[j].getOrDefault(temp, 1)+1);
                max = Math.max(map[i].get(temp), max);
            }
        }
        return max;
    }
}

/* Second best runtime: 42ms:
class Solution {
    public int longestArithSeqLength(int[] nums) {
        int max = 0;
        for (int num : nums)
            max = Math.max(num, max);

        // the difference will be in the range of [-max, max]; 0 -> -max while 2 * max
        // -> max
        // dp[i][j] means the number of element in the sequane ending at value i with a
        // gap of j-max so far
        int[][] dp = new int[max + 1][2 * max + 1];
        int result = 0;

        for (int i = 0; i < nums.length; i++) {

            int cur = nums[i];

            for (int j = 0; j <= 2 * max; j++) {

                int diff = j - max;

                // cur - last = diff
                int last = cur - diff;

                // it is very important either use dp[last][j] + 1 or 1 rather than use dp[cur][j] += 1
                // dp[cur][j] can appear again and again say for a seq of 3....0....0
                // 0 appears twice and [3, 0] sequence is counted twice, which is 3 instead of 2(the right answer)
                // but if we increase dp[max+1][] to dp[2*max+1], we should be fine
                if (last <= max && last >= 0) // the last value CAN OVERFLOWS
                    dp[cur][j] = dp[last][j] + 1;
                else dp[cur][j] = 1;

                result = Math.max(result, dp[cur][j]);
            }
        }

        return result;
    }
}
// [24,13,1,100,0,94,3,0,3]
 */