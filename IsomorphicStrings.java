import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();

        for (int i=0; i<s.length(); i++)    {
            var ch = s.charAt(i);
            var ch2 = t.charAt(i);

            if (map.containsKey(ch) || map2.containsKey(ch2))    {
                if (map.containsKey(ch))    {
                    if (map.get(ch) != ch2)
                        return false;
                }
                else
                    if (map2.get(ch2) != ch)
                        return false;
            }
            else    {
                map.put(ch, ch2);
                map2.put(ch2, ch);
            }
        }
        return true;
    }
}


/* 1ms runtime solution :

class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] map1=new int[200];
        boolean[] map2=new boolean[200];
        char[] s1=s.toCharArray();
        char[] t1=t.toCharArray();
        for(int i=0;i<s1.length;i++){
            if( !map2[t1[i]] ){
                map1[s1[i]]=t1[i];
                map2[t1[i]]=true;
            }
        }
        for(int i=0;i<s1.length;i++){
            if(map1[s1[i]]!=t1[i]) return false;
        }
        return true;
    }
}

 */