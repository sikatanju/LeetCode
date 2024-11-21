import java.util.Arrays;
import java.util.PriorityQueue;

public class WeeklyContest424 {

    public boolean isZeroArray(int[] nums, int[][] queries) {
        PriorityQueue<int[]> maxHeapFirst = new PriorityQueue<>((o,p) -> p[0] - o[0]);
        PriorityQueue<int[]> maxHeapLast = new PriorityQueue<>((o,p) -> p[1] - o[1]);
        for (int[] query: queries)    {
            int start = query[0], end = query[1], tempStart = -1, tempEnd = -1;
            if (maxHeapFirst.size() > 0)    {
                int[] temp = maxHeapFirst.peek();
                tempStart = temp[0];
            }
            if (maxHeapLast.size() > 0) {
                int[] temp = maxHeapLast.peek();
                tempEnd = temp[1];
            }
            maxHeapFirst.offer(query);
            maxHeapLast.offer(query);
            if (tempStart <= start && tempEnd >= end)
                continue;
            else
                makeAllZero(nums,start, end);
        }


        for (int i=0; i<nums.length; i++)   {
            if (nums[i] > 0)
                return false;
        }
        return true;
    }
    private void makeAllZero(int[] nums, int start, int end)    {
        while (start <= end)    {
            nums[start]--;
            start++;
        }
    }
    public int countValidSelections(int[] nums) {
        int count = 0, zeroCount=0;
        for (int i=0; i<nums.length; i++)   {
            if (nums[i] == 0)   {
                int[] ara = Arrays.copyOf(nums, nums.length);
                int[] ara2 = Arrays.copyOf(nums, nums.length);
                if (isValidRight(ara, i, true))    {
                    count++;
                }
                if (isValidRight(ara2, i, false))
                    count++;
            }
        }

        return count;
    }
    private boolean isValidRight(int[] nums, int start, boolean isRight)  {
        int i=start, len = nums.length, possible = 0;
        boolean moveRight = isRight;
        while (i >= 0 && i < len)    {
            if (nums[i] == 0)   {
                if (moveRight)  {
                    while (i >= 0 && i < len && nums[i] == 0) {
                        i++;
                    }

                    moveRight = false;
                }   else {
                    while (i >= 0 && i < len && nums[i] == 0)
                        i--;

                    moveRight = true;
                }
            }
            else if (nums[i] > 0)    {
                nums[i]--;

                if (moveRight)  {
                    i++;
                    while (i >= 0 && i < len && nums[i] == 0)
                        i++;

                    moveRight = false;
                }   else {

                    i--;
                    while (i >= 0 && i < len && nums[i] == 0)
                        i--;

                    moveRight = true;
                }
            }
        }
        for (int num: nums) {
            if (num != 0)
                return false;
        }
        return true;
    }
}

class Solution {

}