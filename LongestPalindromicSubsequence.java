import java.nio.charset.StandardCharsets;

public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        char[] arr = s.toCharArray();
        int[][] dp = new int[len][len];

        for (int i = len-1; i>=0; i--)  {
            dp[i][i] = 1;
            for (int j=i+1; j<len; j++) {
                if (arr[i] == arr[j])
                    dp[i][j] = dp[i+1][j-1] + 2;
                else
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
            }
        }
        return dp[0][len-1];
    }
}

/* Best runtime: 8ms :
class Solutions {
    public int longestPalindromeSubseq(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i ++) {
            int max = 0;
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j --) {
                // dp[j] is longest palindrome in interval j - i-1
                int curVal = dp[j];
                if (c[j] == c[i]) {
                    // add 2 to the longest palindrome found
                    // palindrome will definitely be between j+1 and i-1
                    dp[j] = max + 2;
                }
                // finding longest palindrome in interval j - i
                max = Math.max(max, curVal);
            }
        }
        int ans = 1;
        for (int i : dp) {
            ans = Math.max(ans, i);
        }
        return ans;
    }
}
 */

/* 10ms runtime:
class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        char[] c = s.toCharArray();
        int[] f = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int pre = 0;
            f[i] = 1;
            for (int j = i + 1; j < n; j++) {
                int tmp = f[j];
                f[j] = c[i] == c[j] ? pre + 2 : Math.max(f[j], f[j - 1]);
                pre = tmp;
            }
        }
        return f[n - 1];
    }
}
 */