import java.util.*;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Arrays.sort(nums);
        int len = nums.length;

        for (int i=0; i<len; i++)   {
            for (int j=i+1; j<len; j++) {
                int low = j+1, high = len-1;
                while (low < high)  {
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[low];
                    sum += nums[high];
                    if (sum < target)
                        low++;
                    else if (sum > target)
                        high--;
                    else    {
                        String str = getStr(nums[i], nums[j], nums[low], nums[high]);
                        if (!set.contains(str)) {
                            res.add(List.of(nums[i], nums[j], nums[low], nums[high]));
                            set.add(str);
                        }
                        low++;
                        high--;
                        while (low < len && nums[low] == nums[low-1])
                            low++;
                        while (high > low && nums[high] == nums[high+1])
                            high--;
                    }
                }
            }
        }
        return res;
    }

    private String getStr(int i, int j, int k, int l)   {
        StringBuilder str = new StringBuilder();
        str.append(i);
        str.append(j);
        str.append(k);
        str.append(l);
        return str.toString();
    }
}

/* Second Best Runtime: 7ms:
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 4){
            return res;
        }
        long minSum = (long)nums[0] + nums[1] + nums[2] + nums[3];
        long maxSum = (long)nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] + nums[nums.length - 4];
        if (minSum > target || maxSum < target) {
            return res;
        }

        for (int i = 0; i < nums.length-3; i++){
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            for (int j = i+ 1; j < nums.length-2; j++){
                if (j > i + 1 && nums[j] == nums[j-1]){
                    continue;
                }
                int beg = j + 1;
                int end = nums.length- 1;
                while (beg < end){
                    int sum = nums[i] + nums[j] + nums[beg] + nums[end];
                    if (sum == target){
                        res.add(Arrays.asList(nums[i], nums[j], nums[beg], nums[end]));

                        while (beg < end && nums[beg] == nums[beg + 1])beg++;
                        while (beg < end && nums[end] == nums[end -  1])end--;

                        beg++;
                        end--;
                    }   else if (sum < target){
                        beg++;
                    }   else {
                        end--;
                    }
                }
            }
        }
        return res;
    }
}
 */