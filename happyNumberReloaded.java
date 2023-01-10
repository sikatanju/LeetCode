public class happyNumberReloaded {
    public boolean isHappy(int n)   {
        if (n<1)
            return false;

        while (n>=10)   {
            int result = 0;
            while (n > 0)   {
                result += Math.pow((n%10), 2);
                n /= 10;
            }
            n = result;
        }
        return (n==1 || n==7);
    }
}
