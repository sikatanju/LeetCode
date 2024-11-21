public class LongestIncreasingPathInAMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        int max = 0;
        int rLen = matrix.length, cLen = matrix[0].length;
        if (rLen == 1 && cLen == 1)
            return 1;

        int[][] cache = new int[rLen][cLen];
        for (int i=0; i<rLen; i++)  {
            for (int j=0; j<cLen; j++)  {
                max = Math.max(max, dfs(i, j, rLen, cLen, matrix, cache, null));
            }
        }
        return max;
    }
    private int dfs(int i, int j, int rLen, int cLen, int[][] matrix, int[][] cache, Integer prev)  {
        if (i < 0 || j < 0 || i >= rLen || j >= cLen)
            return 0;

        if (prev != null && prev >= matrix[i][j])
            return 0;
        if (cache[i][j] > 0)
            return cache[i][j];

        int tempMax = dfs(i+1, j, rLen, cLen, matrix, cache, matrix[i][j]);
        tempMax = Math.max(dfs(i-1, j, rLen, cLen, matrix, cache, matrix[i][j]), tempMax);
        tempMax = Math.max(dfs(i, j+1, rLen, cLen, matrix, cache, matrix[i][j]), tempMax);
        tempMax = Math.max(dfs(i, j-1, rLen, cLen, matrix, cache, matrix[i][j]), tempMax);
        cache[i][j] = ++tempMax;
        return cache[i][j];
    }
}

/*
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] cache = new int[m][n];
        int max = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                max = Math.max(max, dfs(cache, matrix, m, n, i, j, null));
            }
        }
        return max;
    }

    private int dfs(int[][] cache, int[][] matrix, int m, int n, int i, int j , Integer prev) {
        if(i < 0 || i >= m || j < 0 || j >= n) {
            return 0;
        }
        if(prev != null && prev >= matrix[i][j]) {
            return 0;
        }
        if(cache[i][j] != 0) {
            return cache[i][j];
        }

        int a = dfs(cache, matrix, m, n, i+1, j, matrix[i][j]);
        int b = dfs(cache, matrix, m, n, i-1, j, matrix[i][j]);
        int c = dfs(cache, matrix, m, n, i, j-1, matrix[i][j]);
        int d = dfs(cache, matrix, m, n, i, j+1, matrix[i][j]);
        cache[i][j] =  Math.max(Math.max(a,b),Math.max(c,d)) + 1;
        return cache[i][j];
    }
}
*/

/*Second Best:  6ms runtime:
class Solution {
    private int dfs(int i, int j, int[][] matrix, int[][] dp) {
        if(dp[i][j] != -1) return dp[i][j];

        int m = matrix.length;
        int n = matrix[0].length;
        int val = matrix[i][j];
        int ans = 1;
        if(i+1 < m && matrix[i+1][j]>val) {
            ans = Math.max(ans, 1+dfs(i+1, j, matrix, dp));
        }
        if(j+1 < n && matrix[i][1+j]>val) {
            ans = Math.max(ans, 1+dfs(i, 1+j, matrix, dp));
        }
        if(i-1 >= 0 && matrix[i-1][j]>val) {
            ans = Math.max(ans, 1+dfs(i-1, j, matrix, dp));
        }
        if(j-1 >= 0 && matrix[i][j-1]>val) {
            ans = Math.max(ans, 1+dfs(i, j-1, matrix, dp));
        }
        return dp[i][j] = ans;
    }
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++) Arrays.fill(dp[i], -1);
        int ans = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                ans = Math.max(ans, dfs(i, j, matrix, dp));
            }
        }
        return ans;
    }
}
 */
