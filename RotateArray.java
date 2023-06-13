public class RotateArray {
    public void rotate(int[] nums, int k) {
        if (k==0 || nums.length == 1)
            return;
        if (k>nums.length)
            k = k % nums.length;

        int[] ara = new int[nums.length];
        int i=0;

        for (int j=nums.length-k; j<nums.length; j++)
            ara[i++] = nums[j];

        for (int j=0; j<nums.length-k; j++)
            ara[i++] = nums[j];

        for(i=0; i<ara.length; i++)
            nums[i] = ara[i];
    }
}
/*
class Solution {
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);

    }
    public void reverse(int nums[],int start,int end){
        while(start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
}
 */

