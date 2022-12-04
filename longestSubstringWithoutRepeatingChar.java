// Longest Substring without repeating Characters.

/*import java.util.List;
import java.util.ArrayList;

public class longestSubstringWithoutRepeatingChar {
    public int lengthOfLongestSubstring(String str) {
        if (str.isEmpty())
            return 0;

        List<Character> set = new ArrayList<>();
        List<Character> set2 = new ArrayList<>();
        
        for (char ch: str.toCharArray())    {
            if (!set2.contains(ch)) {
                set2.add(ch);
            }
                
            else    {
                if (set.size() < set2.size())   {
                    set = new ArrayList<Character>(set2);
                    int index = set2.indexOf(ch);
                    while (index >= 0)  {
                        set2.remove(index--);
                    }
                    set2.add(ch);
                }
                else    {
                    int index = set2.indexOf(ch);
                    while (index >= 0)  {
                        set2.remove(index--);
                    }
                    set2.add(ch);
                }
            }
        }
        if (set.size() < set2.size())
            return set2.size();
        else
            return set.size();
    }
}
*/