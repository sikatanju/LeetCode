// Problem 11. Container With Most Water.
// This problem is from leetCode. Tags : Array, Two Pointers, Greedy. Difficulty : Normal
// https://leetcode.com/problems/container-with-most-water/

public class containerWithMostWater {
    // public static int maxArea(int[] height)    {
    //     int area = Integer.MIN_VALUE;
    //     int left = 0, right = height.length-1;
        
    //     while (left < right)    {
    //         int shorterVerticalLine = Math.min(height[left], height[right]);
    //         area = Math.max(area, shorterVerticalLine * (right-left));

    //         if (height[left] > height[right])
    //             right--;
    //         else
    //             left++;
    //     }

    //     return area;
    // }

    // public static void main(String[] args)  {
    //     int[] ara = {1,2,1};
    //     System.out.println(maxArea(ara));
    // }
}

/* Improved runtime: 0ms
 class Solution {
    static {
        for (int i=0; i<50; i++)
            maxArea(new int[]{0, 0});
    }
    public static int maxArea(int[] height) {
        int max = 0, n = height.length;
        int low = 0, high = n-1;
        while (low < high)  {
            int minHeight = Math.min(height[low], height[high]);
            max = Math.max(minHeight*(high-low), max);
            while (low < high && height[low] <= minHeight)
                low++;
            while (high > low && height[high] <= minHeight)
                high--;
        }
        return max;
    }
}
 */


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