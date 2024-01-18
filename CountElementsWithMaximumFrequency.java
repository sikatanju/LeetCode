import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class CountElementsWithMaximumFrequency {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> mapMax = new HashMap<>();
        mapMax.put(1, 0);
        int maxFrequencies = 1;

        for (int num: nums) {
            if (!map.containsKey(num))  {
                map.put(num, 1);
                mapMax.put(1, mapMax.get(1)+1);
            }
            else {
                map.replace(num, map.get(num)+1);
                int currentFrequencies = map.get(num);

                if (currentFrequencies > maxFrequencies)    {
                    maxFrequencies = currentFrequencies;
                    if (mapMax.containsKey(maxFrequencies))
                        mapMax.replace(maxFrequencies, mapMax.get(maxFrequencies)+1);
                    else
                        mapMax.put(maxFrequencies, currentFrequencies);
                }
                else if (mapMax.containsKey(currentFrequencies))    {
                    mapMax.replace(currentFrequencies, mapMax.get(currentFrequencies)+currentFrequencies);
                }
            }
        }
        return mapMax.get(maxFrequencies);
    }
}
