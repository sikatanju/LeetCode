import java.util.TreeSet;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length, maxLen = Integer.MIN_VALUE;
        int[] lis = new int[len];

        for (int i=len-1; i>=0; i--)    {
            lis[i] = longestSequence(lis, nums, i, len);
            maxLen = Math.max(lis[i], maxLen);
        }

        return maxLen;
    }

    private int longestSequence(int[] lis, int[] nums, int index, int len)  {
        int maxLen = 1, tempIndex = index+1;
        while (tempIndex < len) {
            int temp = nums[index] < nums[tempIndex] ? 1+lis[tempIndex]: 1;
            maxLen = Math.max(maxLen, temp);
            tempIndex++;
        }
        return maxLen;
    }


    public int lengthOfLIS2(int[] nums) {
        if(nums.length == 0) return 0;
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(nums[0]);

        for(int i = 1; i < nums.length; i++) {
            if (nums[i] > treeSet.last()) {
                //treeSet.add(nums[i]);
            } else {
                int itemToBeReplaced = treeSet.ceiling(nums[i]);
                treeSet.remove(itemToBeReplaced);
            }
            treeSet.add(nums[i]);
        }
        return treeSet.size();
    }
}


/* ########## Runtime : 7ms
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> dp = new ArrayList<>();
        dp.add(nums[0]);

        for(int i=1; i<n; i++) {
            if(dp.get(dp.size()-1) < nums[i]) {
                dp.add(nums[i]);
            }
            else {
                int index =
                    Collections.binarySearch(dp, nums[i]);
                if(index < 0) {
                    index = Math.abs(index) - 1;
                    dp.set(index, nums[i]);
                }
            }
        }
        return dp.size();
    }
}
 */

/* ########## Runtime : 12ms
class Solution {
    public int lengthOfLIS2(int[] nums) {
        if(nums.length == 0) return 0;
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(nums[0]);

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > treeSet.last()) {
                //treeSet.add(nums[i]);
            } else {
                int itemToBeReplaced = treeSet.ceiling(nums[i]);
                treeSet.remove(itemToBeReplaced);
            }
            treeSet.add(nums[i]);
        }
        return treeSet.size();
    }
}
 */
