public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String str1, String str2) {
        char[] strArray1 = str1.toCharArray();
        char[] strArray2 = str2.toCharArray();

        int str1Len = str1.length(), str2Len = str2.length();
        int[][] dp = new int[str1Len+1][str2Len+1];

        for (int i=0; i<str1Len; i++)    {
            for (int j=0; j<str2Len; j++)    {
                if (strArray1[i] == strArray2[j])
                    dp[i+1][j+1] = 1 + dp[i][j];
                else
                    dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
            }
        }
        return dp[str1Len][str2Len];
    }
}

/* Best Runtime 5ms :

class Solution {
    public int longestCommonSubsequence(String t1, String t2) {
        int[] memo = new int[t2.length() + 1];
        char[] t1c = t1.toCharArray(), t2c = t2.toCharArray();
        for (int i = t1c.length - 1; i > -1; i--) {
            int previousRigth = 0, newRight = 0;
            for (int j = t2c.length - 1; j > -1; j--) {
                int tmp = memo[j];
                int max;
                if (t1c[i] == t2c[j]) max = previousRigth + 1;
                else max = Math.max(tmp, newRight);
                memo[j] = newRight = max;
                previousRigth = tmp;
            }
        }
        return memo[0];
    }
}


############# 6ms runtime :

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() < text2.length()) {
            return longestCommonSubsequence(text2, text1);
        }

        int n = text1.length();
        int m = text2.length();

        int[] previous = new int[n + 1];
        int[] current = new int[m + 1];

        char[] t1 = text1.toCharArray();

        char[] t2 = text2.toCharArray();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (t1[i - 1] == t2[j - 1]) {
                    current[j] = previous[j - 1] + 1;
                } else {
                    current[j] = Math.max(previous[j], current[j - 1]);
                }
            }

            int[] temp = previous;
            previous = current;
            current = temp;
        }

        return previous[m];
    }
}
*/