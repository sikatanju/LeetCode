public class searchInsertPosition {
    
    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length-1, middle = 0; 
        
        if (target > nums[right])
                return right+1;
        
        while (left <= right)    {
            middle = (left+right)/2;
            
            if (nums[middle] == target)
                return middle;

            if (target > nums[middle])
                left = middle + 1;
            else
                right = middle - 1;
        }
        return left;
    }

    public static void main(String[] args)  {
        int[] ara = {1, 3, 4, 5, 6, 8, 9, 11};
        System.out.println (searchInsert(ara, 2));
    }
}
