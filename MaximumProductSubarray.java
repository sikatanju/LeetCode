public class MaximumProductSubarray {
    public int maxProduct(int[] nums)   {
        int maxSoFar = nums[0];
        int currentMax = maxSoFar, currentMin = maxSoFar;
        for (int i=1; i<nums.length; i++)   {
            if (nums[i] < 0)    {
                var temp = currentMax;
                currentMax = currentMin;
                currentMin = temp;
            }

            currentMax = Math.max(nums[i], currentMax * nums[i]);
            currentMin = Math.min(nums[i], currentMin * nums[i]);
            maxSoFar = Math.max(maxSoFar, currentMax);
        }
        return maxSoFar;
    }
}



/*
        if (nums.length == 1)
            return nums[0];

        int maxSoFar = Integer.MIN_VALUE, product = 1, len = nums.length;
        for (int i=0; i<len; i++)   {
            product *= nums[i];
            if (product > maxSoFar)
                maxSoFar = product;

            if (i+2 < len && product < 0 && (nums[i+1] < 0 && nums[i+2] < 0))  {
                var temp = checkRest(nums, i+1);
                if (temp > (product * nums[i+1]))
                    product = temp;
                else
                    continue;
            }
            else if (i+1 < len && product < 0 && nums[i+1] < 0)
                continue;

            else if (i+1 < len && product < 0 && nums[i+1] > 0) {
                if (isThere(nums, i))
                    continue;
                else
                    product = 1;
            }
            if (product <= 0)
                product = 1;
        }
        return maxSoFar;
    }

    private boolean isThere (int[] ara, int index)  {
        while (++index < ara.length)  {
            if (ara[index] == 0)
                return false;
            if (ara[index] < 0)
                return true;
        }
        return false;
    }
    private int checkRest(int[] ara, int index) {
        int product = 1;
        while (++index < ara.length)
            product *= ara[index];

        return product;
    }
 */