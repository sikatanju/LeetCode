// Problem 11. Container With Most Water.
// This problem is from leetCode. Tags : Array. Difficulty : Normal
// https://leetcode.com/problems/container-with-most-water/

public class containerWithMostWater {
    public static int maxArea(int[] height)    {
        int area = Integer.MIN_VALUE;
        int left = 0, right = height.length-1;
        
        while (left < right)    {
            int shorterVerticalLine = Math.min(height[left], height[right]);
            area = Math.max(area, shorterVerticalLine * (right-left));

            if (height[left] > height[right])
                right--;
            else
                left++;
        }

        return area;
    }

    public static void main(String[] args)  {
        int[] ara = {1,2,1};
        System.out.println(maxArea(ara));
    }
}


        /*for (int i=0; i<height.length; i++) {
            for (int j=i+1; j<height.length; j++)   {
                if (height[i] < height[j])  {
                    int temp = 1;
                    temp *= height[i] * Math.abs(i-j);
                    if (area < temp)
                        area = temp;
                }
                else    {
                    int temp = 1;
                    temp *= height[j] * Math.abs(i-j);
                    if (area < temp)
                        area = temp;
                }
            }
        }*/