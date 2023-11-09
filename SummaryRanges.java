import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        int len = nums.length;
        List<String> str = new ArrayList<>();

        for (int i=0; i<len; i++)   {
            var num = nums[i];
            int j = i;

            String temp = "";
            temp += Integer.toString(num);

            while (true)    {
                if (j+1 < len && num+1 == nums[j+1])
                    num = nums[++j];
                else
                    break;
            }
            if (i==j)   {
                str.add(temp);
                temp = "";
            }
            else {
                temp += "->";
                temp += Integer.toString(nums[j]);
                str.add(temp);
                i = j;
            }
        }
        return str;
    }
}
