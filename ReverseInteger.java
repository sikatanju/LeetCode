public class ReverseInteger {
    public int reverse(int x) {
        if (Integer.MAX_VALUE == x || Integer.MIN_VALUE == x)
            return 0;

        int upperBound = Integer.MAX_VALUE/10;
        int lowerBound = Integer.MIN_VALUE/10;
        int temp = x, digitCount = 0, totalDigit;
        boolean isNegative = false;
        if (temp < 0)   {
            temp = -temp;
            isNegative = true;
        }
        while (temp > 0)    {
            digitCount++;
            temp /= 10;
        }
        totalDigit = digitCount;
        temp = 0;
        while (digitCount > 1)  {
            temp += x % 10;
            if (totalDigit == 10 && digitCount != 2)
                temp *= 10;
            else if (totalDigit < 10)
                temp *= 10;

            x /= 10;
            digitCount--;
        }
        if (temp >= upperBound) {
            if (temp > upperBound || (temp == upperBound && x > 7))
                return 0;
            else
                temp *= 10;
        }
        else if (temp <= lowerBound)    {
            if (temp < lowerBound || (temp == lowerBound && x < -8))
                return 0;
            else
                temp *= 10;
        }
        else    {
            if (totalDigit == 10)
                temp *= 10;
        }
        temp += x%10;
        return temp;
    }
}


/*  0ms runtime :
class Solution {
    public int reverse(int x) {
        int ans=0;
        while(x!=0){
            int ld=x%10;
            if(ans>Integer.MAX_VALUE/10 || ans<Integer.MIN_VALUE/10){
                return 0;
            }
            ans=ans*10+ld;
            x/=10;
        }
        return ans;
    }
}
 */