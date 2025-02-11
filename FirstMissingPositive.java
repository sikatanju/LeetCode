public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int i=0, n = nums.length;
        while (i<n) {
            if (nums[i] <= 0 || nums[i] > n) {
                i++;
                continue;
            }
            int correctPosition = nums[i]-1;
            if (nums[correctPosition] != nums[i])   {
                int temp = nums[correctPosition];
                nums[correctPosition] = nums[i];
                nums[i] = temp;
            }   else {
                i++;
            }
        }
        for (int j=0; j<n; j++) {
            if (nums[j] != j + 1)
                return j+1;
        }
        return n+1;
    }
}
