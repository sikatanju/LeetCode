/*public class groupAnaragramsReloaded {
   
}*/



/* // This one runs at 0ms at leetCode. 


import java.util.AbstractList;
class Solution {
    
     private List<List<String>> result;

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        return new AbstractList<List<String>>() {

            public List<String> get(int index) {
                if (result == null)
                    init();
                return result.get(index);
            }

            public int size() {
                if (result == null)
                    init();
                return result.size();
            }

            private void init() {
                for (String s : strs) {
                    char[] count = new char[26];

                    for (char c : s.toCharArray())
                        count[c - 'a']++;
                    String key = String.valueOf(count);
                    if (!map.containsKey(key))
                        map.put(key, new ArrayList<String>());

                    map.get(key).add(s);
                }

                result = new ArrayList<>(map.values());
            }
        };
    }
} 
*/

/* // This runs at 2ms time.
 
class Solution {
public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> result = new ArrayList<List<String>>();
 
    HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
    for(String str: strs){
        char[] arr = new char[26];
        for(int i=0; i<str.length(); i++){
            arr[str.charAt(i)-'a']++;
        }
        String ns = new String(arr);
 
        if(map.containsKey(ns)){
            map.get(ns).add(str);
        }else{
            ArrayList<String> al = new ArrayList<String>();
            al.add(str);
            map.put(ns, al);
        }
    }
 
    result.addAll(map.values());
 
return result;
      }
}


 */