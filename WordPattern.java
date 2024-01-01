import java.util.HashMap;
import java.util.HashSet;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] strings = s.split(" ");

        HashSet<String> set = new HashSet<>();
        HashMap<Character, String> hashMap = new HashMap<>();
        int index = 0;

        for (char ch: pattern.toCharArray())    {
            if (index == strings.length)
                return false;

            if (hashMap.containsKey(ch))    {
                String str = hashMap.get(ch);
                if (!str.equals(strings[index++]))
                    return false;
            }
            else    {
                if (!set.contains(strings[index]))  {
                    set.add(strings[index]);
                    hashMap.putIfAbsent(ch, strings[index++]);
                }
                else
                    return false;
            }
        }
        return index == strings.length ? true : false;
    }
}


/* 0ms runtime :
class Solution {
    public boolean wordPattern(String pattern, String s) {
        var parts = s.split(" ", -1);
        if(parts.length!=pattern.length()) return false;
        var ctos = new HashMap<Character, String>();
        var stoc = new HashMap<String, Character>();
        for(int i=0; i<pattern.length(); i++)
        {
            var c = pattern.charAt(i);
            var str = parts[i];
            if(ctos.containsKey(c) && stoc.containsKey(str))
            {
                if((!ctos.get(c).equals(str)|| !(stoc.get(str)==c)))
                {
                    return false;
                }
                continue;
            }
            if(ctos.containsKey(c) || stoc.containsKey(str))
            {
                return false;
            }
            stoc.put(str,c);
            ctos.put(c, str);
        }

        return true;
    }
}
 */