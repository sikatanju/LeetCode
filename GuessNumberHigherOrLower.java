public class GuessNumberHigherOrLower {
    private int pick;
    public GuessNumberHigherOrLower(int pick)   {
        this.pick = pick;
    }
    private int guess(int n)    {
        if (n > this.pick)
            return -1;
        if (n < this.pick)
            return 1;

        return 0;
    }
    public int guessNumber(int n) {
        long low = 1, high = n;
        while (low <= high) {
            long longMid = (low+high)/2;
            int mid = (int) longMid;
            int res = guess(mid);
            if (res == -1)  {
                high = mid-1;
            }
            else if (res == 1)  {
                low = mid+1;
            }
            else
                return mid;
        }
        return (int)low;
    }
}
