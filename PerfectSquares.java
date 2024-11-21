import java.util.Arrays;

public class PerfectSquares {
    public int numSquares(int n) {
        int[] ara = new int[n+1];
        Arrays.fill(ara, n);
        ara[0] = 0;
        for (int i=1; i<=n; i++)    {
            for (int j=1; j<=n; j++)  {
                int sqr = j*j;
                if (i-sqr < 0)
                    break;

                ara[i] = Math.min(ara[i], 1+ara[i-sqr]);
            }
        }
        return ara[n];
    }
}

/* Another approach : public class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int count = 1;
        while (count * count <= n) {
            int sq = count * count;
            for (int i = sq; i <= n; i++) {
                dp[i] = Math.min(dp[i - sq] + 1, dp[i]);
            }
            count++;
        }
        return dp[n];
    }
}
 */

/* Better runtime : 25ms with similar approach

class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2; i<=n; i++){
            int min = Integer.MAX_VALUE;
            for(int j=1; j*j<=i; j++){
                int rem = i - (j*j);
                if(dp[rem]<min){
                    min=dp[rem];
                }
            }
            dp[i]=min+1;
        }
        return dp[n];
    }
}

 */

/* -- Tried greedy approach, couldn't solve:


        double b = n;
        b = Math.sqrt(b);
        int num = (int)b;
        int sum = 0, leastNum = Integer.MAX_VALUE;
        for (int i=num; i>=1; i--)	{
            int count = 0, tempI = i;
            for (int j=i; j>=1; j--)    {
                if (sum > 0)    {
                    int temp = n - sum;
                    int jj = (int)Math.pow(j, 2);
                    if (temp % jj == 0) {
                        sum = n;
                        count += (int) (temp / jj);
                    }
                }
                while (true)	{
                    double temp = Math.pow(j, 2);
                    if (sum + temp > n)
                        break;

                    sum += (int)temp;
                    count++;
                }
                if (count > leastNum)
                    break;
            }
            leastNum = Math.min(leastNum, count);
            sum = 0;
        }
        return leastNum;

 */