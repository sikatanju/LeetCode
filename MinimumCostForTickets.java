import java.util.Arrays;

public class MinimumCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int len = days.length;
        int[] dp = new int[len+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i=1; i<=len; i++)  {
            dp[i] = dp[i-1] + costs[0];

            int j = i-1;
            while (j >= 0 && (days[i-1] - days[j]) < 7)
                j--;
            dp[i] = Math.min(dp[i], dp[j+1] + costs[1]);

            j = i-1;
            while (j >= 0 && (days[i-1] - days[j]) < 30)
                j--;
            dp[i] = Math.min(dp[i], dp[j+1] + costs[2]);
        }
        return dp[len];
    }
}

/* Best runtime :
class Solution {
    int[] costs;
    int[] days;
    int n;
    int[] memo;
    public int mincostTickets(int[] days, int[] costs) {
        this.days = days;
        this.costs = costs;
        this.n = days.length;
        this.memo = new int[days[n - 1] + 1];

        Arrays.fill(memo, Integer.MAX_VALUE);
        return f(0);

    }
    // f = cost to get from d -> n (where d and n are both days in days[])
    // d = day I am currently at

    public int f(int i) {
        if (i == n) {
            return 0;
        }
        if (memo[i] != Integer.MAX_VALUE) {
            return memo[i];
        }
        int option1 = costs[0] + f(i + 1);
        int j = i;
        while (j < n && days[j] < days[i] + 7) {
            j++;
        }
        int option2 = costs[1] + f(j);
        int h = j;
        while (h < n && days[h] < days[i] + 30) {
            h++;
        }
        int option3 = costs[2] + f(h);
        memo[i] = Math.min(memo[i], Math.min(option1, Math.min(option2, option3)));
        return memo[i];
    }
}
 */

/* Another approach : C++
 int sub(vector<int> &day, vector<int> &cost, int si)		// si denotes starting index
    {
        int n = day.size();
        if(si>=n)   return 0;

        int cost_day = cost[0] + sub(day , cost , si+1);

        int i;
        for(i = si ; i<n and day[i]<day[si]+7 ; i++);   //skip till ith day is curr_day+7 as we are buying week pass
        int cost_week = cost[1] + sub(day, cost, i);

        for(i = si ; i<n and day[i]<day[si]+30 ; i++);   //skip till ith day is curr_day+30 as we are buying month pass
        int cost_month = cost[2] + sub(day, cost, i);

        return min({cost_day, cost_week , cost_month  });
    }

    int mincostTickets(vector<int>& days, vector<int>& costs) {
        return sub(days,costs,0);
    }
 */