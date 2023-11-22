import java.util.HashMap;
import java.util.Map;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        int str2Len = s2.length();
        int str1Len = 0;
        for (var ch : s1.toCharArray()) {
            str1Len++;
            if (map.containsKey(ch))
                map.replace(ch, map.get(ch)+1);
            else
                map.put(ch, 1);
        }
        for (int i=0; i<str2Len; i++)   {
            if (map.containsKey(s2.charAt(i))) {
                if (checkIfContains(new HashMap<>(map), s2, i, str1Len, str2Len))
                    return true;
            }
        }
        return false;
    }

    private boolean checkIfContains(Map<Character, Integer> map, String s2, int i, int str1Len, int str2Len) {
        if (i+str1Len > str2Len || i == str2Len)
            return false;

        int count = 0;
        do {
            char ch = s2.charAt(i);
            count++;
            if (!map.containsKey(ch))
                return false;
            else    {
                if (map.get(ch) == 1)
                    map.remove(ch);
                else
                    map.replace(ch, map.get(ch)-1);
            }
            if (count == str1Len)
                break;
        }   while (i++ < str2Len);

        if (map.size() == 0)
            return true;

        return false;
    }
}


/* 7ms runtime :
class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int[] map = new int[128];
        char[] s1Array = s1.toCharArray();
        for (int index = 0; index < s1Array.length; index++)
            map[s1Array[index]]++;
        int count = s1Array.length;
        int left = 0;
        int right = 0;
        char[] s2Array = s2.toCharArray();
        while (right < s2Array.length) {
            if (map[s2Array[right++]]-- > 0)
                count--;
            while (count == 0) {
                if (right-left == s1.length()) return true;
                if (++map[s2Array[left++]] > 0) count++;
            }
        }

        return false;


        /* Mine: 11.06%, 761ms */

// if (s1.length() > s2.length()) return false;

// char str1[] = s1.toCharArray();
// Arrays.sort(str1);

// for (int i = 0; s2.length() - i >= s1.length(); i++) {
//     char str2[] = s2.substring(i, i + s1.length()).toCharArray();
//     Arrays.sort(str2);
//     boolean flag = true;
//     for (int j = 0; j < s1.length(); j++) {
//         if (str1[j] != str2[j]) {
//             flag = false;
//             break;
//         }
//     }
//     if (flag) return true;
// }

// return false;


/* standard trying to fine all permutations then mach would cause */
/* Memory Limit Exceed

// if (s1.length() > s2.length()) return false;
// for (String str: permute(s1)) {
//     if (s2.contains(str)) return true;
// }
// return false;
    }

            }
*/