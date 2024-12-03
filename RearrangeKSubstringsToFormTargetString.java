import java.util.HashMap;
import java.util.Map;

public class RearrangeKSubstringsToFormTargetString {
    public boolean isPossibleToRearrange(String s, String t, int k) {
        int len = s.length();
        int div = len/k;
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<len; i += div)  {
            String sub = s.substring(i, i+div);
            map.put(sub, map.getOrDefault(sub, 0)+1);
        }
        for (int i=0; i<len; i += div)  {
            String sub = t.substring(i, i+div);
            if (map.getOrDefault(sub, 0) > 0)
                map.replace(sub, map.get(sub)-1);
            else
                return false;
        }
        return true;
    }
}
