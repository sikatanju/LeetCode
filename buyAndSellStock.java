public class buyAndSellStock {
    public int maxProfit(int[] ara)  {
        int leastNum = 10_000;
        int maxProfit = 0;
        
        for (int i=0; i<ara.length; i++)    {
            if (ara[i] < leastNum)  {
                leastNum = ara[i];
                continue;
            }
            var today = ara[i] - leastNum;
            if (maxProfit < today)
                maxProfit = today;
        }
        return maxProfit;
    }
    public static void main(String[] args)  {
        int[] ara = {2,4,1};

        buyAndSellStock obj = new buyAndSellStock();
        System.out.println (obj.maxProfit(ara));
    }
}
