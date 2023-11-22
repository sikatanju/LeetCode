import java.util.ArrayDeque;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE, currentLen = 0, currentSum = 0, araLen = nums.length;
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        for (int i=0; i<araLen; i++)   {
            int num = nums[i];
            if (num >= target)
                minLen = 1;

            arrayDeque.addLast(num);
            currentSum += num;

            if (currentSum >= target)   {
                while (true)    {
                    if ((currentSum-arrayDeque.peekFirst()) < target)
                        break;
                    currentSum -= arrayDeque.removeFirst();
                }
                minLen = Math.min(arrayDeque.size(), minLen);
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}



/*

    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE, currentLen = 0, currentSum = 0, araLen = nums.length;

        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        for (int i=0; i<araLen; i++)   {
            int num = nums[i];
            if (num >= target)
                minLen = 1;

            if (i+1 < araLen && (num+nums[i+1] >= target))
                minLen = Math.min(minLen, 2);

            if (i-1 > -1 && i+1 < araLen && (num+nums[i-1]+nums[i+1]) >= target)
                minLen = Math.min(3, minLen);

            currentSum += num;
            currentLen++;

            if (currentSum >= target)   {

                minLen = Math.min(minLen, currentLen);
                currentSum = num;
                currentLen = 1;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
 */