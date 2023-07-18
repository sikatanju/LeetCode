public class JumpGame {
    public boolean canJump(int[] nums)  {
        int boundary = 0, len = nums.length-1;
        for (int i=0; i<= boundary; i++)    {
            boundary = Math.max(i+nums[i], boundary);
            if (boundary >= len)
                return true;
        }
        return false;
    }
}


/*

        if (nums.length == 1)
            return true;
        if (nums[0] == 0)
            return false;

        int maxRange = 0, currentRange = 0;
        int lastIndex = 0, len = nums.length;

        for (int i=0; i<len; i++)   {
            if (nums[i] > 1)    {
                maxRange = nums[i];
                int temp = i + maxRange;
                while (true)    {
                    if (temp >= len)
                        return true;
                    else    {
                        if (temp + nums[temp] == temp)
                            break;
                        else
                            temp += nums[temp];
                    }
                }
                maxRange--;
            }
        }
        return false;
    }


 */