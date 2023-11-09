import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums)
            queue.add(num);

        for (int i=1; i<k; i++)
            queue.remove();

        return queue.remove();
    }
}

//  2 ms runtime :

/*
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Arrays.sort(nums);
        // return nums[nums.length-k];

        // nums = [3,2,1,5,6,4]
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int n : nums) {
            if (n > max) max = n;
            if (n < min) min = n;
        }

        int range = max - min;
        // min = 1
        // max = 6


        int[] numCounts = new int[range + 1]; // numCounts = [0,0,0,0,0,0]

        for (int n : nums) {
            numCounts[n - min] += 1;
        }

        // numCounts = [1,1,1,1,1,1]

        for (int i = numCounts.length - 1; i >= 0; i--) {
            k = k - numCounts[i];
            if (k <= 0) return i + min;
        }

        return -1;
    }
}
 */