import java.util.Arrays;

public class WeeklyContest_388 {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long maximumHappiness = 0;
        int turn = 0;

        for (int i=happiness.length-1; i>=0; i--)   {
            if (happiness[i]-turn <= 0 || k<=0)
                break;

            maximumHappiness += Math.max((happiness[i] - turn), 0);
            turn++;
            k--;
        }
        return maximumHappiness;
    }
}


/*
public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int totalApple = 0, minBox = 0;

        for (var temp: apple)
            totalApple += temp;

        for (int i=capacity.length-1; i>=0; i--)    {
            totalApple -= capacity[i];
            minBox++;
            if (totalApple <= 0)
                return minBox;
        }
        return minBox;
    }
 */


/* *** Hard problem : Maximum Strength of K Disjoint Subarrays

	class Solution {
		public long maximumStrength(int[] a, int k) {
			int n = a.length;
			long[] dp = new long[n+1];
			for(int z = 0;z < k;z++){
				long v = k-z;
				if(z % 2 == 1)v = -v;
				long[] ndp = new long[n+1];
				Arrays.fill(ndp, Long.MIN_VALUE / 3);
				for(int i = 1;i <= n;i++){
					ndp[i] = Math.max(ndp[i], Math.max(ndp[i-1], dp[i-1]) + a[i-1] * v);
				}
				dp = ndp;

				for(int i = 1;i <= n;i++){
					dp[i] = Math.max(dp[i], dp[i-1]);
				}
			}
			return dp[n];
		}
	}
 */