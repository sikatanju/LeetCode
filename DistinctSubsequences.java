import java.util.List;

public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        char[] str1 = s.toCharArray(), str2 = t.toCharArray();
        int[] dp = new int[sLen+1], curr = new int[sLen+1];
        for (int i=0; i<=sLen; i++)
            dp[i] = 1;

        for (int i=1; i<=tLen; i++)  {
            curr = new int[sLen+1];
            for (int j=1; j<=sLen; j++) {
                if (str1[j-1] == str2[i-1])
                    curr[j] = curr[j-1] + dp[j-1];
                else
                    curr[j] = curr[j-1];
            }
            dp = curr;
        }
        return dp[sLen];
    }
}
/* Best runtime: 2ms:
class Solution {
    Integer[][] memo;
    public int numDistinct(String s, String t) {
        memo = new Integer[s.length()][t.length()];
        return rec(0,0,s,t);
    }
    public int rec(int i,int j,String s,String t){
        if(j==t.length()){
            return 1;
        }
        if(i==s.length()){
            return 0;
        }
        if(s.length()-i<t.length()-j){
            return 0;
        }
        if(memo[i][j]!=null){
            return memo[i][j];
        }
        int ans = 0;
        if(s.charAt(i)==t.charAt(j)){
            ans = rec(i+1,j+1,s,t);
        }
        ans += rec(i+1,j,s,t);
        return memo[i][j] = ans;
    }
}
 */
/*

    public int numDistinct(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        int[][] dp = new int[tLen+1][sLen+1];
        for (int i=0; i<=sLen; i++)
            dp[0][i] = 1;

        for (int i=1; i<=tLen; i++)  {
            for (int j=1; j<=sLen; j++)  {
                if (t.charAt(i-1) == s.charAt(j-1)) {
                    dp[i][j] = dp[i][j-1]+dp[i-1][j-1];
                }   else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[tLen][sLen];
    }
 */

/*

    private int count;
    private char[] str1, str2;
    public int numDistinct(String s, String t) {
        int len1 = s.length(), len2 = t.length();
        this.count = 0;
        if (len2 > len1)
            return 0;

        str1 = s.toCharArray();
        str2 = t.toCharArray();

        dfs(0, 0, len1, len2, 1);
        return this.count;
    }
    private void dfs(int i, int j, int len1, int len2, int count)    {
        if (i >= len1 || j >= len2 || count == len2) {
            if (i<len1 && j<len2 && str1[i] == str2[j])
                this.count++;

            return;
        }


        if (str1[i] == str2[j]) {
            dfs(i+1, j+1, len1, len2, count+1);
            dfs(i+1, j, len1, len2, count+1);
        }
        else    {
            dfs(i+1, j, len1, len2, count);
        }
    }
 */