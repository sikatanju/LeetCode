public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] ara) {
        int leastPrice = 10_000;
        int profitSoFar = 0, len = ara.length;
        for (int i=0; i<len; i++) {
            if (ara[i] < leastPrice)    {
                leastPrice = ara[i];
                continue;
            }
            var todayProfit = ara[i] - leastPrice;
            if (i+1 < len && ara[i+1] < ara[i])  {
                if (todayProfit > 0)   {
                    profitSoFar += todayProfit;
                }
                leastPrice = ara[i+1];
            }
            else    {
                if (i+1 < len && ara[i+1] > ara[i]) {
                    continue;
                }
                else
                    if (todayProfit > 0)    {
                        profitSoFar += todayProfit;
                        if (i+1 < len)
                            leastPrice = ara[i+1];
                    }
            }
        }
        return profitSoFar;
    }
}
