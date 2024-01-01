public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int count = 0, len = 32;
        while (len-- > 0)   {
            if ((n & 1) == 1)
                count++;

            n >>= 1;
        }
        return count;
    }
}
