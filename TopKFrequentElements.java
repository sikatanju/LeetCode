import java.util.*;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int temp : nums)
            map.put(temp, map.getOrDefault(temp, 0)+1);


        List<Integer> list[] = new List[nums.length+1];
        for (int key : map.keySet())    {
            int frequency = map.get(key);
            if (list[frequency] == null)
                list[frequency] = new LinkedList<>();

            list[frequency].add(key);
        }

        int[] ara = new int[k];
        int index = 0;

        for(int i=list.length-1; i>=0; i--) {
            if (list[i] != null)    {
                for (int temp : list[i])
                    ara[index++] = temp;

                if (index == k)
                    return ara;
            }
        }
        return ara;
    }
}
