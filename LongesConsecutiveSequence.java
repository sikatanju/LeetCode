import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongesConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;

        int len = nums.length;
        int max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int num: nums)
            set.add(num);

        for (int num: nums) {
            if (!set.contains(num))
                continue;

            var temp = num;
            int count = 1;
            while (set.contains(--temp)) {
                count++;
                set.remove(temp);
            }

            temp = num;
            while (set.contains(++temp))    {
                count++;
                set.remove(temp);
            }
            set.remove(num);
            max = Math.max(max, count);
        }
        return max;
    }
}


/* Best runtime : 8ms
class Solution {
    public int longestConsecutive(int[] nums) {int result = 0;
        if (nums.length > 0) {
            if (nums.length < 1000) {
                Arrays.sort(nums);
                int current = 0;
                for (int i = 1; i < nums.length; i++) {
                    if (nums[i] != nums[i - 1]) {
                        if (nums[i] - nums[i - 1] == 1) {
                            current++;
                        } else {
                            if (current + 1 > result) {
                                result = current + 1;
                            }
                            current = 0;
                        }
                    }
                }
                if (current + 1 > result) {
                    result = current + 1;
                }
            } else {
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                for (int num : nums) {
                    if (num > max) {
                        max = num;
                    }
                    if (num < min) {
                        min = num;
                    }
                }
                byte[] bits = new byte[max - min + 1];
                for (int num : nums) {
                    bits[num - min] = 1;
                }
                int current = 0;
                for (byte bit : bits) {
                    if (bit > 0) {
                        current++;
                    } else {
                        if (current > result) {
                            result = current;
                        }
                        current = 0;
                    }
                }
                if (current > result) {
                    result = current;
                }
            }
        }
        return result;
    }
}
 */