public class WeeklyContest422 {
    public boolean isBalanced(String num) {
        int even = 0, odd = 0;
        char[] nums = num.toCharArray();
        for (int i = 0; i < nums.length; i++) {
            String str = "";
            str += nums[i];
            int numm = Integer.parseInt(str);
            if (i % 2 == 0)
                even += numm;
            else
                odd += numm;
        }
        return odd == even;
    }

    private int minTime;

    public int minTimeToReach(int[][] moveTime) {
        int rLen = moveTime.length, cLen = moveTime[0].length;
        int[][] dp = new int[rLen][cLen];
        minTime = 0;
        moveTime[0][0] = 0;
        dfs(0, 0, 0, moveTime);
        return minTime;
//        for (int i = 1; i < rLen; i++) {
//            int up = dp[i - 1][0];
//            if (moveTime[i][0] > up)
//                dp[i][0] = moveTime[i][0] + 1;
//            else
//                dp[i][0] = up + 1;
//        }
//        for (int i = 1; i < cLen; i++) {
//            int left = dp[0][i - 1];
//            if (moveTime[0][i] > left)
//                dp[0][i] = moveTime[0][i] + 1;
//            else
//                dp[0][i] = left + 1;
//        }
//        for (int i = 1; i < rLen; i++) {
//            for (int j = 1; j < cLen; j++) {
//                int up = dp[i - 1][j];
//                int left = dp[i][j - 1];
//                int min = Math.min(up, left);
//                if (moveTime[i][j] > min)
//                    dp[i][j] = moveTime[i][j] + 1;
//                else
//                    dp[i][j] = min + 1;
//            }
//        }
//        return dp[rLen - 1][cLen - 1];
    }

    private void dfs(int i, int j, int prev, int[][] moveTime) {
        if (i < 0 || i >= moveTime.length || j < 0 || j >= moveTime[0].length)
            return;

        if (i == moveTime.length - 1 && j == moveTime[0].length - 1) {
            minTime = Math.min(minTime, Math.max(moveTime[i][j] + 1, prev+1));
        }
        int max = 0;
        if (i == 0 && j == 0)   {
            max = 0;
        }
        else
            prev = Math.max(prev+1, moveTime[i][j]+1);
        
        dfs(i + 1, j, prev, moveTime);
        dfs(i, j+1, prev, moveTime);
        dfs(i - 1, j, prev, moveTime);
    }
}
