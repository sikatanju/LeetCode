public class JumpGameII {
    public int jump(int[] nums) {
        int minJumps = 0;
        int currJumpMax = 0, lastJumpMax = 0;
        for (int i=0; i<nums.length-1; i++) {
            currJumpMax = Math.max(currJumpMax, i+nums[i]);
            if (i == lastJumpMax)   {
                minJumps++;
                lastJumpMax = currJumpMax;
            }
        }
        return minJumps;
    }
}


/*
    ************ Lowest Memory Comsumtion ***************
    public int jump(int[] nums) {
        // Precompute the maximum reachable index from each position
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i] + i, nums[i - 1]);
        }
        // System.out.println(Arrays.toString(nums));
        // Jump greedily from index to index until reaching the end
        int currentIdx = 0;
        int numJumps = 0;
        while (currentIdx < nums.length - 1) {
            numJumps++;
            currentIdx = nums[currentIdx];
        }

        // Return the minimum number of jumps to reach the end
        System.gc();
        return numJumps;
    }

//        int step_count = 0;
//        int last_jump_max = 0;
//        int current_jump_max = 0;
//        for(int i=0; i<A.length-1; i++) {
//            current_jump_max = Math.max(current_jump_max, i+A[i]);
//            if( i == last_jump_max ) {
//                step_count++;
//                last_jump_max = current_jump_max;
//            }
//        }
//        return step_count;


    public int jump(int[] nums) {
        if (nums.length==1)
            return 0;
        if (nums.length == 2)
            return 1;

        int minJumps = Integer.MAX_VALUE, len = nums.length-1;
        int jumpCount = 1, jumpCheck = 0;
        int i=0;

        while (i < len)    {
            jumpCheck++;
            if (nums[i] == 0 && nums[i-1] == 2)
                jumpCheck--;

            int index = nums[i];
            while (index > 0)   {
                jumpCount = jumpCheck;
                int temp = index;
                while (temp < len)    {
                    if (temp == (temp+nums[temp]))
                        break;
                    else
                        temp += nums[temp];

                    jumpCount++;
                }
                if (temp >= len && jumpCount < minJumps)   {
                    minJumps = jumpCount;
                }
                index--;
            }
            i++;
        }
        return minJumps;
    }
 */
