import java.util.Arrays;
public class threeSumCloset {
    public int threesumCloset(int[] nums, int target)   {
        if (nums.length == 3)
            return nums[0]+nums[1]+nums[2];

        Arrays.sort(nums);
        int closest = nums[0]+nums[1]+nums[2], len = nums.length;

        for (int i=0; i<len; i++)   {
            int j = i+1;
            int k = len-1;
            while (j < k)   {
                if (i==j || i==k)
                    break;

                var temp = nums[i] + nums[j] + nums[k];
                if (temp == target)
                    return temp;

                if (Math.abs(temp-target) < Math.abs(closest-target))
                    closest = temp;

                if (temp < target)
                    j++;
                else
                    k--;
            }
        }
        return closest;
    }
}
