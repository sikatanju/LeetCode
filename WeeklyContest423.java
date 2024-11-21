import java.util.List;

public class WeeklyContest423 {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int len = nums.size();
        if (len == 2)
            return 1;

        int[] check = new int[len];
        int maxCount = Integer.MIN_VALUE;
        int count = 0, num = Integer.MIN_VALUE;

        for (int i=0; i<len; i++)   {
            int temp = nums.get(i);
            if (temp > num) {
                num = temp;
                count++;
                check[i] = count;
            }   else {
                num = temp;
                count = 1;
                check[i] = count;
            }
        }
        for (int i=0; i<len; i++)   {
            int tempLen = check[i];
            if (i + tempLen < len)  {
                if (check[i] <= check[i+tempLen])
                    maxCount = Math.max(maxCount, Math.min(check[i], check[i+tempLen]));
            }
            if (i-tempLen >= 0) {
                if (check[i] <= check[i-tempLen])
                    maxCount = Math.max(maxCount, Math.min(check[i], check[i-tempLen]));
            }
        }
        return maxCount;
    }
//    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
//        int len = nums.size(), count = 0;
//        int num = Integer.MAX_VALUE;
//        boolean[] check = new boolean[len];
//        for (int i=len-1; i>=0; i--)    {
//            int temp = nums.get(i);
//            if (temp < num) {
//                num = temp;
//                count++;
//                if (count == k) {
//                    check[i] = true;
//                    count--;
//                }
//            }   else {
//                num = temp;
//                count = 1;
//                if (count == k)
//                    check[i] = true;
//            }
//        }
//        for (int i=0; i<len; i++)   {
//            if (check[i])   {
//                if (i+k < len && check[i+k])  {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
}


/*

    private int oneStartIndex;
    private int twoStartIndex;
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int one = 0, two = 0;
        int oneCount = 0, twoCount = 0;
        int len = nums.size();
        one = findIndex(len-1, nums, k, true);
        two = findIndex(one-1, nums, k, false);

        if (one != -1 && two != -1 && oneStartIndex-k ==  twoStartIndex)
            return true;

        return false;
    }
    private int findIndex(int start, List<Integer> nums, int k, boolean one)    {
        if (one == true)
            oneStartIndex = start;
        else
            twoStartIndex = start;

        if (start >= nums.size() || start < 0)
            return -1;

        int count = 1, num = nums.get(start);

        if (k == 1)
            return start;

        for (int i=start-1; i>=0; i--)   {
            int temp = nums.get(i);
            if (temp < num) {
                num = temp;
                count++;
                if (count == k && one) {
                    if (i - k == 0)
                        return i;

                    if (i-k > 0 && nums.get(i-1) < num)    {
                        oneStartIndex--;
                        count--;
                    }   else
                        return i;
                }
                else if (count == k)
                    return i;
            }   else {
                if (one == true)
                    oneStartIndex = i;
                else
                    twoStartIndex = i;

                count = 1;
                num = temp;
            }
        }
        return -1;
    }
 */