public class RegularExpressionMatching {
    private char[] ss, pp;
    private int sLen, pLen;
    Boolean[][] dp;
    public boolean isMatch(String s, String p) {
        ss = s.toCharArray();
        pp = p.toCharArray();
        sLen = s.length();
        pLen = p.length();
        dp = new Boolean[sLen+1][pLen+1];
        return dfs(0, 0);
    }

    private boolean dfs(int i, int j)   {
        if (i < sLen && j < pLen && dp[i][j] != null)
            return dp[i][j];

        if (i >= sLen && j >= pLen)
            return true;
        if (j >= pLen)
            return false;

        boolean doesMatch = i < sLen && (ss[i] == pp[j] || pp[j] == '.');

        if (j+1 < pLen && pp[j+1] == '*')   {
            dp[i][j] = dfs(i, j+2) || (doesMatch && dfs(i+1, j));
            return dp[i][j];
        }
        if (doesMatch)  {
            dp[i][j] = dfs(i+1, j+1);
            return dp[i][j];
        }
        dp[i][j] = false;
        return dp[i][j];
    }
}


/* Neetcode Solution: 
 public class Solution {
    private Boolean[][] dp;

    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        dp = new Boolean[m + 1][n + 1];
        return dfs(0, 0, s, p, m, n);
    }

    private boolean dfs(int i, int j, String s, String p, int m, int n) {
        if (j == n) {
            return i == m;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }

        boolean match = i < m && (s.charAt(i) == p.charAt(j) || 
                                  p.charAt(j) == '.');
        if (j + 1 < n && p.charAt(j + 1) == '*') {
            dp[i][j] = dfs(i, j + 2, s, p, m, n) || 
                       (match && dfs(i + 1, j, s, p, m, n));
        } else {
            dp[i][j] = match && dfs(i + 1, j + 1, s, p, m, n);
        }

        return dp[i][j];
    }
}
 */