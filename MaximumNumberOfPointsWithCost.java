public class MaximumNumberOfPointsWithCost {
    public long maxPoints(int[][] points) {
        int rowLen = points.length, columnLen = points[0].length;
        if (rowLen == 1 || columnLen == 1)	{
            int maxPoint = Integer.MIN_VALUE;
            for (int i=0; i<rowLen; i++)	{
                for (int j=0; j<columnLen; j++)	{
                    maxPoint = Math.max(maxPoint, points[i][j]);
                }
            }
        }

        long[][] dp = new long[rowLen][columnLen];
        for (var j=0; j<columnLen; j++)	{
            dp[0][j] = points[0][j];
        }

        for (var i=1; i<rowLen; i++)	{
            for (var j=0; j<columnLen; j++)	{
                long maxCurrentPoint = points[i][j];
                var prevRow = i-1;

                for (var k=0; k<columnLen; k++)	{
                    var temp = dp[prevRow][k];
                    var sub = k - j;

                    if (sub < 0)
                        temp += sub;
                    else
                        temp -= sub;

                    var tempCurrentPoint = temp + points[i][j];
                    maxCurrentPoint = Math.max(maxCurrentPoint, tempCurrentPoint);
                }

                dp[i][j] = maxCurrentPoint;
            }
        }

        long maxPoint = Integer.MIN_VALUE;
        for (int i=0; i<columnLen; i++)
            maxPoint = Math.max(dp[rowLen-1][i], maxPoint);

        return maxPoint;
    }
}
