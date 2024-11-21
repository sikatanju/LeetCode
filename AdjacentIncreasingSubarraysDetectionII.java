import java.util.List;

public class AdjacentIncreasingSubarraysDetectionII {
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
}
