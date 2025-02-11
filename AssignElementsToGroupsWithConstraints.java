import java.util.HashMap;
import java.util.Map;

public class AssignElementsToGroupsWithConstraints {
    public int[] assignElements(int[] groups, int[] elements) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<elements.length; i++)
            map.putIfAbsent(elements[i], i);

        int[] res = new int[groups.length];
        for (int i=0; i<groups.length; i++)
            res[i] = findSmallestIndex(groups[i], map);

        return res;
    }
    private int findSmallestIndex (int num, Map<Integer, Integer> map)  {
        int idx = Integer.MAX_VALUE, upto = (int)Math.sqrt(num);
        for (int i=1; i<=upto; i++)    {
            if ((num % i == 0 && map.containsKey(i)))
                idx = Math.min(idx, map.get(i));
            if ((num / i != i) && num%i==0 && map.containsKey(num / i))
                idx = Math.min(idx, map.get(num/i));
        }
        return idx == Integer.MAX_VALUE ? -1: idx;
    }
}
