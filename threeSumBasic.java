/*import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
/* */
public class threeSumBasic {
    /*public List<List<Integer>> threeSum(int[] nums)     {
        List<List<Integer>> returnList = new ArrayList<>();
        Arrays.sort(nums);
        for (int i=0; i<nums.length; i++)   {
            if (i!=0 && nums[i] == nums[i-1])
                continue;

            int j=i+1; 
            int k = nums.length-1;
            while (j<k) {
                if (-nums[i] == nums[j] + nums[k]) {
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(nums[i]);
                    tempList.add(nums[j]);
                    tempList.add(nums[k]);
                    returnList.add(tempList);
                    
                    while (j+1<k && nums[j] == nums[j+1])   j++;

                    ++j;
                }
                else if (nums[i] + nums[j] + nums[k] < 0)
                    j++;

                else
                    k--;
            }
        }
        // System.out.println (Arrays.toString(returnList.toArray()));
        return returnList;
    }
    
    public static void main(String[] args)  {
        int[] nums = {-1,0,1,1};

        threeSumBasic ob = new threeSumBasic();
        ob.threeSum(nums);
    }*/
}
