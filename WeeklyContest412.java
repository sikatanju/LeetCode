import java.util.ArrayList;
import java.util.Arrays;

public class WeeklyContest412 {
    public int countPairs(int[] nums) {
        int len = nums.length, count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (isSameNumber(nums[i], nums[j])) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isSameNumber(int num1, int num2) {
        char[] chars1 = Integer.toString(num1).toCharArray();
        char[] chars2 = Integer.toString(num2).toCharArray();

        char[] str1 = Integer.toString(num1).toCharArray();
        char[] str2 = Integer.toString(num2).toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);

        int len1 = str1.length, len2 = str2.length;
        int diff1 = 0, diff2 = 0;
        int zeroCount1 = 0, zeroCount2 = 0;

        if (len1 == len2)   {
            for (int i=0; i<len1; i++)  {
                if (str1[i] != str2[i])
                    diff1++;
                if (chars1[i] != chars2[i])
                    diff2++;
            }
            if (diff1 > 0 || diff2 > 2)
                return false;
            return true;
        }
        else {
            if (len1 > len2)    {
                if (len1 - len2 > 1)
                    return false;
            }   else {
                if (len2 - len1 > 1)
                    return false;
            }
            int i = 0, j=0;
            while (i < len1 && j < len2)    {
                if (str1[i] == '0')
                    zeroCount1++;
                if (str2[i] == '0')
                    zeroCount2++;

                if (str1[i] != str2[j])
                    diff1++;
                if (chars1[i] != chars2[j])
                    diff2++;

                i++;
                j++;
            }
            return true;
        }
    }
}
/*
class Solution {
    boolean ok(int a, int b)
    {
        if(a == b)return true;
        String A = "" + a;
        String B = "" + b;
        int m = Math.max(A.length(), B.length());
        while(A.length() < m)A = "0" + A;
        while(B.length() < m)B = "0" + B;

        char[] s = A.toCharArray();
        char[] t = B.toCharArray();
        for(int i = 0;i < s.length;i++){
            for(int j = i+1;j < s.length;j++){
                {char d = s[i]; s[i] = s[j]; s[j] = d;}
                if(Arrays.equals(s, t))return true;
                {char d = s[i]; s[i] = s[j]; s[j] = d;}
            }
        }
        return false;
    }

    public int countPairs(int[] nums) {
        int n = nums.length;
        int ct = 0;
        for(int i = 0;i < n;i++){
            for(int j = i+1;j < n;j++){
                if(ok(nums[i], nums[j])){
                    ct++;
                }
            }
        }
        return ct;
    }
}
*/

/*

    public int[] getFinalState(int[] nums, int k, int multiplier) {

        for (int i=0; i<k; i++) {
            int minIndex = findMinIndex(nums);
            int temp = nums[minIndex];
            temp *= multiplier;
            nums[minIndex] = temp;
        }
        return nums;
    }
    private int findMinIndex(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int minValue = Integer.MAX_VALUE;
        for (int i=0; i<arr.length; i++) {
            int temp = arr[i];
            minValue = Math.min(minValue, temp);
            if (!map.containsKey(temp))
                map.put(temp, i);
        }
        return map.get(minValue);
    }
 */
