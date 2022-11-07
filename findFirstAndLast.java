// This problem is find the First and Last Position of a given target in a Sorted Array.
// The time complexity must be 0(logn). Difficulty : Normal.
import java.util.Arrays;

public class findFirstAndLast {
    public int[] search(int[] nums, int target)    {
        int left = 0;
        int right = nums.length-1;
        
        int ara[] = {-1, -1};

        int index = -1;

        while (left <= right)   {
            int middle = (left + right) / 2;
            
            if (nums[middle] == target)  {
                index = middle;
                break;
            }
            
            if (target < nums[middle])
                right = middle-1;

            if (target > nums[middle])
                left = middle+1;
        }
        if (index == -1)
            return ara;


        ara[0] = findLeft(nums, index, target);
        ara[1] = findRight(nums, index, target);
        
        return ara;
    }

    public int findRight(int[] ara, int index, int target)  {
        while (true)    {
            if (index+1 == ara.length || ara[index+1] != target)
                break;
            
            index++;
        }
        return index;
    }

    public int findLeft(int[] ara, int index, int target)   {
        while (true)    {
            if (index-1 < 0 || ara[index-1] != target)
                break;

            index--;
        }
        return index;
    }

    public static void main(String[] args)  {
        int[] ara = {7,7,7,8,8,10};
        findFirstAndLast obj = new findFirstAndLast();
        System.out.println (Arrays.toString(obj.search(ara, 7)));
    }
}
