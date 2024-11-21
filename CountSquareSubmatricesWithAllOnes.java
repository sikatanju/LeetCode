import java.util.HashMap;
import java.util.Map;

public class CountSquareSubmatricesWithAllOnes {
    public int countSquares(int[][] matrix) {
        int count = 0;
        int rowLen = matrix.length, columnLen = matrix[0].length;
        if (rowLen == 1 && columnLen == 1)
            return matrix[0][0] == 1 ? 1: 0;

        int[][] dp = new int[rowLen][columnLen];

        for (int i=0; i<rowLen; i++)    {
            dp[i][columnLen-1] = matrix[i][columnLen-1];
            if (dp[i][columnLen-1] == 1)
                count++;
        }


        for (int i=0; i<columnLen-1; i++) {
            dp[rowLen-1][i] = matrix[rowLen-1][i];
            if (dp[rowLen-1][i] == 1)
                count++;
        }


        for (int i=rowLen-2; i>=0; i--) {
            for (int j=columnLen-2; j>=0; j--)  {
                int currentValue = matrix[i][j];
                if (currentValue == 0)
                    continue;

                int temp = Math.min(dp[i+1][j], Math.min(dp[i][j+1], dp[i+1][j+1]));
                temp++;
                dp[i][j] = temp;
                count += dp[i][j];
            }
        }
        return count;
    }
}
