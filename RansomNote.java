import java.util.HashMap;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (char ch: ransomNote.toCharArray()) {
            if (hashMap.containsKey(ch))
                hashMap.replace(ch, hashMap.get(ch)+1);
            else
                hashMap.put(ch, 1);
        }

        for (char ch: magazine.toCharArray())   {
            if (hashMap.containsKey(ch))    {
                int temp = hashMap.get(ch);
                temp--;
                if (temp == 0)
                    hashMap.remove(ch);
                else
                    hashMap.put(ch, temp);
            }
        }
        return hashMap.size() == 0 ? true : false;
    }
}


/* 0ms runtime :
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] chrCount = new int[26];
        for(char c : ransomNote.toCharArray()){
            int index = magazine.indexOf(c, chrCount[c - 'a']);
            if(index == -1)return false;
            chrCount[c - 'a'] = index + 1;
        }
        return true;
    }
}
 */