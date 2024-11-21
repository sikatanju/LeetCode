import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        int rowLen = dungeon.length, columnLen = dungeon[0].length;
        int[][] dp = new int[rowLen+1][columnLen+1];

        for (int[] row: dp)
            Arrays.fill(row, Integer.MAX_VALUE);

        dp[rowLen][columnLen-1] = dp[rowLen-1][columnLen] = 1;

        for (int i=rowLen-1; i>=0; i--) {
            for (int j=columnLen-1; j>=0; j--)    {
                int minHealth = Math.min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j];
                dp[i][j] = minHealth <= 0 ? 1: minHealth;
            }
        }
        return dp[0][0];
    }
}

/* Best runtime: 0ms
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int[][] dp = new int[dungeon.length + 1][dungeon[0].length + 1];
        for (int i = 0; i < dungeon.length + 1; i++)
            Arrays.fill(dp[i], -1);

        return mhr(dungeon, 0, 0, dp);
    }

    int mhr(int[][] arr, int i, int j, int[][] dp) {
        if (dp[i][j] != -1)
            return dp[i][j];
        if (i == arr.length - 1 && j == arr[0].length - 1)
            return arr[i][j] > 0 ? 1 : Math.abs(arr[i][j]) + 1;
        if (i == arr.length || j == arr[0].length)
            return Integer.MAX_VALUE;

        return dp[i][j] = Math.max(1, Math.min(mhr(arr, i + 1, j, dp), mhr(arr, i, j + 1, dp)) - arr[i][j]);
    }

}
 */

/* 2nd best: 1ms:
class Solution {
    public static int[][] dp;
    public int calculateMinimumHP(int[][] dungeon) {
         int n = dungeon.length;
        int m = dungeon[0].length;
        dp = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j] = -1;
            }
        }
        return dungeonPrincess(dungeon,0,0);
    }
    public int dungeonPrincess(int[][] A,int i,int j){
        int n = A.length;
        int m = A[0].length;
        if(i >= n || j >= m) return Integer.MAX_VALUE;
        if(i == n-1 && j == m-1) return Math.max(1,1-A[i][j]);
        if(dp[i][j] != -1 ) return dp[i][j];
        int a = dungeonPrincess(A,i,j+1);
        int b = dungeonPrincess(A,i+1,j);
        int minHPnext = Math.min(a,b);
        dp[i][j] = Math.max(1,minHPnext-A[i][j]);
        return dp[i][j];
    }
}
 */