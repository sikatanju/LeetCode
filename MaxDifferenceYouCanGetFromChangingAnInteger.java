public class MaxDifferenceYouCanGetFromChangingAnInteger {

/*
    private int[] getArr(int num)   {
        int cnt = 0, temp = num;
        while (temp > 0)    {
            cnt++;
            temp /= 10;
        }
        int[] arr = new int[cnt];
        while (num > 0) {
            arr[cnt-1] = num % 10;
            num /= 10;
            cnt--;
        }
        return arr;
    }
    public int maxDiff(int num) {
        int[] arr = getArr(num);
        int n = arr.length;
        if (n == 1)
            return 8;

        int[] max = arr.clone(), min = arr.clone();
        int firstDigit = -1, secondDigit = -1, idx = 0;
        while (true)    {
            if (arr[idx] != 9)  {
                firstDigit = arr[idx];
                break;
            }
            idx++;
        }
        idx = 0;
        for (int i=0; i<n; i++) {
            if (max[i] == firstDigit)
                max[i] = 9;
        }
        if (arr[0] == 1)   {
            while (idx < n && (arr[idx] == 1 || arr[idx] == 0))
                idx++;

            if (idx < n)    {
                secondDigit = arr[idx];
                for (int i=0; i<n; i++) {
                    if (min[i] == secondDigit)
                        min[i] = 0;
                }
            }
        }   else    {
            secondDigit = arr[0];
            for (int i=0; i<n; i++)
                if (min[i] == secondDigit)
                    min[i] = 1;
        }
        int maxNum = 0, minNum = 0;
        for (int i=0; i<n; i++) {
            maxNum *= 10;
            maxNum += max[i];
            minNum *= 10;
            minNum += min[i];
        }
        return maxNum-minNum;
    }
 */
}

/* More elegant Solution:
class Solution {
    private int difference(int num) {
        int firstNonNine = -1, firstNonOne = -1, firstDigit = -1;
        int remaining = num;
        while (remaining > 0) {
            int digit = remaining % 10;
            if (digit != 9) {
                firstNonNine = digit;
            }
            if (digit > 1) {
                firstNonOne = digit;
            }
            firstDigit = digit;
            remaining /= 10;
        }

        remaining = num;
        int min = 0, max = 0;
        int multiplier = 1;
        while (remaining > 0) {
            int digit = remaining % 10;

            int minDigit = digit;
            int maxDigit = digit;

            if (firstDigit == 1 && digit == firstNonOne) {
                minDigit = 0;
            }

            if (firstDigit != 1 && digit == firstDigit) {
                minDigit = 1;
            }

            if (digit == firstNonNine) {
                maxDigit = 9;
            }

            min += multiplier * minDigit;
            max += multiplier * maxDigit;

            multiplier *= 10;
            remaining /= 10;
        }

        return max - min;
    }

    public int maxDiff(int num) {
        return difference(num);
    }
}
 */

