public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int rowLen = matrix.length, columnLen = matrix[0].length, min = Integer.MAX_VALUE;
        if (rowLen == 1)    {
            for (int i=0; i<rowLen; i++)
                min = Math.min(min, matrix[0][i]);

            return min;
        }
        if (columnLen == 1) {
            for (int i=0; i<columnLen; i++)
                min = Math.min(min, matrix[i][0]);

            return min;
        }
        for (int i=1; i<rowLen; i++)    {
            for (int j=0; j<columnLen; j++) {
                if (j == 0)
                    matrix[i][j] += Math.min(matrix[i - 1][j], matrix[i - 1][j + 1]);
                else if (j == columnLen-1)
                    matrix[i][j] += Math.min(matrix[i-1][j], matrix[i-1][j-1]);
                else {
                    min = Math.min(matrix[i-1][j-1], matrix[i-1][j]);
                    min = Math.min(min, matrix[i-1][j+1]);
                    matrix[i][j] += min;
                }
            }
        }
        min = Integer.MAX_VALUE;
        for (int j=0; j<columnLen; j++)
            min = Math.min(matrix[rowLen-1][j], min);

        return min;
    }
}
/* 1ms runtime: with explanation:
Approaches
(Also explained in the code)

Initialization: Initialize a 2D vector dp to store the minimum falling path sum for each cell. Initialize ans to INT_MAX as the result.

Base Cases: If the matrix has only one row or one column, return the only element in the matrix as the minimum falling path sum.

Iterative Over First Row: Iterate over the elements in the first row of the matrix and find the minimum falling path sum by calling a recursive function minFallingPathSum for each element.

Recursive Function: The minFallingPathSum function calculates the minimum falling path sum recursively. It uses memoization to avoid redundant calculations. If the result for a particular cell is already calculated, it is directly returned from the memoized table.

Dynamic Programming: For each cell, calculate the minimum falling path sum considering three possible directions: left, straight, and right. Update the memoized table with the minimum sum.

Return Result: Return the minimum falling path sum obtained from iterating over the first row.

##################################

public class Solution {
    public int minFallingPathSum(int[][] A) {
        int m = A.length;
        int n = A[0].length;

        if (m == 1 || n == 1) return A[0][0];

        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < A.length; ++i) {
            ans = Math.min(ans, minFallingPathSum(A, 0, i, dp));
        }

        return ans;
    }

    private int minFallingPathSum(int[][] A, int row, int col, int[][] dp) {
        int m = A.length;
        int n = A[0].length;

        if (dp[row][col] != Integer.MAX_VALUE) return dp[row][col];

        if (row == m - 1)
            return dp[row][col] = A[row][col];

        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;

        if (col > 0)
            left = minFallingPathSum(A, row + 1, col - 1, dp);

        int straight = minFallingPathSum(A, row + 1, col, dp);

        if (col < n - 1)
            right = minFallingPathSum(A, row + 1, col + 1, dp);

        dp[row][col] = Math.min(left, Math.min(straight, right)) + A[row][col];

        return dp[row][col];
    }
}

 */


/* Best runtime : 0ms ->
class Solution {
    public void minSum(int[][] mat, int n, int r)
    {
        if(r < 0)
            return;
        for(int i = 0; i < n; i++)
        {
            int nextMin = mat[r + 1][i] + mat[r][i];
            if(i > 0)
                nextMin = Math.min(nextMin, mat[r + 1][i - 1] +
                 mat[r][i]);
            if(i < n - 1)
                nextMin = Math.min(nextMin, mat[r + 1][i + 1] +
                 mat[r][i]);
            mat[r][i] = nextMin;
        }
        minSum(mat, n, r - 1);
    }
    public int minFallingPathSum(int[][] matrix)
    {
        int n = matrix.length;
        minSum(matrix, n, n - 2);
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++)
        {
            if(ans>matrix[0][i])
              ans=matrix[0][i];
        }
        return ans;
    }
}
/*
class Solution {

    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n=matrix[0].length;

        int dp[][] = new int[m][n];
        for(int j=0; j<n; j++){
            dp[0][j]=matrix[0][j];
        }

        for(int i=1; i<m; i++){
            for(int j=0; j<n; j++){
                int up =matrix[i][j]+dp[i-1][j];

                int leftDi = matrix[i][j];
                if(j-1>=0){
                    leftDi+=dp[i-1][j-1];
                }else{
                    leftDi += (int)Math.pow(10,9);
                }

                int rightDi = matrix[i][j];
                if(j+1<n){
                    rightDi+=dp[i-1][j+1];
                }else{
                    rightDi += (int)Math.pow(10,9);
                }
                dp[i][j]=Math.min(up,Math.min(rightDi,leftDi));
            }
        }
        int mini = Integer.MAX_VALUE;
        for(int j=0; j<n; j++){
            if(dp[m-1][j]<mini) mini = dp[m-1][j];

        }
        return mini;
    }

    /*
    //memoization
    int f(int i, int j, int[][] matrix,int m, int dp[][]){
        if(j<0 || j>=m) return (int) Math.pow(10,9);
        if(i==0) return matrix[0][j];
        if(dp[i][j]!=-1) return dp[i][j];

        int up = matrix[i][j]+f(i-1,j,matrix,m,dp);
        int left = matrix[i][j]+f(i-1,j-1,matrix,m,dp);
        int right = matrix[i][j]+f(i-1,j+1,matrix,m,dp);

        return dp[i][j] = Math.min(up,Math.min(left,right));

    }
    */
//Brute force approach
    /*
    int f(int i, int j, int[][] matrix,int m){
        if(j<0 || j>=m) return (int) Math.pow(10,9);
        if(i==0) return matrix[0][j];

        int up = matrix[i][j]+f(i-1,j,matrix,m);
        int left = matrix[i][j]+f(i-1,j-1,matrix,m);
        int right = matrix[i][j]+f(i-1,j+1,matrix,m);

        return Math.min(up,Math.min(left,right));
    }
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int dp[][] = new int[m][n];
        int mini = (int) Math.pow(10,9);
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        for (int j = 0; j < m; j++) {
            int ans = f(m - 1, j,matrix,n,dp);
            mini = Math.min(mini, ans);
        }
        return mini;
    }

}
*/

/* 2ms runtime :
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        Integer[][] dp = new Integer[matrix.length][matrix[0].length];

        int min = Integer.MAX_VALUE;
        for(int i = 0;i < matrix[0].length;i++){
            int val = fun(matrix,dp,0,i);
            min = Math.min(min,val);
        }

        return min;
    }

    int fun(int[][] matrix, Integer [][] dp , int r, int c){
        if(r == matrix.length-1){
            return matrix[r][c];
        }

        if(dp[r][c] != null) return dp[r][c];

        int[] dcol = {-1,0,1};

        int min = Integer.MAX_VALUE;
        for(int i = 0;i<3;i++){
            int col = c + dcol[i];

            if(col < 0 || col >= matrix[0].length){
                continue;
            }

            int val = fun(matrix,dp,r+1,col);
            min = Math.min(min,val);
        }

        return dp[r][c] = matrix[r][c] + min;
    }
}
 */
