import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class GroupAnargrams {

    private final int[] primeNums = {5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113};

    private long getHashCode(String word)   {
        long hash = 1;
        for (char ch: word.toCharArray())
            hash *= (long)primeNums[ch-'a'];

        return hash;
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Long, List<String>> map = new HashMap<>();
        for (var temp: strs)    {
            map.computeIfAbsent(getHashCode(temp), i -> new ArrayList<>()).add(temp);
        }
        return new ArrayList<>(map.values());
    }
}

/* Previous Solution:
public List<List<String>> makeList(String[] strs)   {
        Map<String, List<String>> returnMap = new HashMap<>();
        for (String temp : strs)    {
            char[] ch = new char[26];
            for (char c : temp.toCharArray())
                ch[c - 'a']++;

            String temp2 = String.valueOf(ch);

            if (!returnMap.containsKey(temp2))
                returnMap.put(temp2, new ArrayList<String>());

            returnMap.get(temp2).add(temp);
        }
        return new ArrayList<>(returnMap.values());
    }
 */

/* Best runtime: 0ms
 import java.util.AbstractList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.ArrayList;
 import java.util.Map;
 class Solution{
    private List<List<String>>ans;
    public List<List<String>>groupAnagrams(String[] strs){
        return new AbstractList<List<String>>(){
            public List<String>get(int index){
                if(ans==null)init();//intialisation if not done
                return ans.get(index);//return the anagram group at specific index
            }
            public int size(){
                if(ans==null) init();//initialize if not done
                return ans.size();//return the size of anagram group
            }
            public void init(){
                Map<String,List<String>>group=new HashMap<>();//create a HashMap to group Anagram
            for (String s : strs) {
                int[] count =new int[26];//Array to count occurences of each letter
                StringBuffer sb = new StringBuffer();//String buffer to build key
                for(char c:s.toCharArray()){
                    count[c-'a']++;//Increment the count for the character
                }
                for(int i=0;i<26;i++){
                    if(count[i]!=0){
                        sb.append('a'+ i);//append the character
                        sb.append(count[i] );
                    }
                }
                String key=sb.toString();
                 group.computeIfAbsent(key, k -> new ArrayList<String>()).add(s); // Group the anagram
                //group the Anagram
            }
            ans = new ArrayList<>(group.values());
            }
        };
    }
 }
 */
