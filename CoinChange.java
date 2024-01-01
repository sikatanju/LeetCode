import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for (int i=1; i<amount+1; i++)  {
            for (int j: coins)  {
                if (i-j >= 0)
                    dp[i] = Math.min(dp[i], 1 + dp[i-j]);
            }
        }
        return dp[amount] != amount+1 ? dp[amount] : -1;
    }
}


/*  ######### 5ms runtime :

class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        boolean allMultiply = true;

        for (int i = 1; i < coins.length; ++i) {

            if (coins[i] % coins[0] != 0) {
                allMultiply = false;
                break;
            }
        }

        if (allMultiply && (amount % coins[0]) != 0) {
            return -1;
        }

        int minCount = Integer.MAX_VALUE;
        int[] counts = new int[coins.length];
        int i = coins.length - 1;
        int count = amount / coins[i];
        int amount1 = amount - count * coins[i];

        if (amount1 == 0) {
            return count;
        }

        if (coins[0] * (count + 1) == amount) {
            return count + 1;
        }

        if (count == amount / coins[0]) {
            return -1;
        }

        counts[i] = count;
        amount = amount1;

        while (true) {
            if (count >= minCount || i <= 0) {
                count -= counts[i];
                amount += counts[i] * coins[i];

                do {
                    ++i;

                    if (i >= coins.length) {
                        return minCount < Integer.MAX_VALUE ? minCount : -1;
                    }

                } while (counts[i] == 0);
                --counts[i];
                --count;
                amount += coins[i];
            }

            --i;
            counts[i] = 0;

            while (amount >= coins[i]) {
                amount -= coins[i];
                ++counts[i];
            }

            count += counts[i];

            if (amount == 0 && count < minCount) {
                minCount = count;
            }
        }
    }
}
 */