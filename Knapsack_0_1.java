public class Knapsack_0_1 {
    // Profit & Weight array's length should be same
    private int[] profit;
    private int[] weight;

    public int findMaximumProfit(int[] profit, int[] weight, int capacity)  {
        this.profit = profit;
        this.weight = weight;
        return dfs(0, capacity);
    }

    private int dfs (int i, int capacity) {
        if (i == profit.length)
            return 0;

        var maxProfit = dfs(i+1, capacity);

        var newCapacity = capacity - weight[i];
        if (newCapacity >= 0)    {
            var newProfit = profit[i] + dfs(i+1, newCapacity);
            maxProfit = Math.max(newProfit, maxProfit);
        }

        return maxProfit;
    }
}


/*
public class Knapsack_0_1 {
    // Profit & Weight array's length should be same
    private int[] profit;
    private int[] weight;

    public int findMaximumProfit(int[] profit, int[] weight, int capacity)  {
        this.profit = profit;
        this.weight = weight;
        return dfs(0, capacity);
    }

    private int dfs (int i, int capacity) {
        if (i == profit.length)
            return 0;

        var maxProfit = dfs(i+1, capacity);

        var newCapacity = capacity - weight[i];
        if (newCapacity >= 0)    {
            var newProfit = profit[i] + dfs(i+1, newCapacity);
            maxProfit = Math.max(newProfit, maxProfit);
        }

        return maxProfit;
    }
}
*/