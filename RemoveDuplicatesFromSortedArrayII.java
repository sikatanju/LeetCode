public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1)
            return 1;

        int resultCount = 1, i = 1, k;
        int current = nums[0], currentCount = 1;
        for (k=1; k<nums.length; k++) {
            if (nums[k] == current && currentCount < 2) {
                currentCount++;
                nums[i++] = nums[k];
                resultCount++;
            }
            else if (nums[k] != current){
                current = nums[k];
                currentCount = 1;
                nums[i++] = nums[k];
                resultCount++;
            }
        }
        return resultCount;
    }
}
