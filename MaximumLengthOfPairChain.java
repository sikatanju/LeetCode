import java.util.Arrays;

public class MaximumLengthOfPairChain {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int len = pairs.length;
        int[] res = new int[len];
        int maxRes = Integer.MIN_VALUE;
        res[len-1] = 1;
        for (int i=len-2; i>=0; i--)    {
            int high = pairs[i][1], max = -1;
            for (int j=i+1; j<len; j++) {
                if (pairs[j][0] > high)
                    max = Math.max(res[j], max);
            }
            res[i] = max > -1 ? max+1: 1;
            maxRes = Math.max(res[i], maxRes);
        }
        return maxRes > 0 ? maxRes: 1;
    }
}
/* Best runtime: 2ms:
class Solution {
    public int findLongestChain(int[][] pairs) {
        int minL = Integer.MAX_VALUE, maxR = Integer.MIN_VALUE;
        for (int[] pair : pairs) {
            int l = pair[0], r = pair[1];
            minL = Math.min(minL, l);
            maxR = Math.max(maxR, r);
        }
        int[] rtol = new int[maxR - minL + 2];
        for (int[] pair : pairs) {
            int l = pair[0] - minL + 1, r = pair[1] - minL + 1;
            rtol[r] = Math.max(rtol[r], l);
        }
        int curMax = 0, ans = 0;
        for (int r = 1; r <= maxR - minL + 1; ++r) {
            if (rtol[r] > curMax) {
                curMax = r;
                ++ans;
            }
        }
        return ans;
    }
}
 */


/* Second Best runtime: 4ms:
class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));
        int count = 1;
        int max = pairs[0][1];

        for(int i = 1 ; i < pairs.length ; i++){
            if(max < pairs[i][0]){
                count++;
                max = pairs[i][1];
            }
        }

        return count;
    }
}
 */