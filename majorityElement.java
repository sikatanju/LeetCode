import java.util.Map;
import java.util.HashMap;

public class majorityElement {
    public int findElement (int[] nums) {
        int major = -1, value = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)    {
            if (map.containsKey(num))   {
                int temp = map.get(num);
                temp++;
                if (temp > value)   {
                    major = num;
                    value = temp;
                }
                map.put(num, temp);
            }
            else    {
                map.put(num, 1);
                if (value < 1)  {
                    major = num;
                    value = 1;
                }

            }
        }
        return major;
    }
}
