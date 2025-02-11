import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WeeklyContest433 {
    private int totalSum;
    public int minMaxSums(int[] nums, int k) {
        totalSum = 0;
        int n = nums.length;
//        int[][][] dp = new int[n][n][2];
        for (int i=0; i<n; i++) {
//            totalSum += ((nums[i]*2) % (1000000000+7));
            int min = nums[i], max = nums[i];
            for (int j=i; j<i+k; j++)   {
                if (j >= n)
                    break;
                min = Math.min(nums[j], min);
                max = Math.max(nums[j], max);
                totalSum += ((min+max) % (1000000000+7));
            }
        }
        return totalSum;
    }
    private void getSum(int index, int[] nums, int k, List<Integer> tempList) {
        if (tempList.size() > k)
            return;
        if (index == nums.length)   {
            if (tempList.isEmpty())
                return;
            if (tempList.size() == 1)
                totalSum += (2*tempList.getFirst()) % 1000000007;
            else {
                int tempMin = Integer.MAX_VALUE;
                int tempMax = Integer.MIN_VALUE;
                for (int num: tempList) {
                    tempMin = Math.min(num, tempMin);
                    tempMax = Math.max(num, tempMax);
                }
                totalSum += (tempMin+tempMax);
                totalSum %= 1000000007;
            }
            return;
        }

        tempList.add(nums[index]);
        getSum(index+1, nums, k, tempList);
        tempList.removeLast();
        getSum(index+1, nums, k, tempList);
    }
}
