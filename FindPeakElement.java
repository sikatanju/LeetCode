public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        if (len == 1)
            return 0;
        if (len == 2)
            return nums[1] > nums[0] ? 1 : 0;

        int low = 0, high = len-1;
        if (high >= 2)  {
            if (nums[low] > nums[low+1])
                return low;
            if (nums[high] > nums[high-1])
                return high;
        }

        while (low <= high) {
            int mid = (low+high)/2;
            if (mid-1 >= 0 && mid+1 < nums.length && nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1])
                return mid;

            if (nums[mid-1] > nums[mid])
                low = mid-1;
            if (nums[mid+1] > nums[mid])
                low = mid+1;
            else
                high = mid;
        }
        return -1;
    }
}
