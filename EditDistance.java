public class EditDistance {
    public int minDistance(String word1, String word2) {
        int rowLen = word1.length(), columnLen = word2.length();

        int[][] dp = new int[rowLen+1][columnLen+1];
        char[] rows = word1.toCharArray();
        char[] columns = word2.toCharArray();

        for (int i = columnLen, temp=0; i>=0; i--)
            dp[rowLen][temp++] = i;

        for (int i=rowLen, temp=0; i>=0; i--)
            dp[temp++][columnLen] = i;

        for (int i=rowLen-1; i>=0; i--)    {
            for (int j=columnLen-1; j>=0; j--) {
                if (rows[i] == columns[j])
                    dp[i][j] = dp[i+1][j+1];
                else {
                    int min = Math.min(dp[i+1][j], dp[i][j+1]);
                    dp[i][j] = 1 + Math.min(min, dp[i+1][j+1]);
                }
            }
        }
        return dp[0][0];
    }
}

/* Best runtime : 2ms :
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m][n];

        for (int[] arr: dp) {
            Arrays.fill(arr, -1);
        }
        return helper(word1, word2, m - 1, n - 1, dp);
    }

    public int helper(String word1, String word2, int i, int j, int[][] dp) {
        if (i < 0) return j + 1;
        if (j < 0) return i + 1;

        if (dp[i][j] != -1) return dp[i][j];
        if (word1.charAt(i) == word2.charAt(j)) return dp[i][j] = helper(word1, word2, i - 1, j - 1, dp);

        return dp[i][j] = 1 + Math.min(helper(word1, word2, i - 1, j, dp), Math.min(helper(word1, word2, i, j - 1, dp), helper(word1, word2, i - 1, j - 1, dp)));
    }
}



##########################
3ms runtime :

class Solution {
    int[][] dp;
    public int solve(String word1,String word2,int i,int j)
    {
        if(j==word2.length())
        {
            return word1.length()-i;
        }
        else if(i==word1.length())
        {
            return word2.length()-j;
        }
        else if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        else if(word1.charAt(i)==word2.charAt(j))
        {
            int k = solve(word1,word2,i+1,j+1);
            dp[i][j] = k;
            return dp[i][j];
        }
        else
        {
            int k = Math.min(1+solve(word1,word2,i+1,j+1),Math.min(1+solve(word1,word2,i+1,j),1+solve(word1,word2,i,j+1)));
            dp[i][j] = k;
            return dp[i][j];
        }
    }
    public int minDistance(String word1, String word2) {
        if(word1.length()<word2.length())
        {
            String temp=word1;
            word1 = word2;
            word2 = temp;
        }
        dp = new int[word1.length()][word2.length()];
        for(int[] ar:dp)
        {
            Arrays.fill(ar,-1);
        }
        return solve(word1,word2,0,0);
    }
}

/**

IDEA:

Take word1 to be greater or equal length to word2
So we wont insert anything, only delete or replace from word1

Then Apply recursion to see which operation is best suited
*/