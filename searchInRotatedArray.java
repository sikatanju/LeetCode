public class searchInRotatedArray {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        while (start <= end) {
            int middle = (start + end) / 2;

            if (nums[middle] == target)
                return middle;

            else if (nums[start] == target)
                return start;

            else if (nums[end] == target)
                return end;

            else if (target > nums[middle] && target < nums[end])
                start = middle + 1;

            else if (nums[start] > nums[middle] && target < nums[middle])
                end = middle - 1;

            else if (nums[start] < nums[middle] && target < nums[end] && target < nums[start])
                start = middle + 1;

            else if (nums[start] > nums[middle] && target > nums[middle])
                end = middle - 1;

            else if (target < nums[middle])
                end = middle-1;

            else
                start = middle + 1;
        }
        return -1;
    }
}