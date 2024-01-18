public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);

        int one = robHouses(nums, 0, nums.length-2);
        int two = robHouses(nums, 1, nums.length-1);
        return Math.max(one, two);
    }
    private int robHouses(int[] ara, int start, int end)    {
        int robbed = 0, notRobbed = 0;
        for (int i=start; i<=end; i++)  {
            var tempRobbed = notRobbed  + ara[i];
            notRobbed = Math.max(robbed, notRobbed);
            robbed = tempRobbed;
        }
        return Math.max(robbed, notRobbed);
    }
}
