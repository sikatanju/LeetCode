public class TrappingRainWater {
    public int trap(int[] height) {
        if (height.length <= 1)
            return 0;

        int totalWater = 0, left = 0, right = height.length-1;
        int maxLeft = height[left], maxRight = height[right];
        while (left < right)    {
            if (maxLeft <= maxRight)    {
                left++;
                maxLeft = Math.max(maxLeft, height[left]);
                totalWater += maxLeft - height[left];
            }
            else    {
                right--;
                maxRight = Math.max(maxRight, height[right]);
                totalWater += maxRight - height[right];
            }
        }
        return totalWater;
    }
}


/*
    public int trap(int[] height) {
        if (height.length == 1)
            return 0;

        int totalWater = 0, len = height.length;
        int i=0;
        while (height[i] == 0)
            i++;

        int left = i, right = i+1;
        while (left <= right && right < len)    {
            if (right == len-1)
                break;

            while (right < len  && height[right] < height[left])
                right++;

            if (right == len && left == right-1)
                break;

            else if (right == len && right - left >= 3) {
                right--;
                if (height[right] < height[left] && right - left != 1)  {
                    int index = right;
                    while (index > left)
                        totalWater += (height[right] - height[index--]);

                    left = right++;
                }
            }
            else if (right == len && left != right-1)  {
                left = left+1;
                right = left+1;
                continue;
            }



            if (right - left == 1)  {
                left = right;
                continue;
            }
            else    {
                if (height[right] >= height[left])   {
                    int index = left+1;
                    while (index < right)
                        totalWater += (height[left] - height[index++]);

                    left = right++;
                }
                else    {
                    int index = right -1;
                    while (index > left)
                        totalWater += (height[right] - height[index--]);

                    left = right++;
                }
            }
        }
        if (totalWater <= 0)
            return 0;

        return totalWater;
    }
 */