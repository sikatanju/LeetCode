public class SolvingQuestionsWithBrainpower {
    public long mostPoints(int[][] questions) {
        int len = questions.length;
        long[] dp = new long[len+1];

        for (int i=len-1; i>=0; i--)    {
            long points = questions[i][0];
            int nextPos = questions[i][1];
            nextPos = Math.min(nextPos+i+1, len);
            dp[i] = Math.max(points + dp[nextPos], dp[i+1]);
        }
        return dp[0];
    }
}
