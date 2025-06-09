import java.util.Arrays;
import java.util.PriorityQueue;

public class ChooseKElementsWithMaximumSum3478 {
    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] nums = new int[n][3];
        for (int i=0; i<n; i++) {
            nums[i][0] = i;
            nums[i][1] = nums1[i];
            nums[i][2] = nums2[i];
        }
        Arrays.sort(nums, (a, b) -> a[1]-b[1]);
        long[] res = new long[n];
        long sum = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for (int i=0; i<n; i++) {
            if (i>0 && nums[i-1][1] == nums[i][1])
                res[nums[i][0]] = res[nums[i-1][0]];
            else
                res[nums[i][0]] = sum;

            sum += nums[i][2];
            queue.add(nums[i][2]);
            if (queue.size() > k)
                sum -= queue.remove();
        }
        return res;
    }
}