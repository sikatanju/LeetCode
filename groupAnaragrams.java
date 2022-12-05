/*import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class groupAnaragrams {
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
}
*/



// It doesn't work for all the cases.

/*public List<List<String>> makeList (String[] strs)  {
        List<List<String>> returnList = new ArrayList<List<String>>();
        int count = 0, sum = 0;
        
        for (int i=0; i<strs.length; i++)   {
            if (strs[i] == null)
                continue;
            if (count == strs.length)
                break;

            else    {
                List<String> tempList = new ArrayList<>();
                for (char ch: strs[i].toCharArray())
                    sum += ch;
                
                tempList.add(strs[i]);
                strs[i] = null;
                count++;
                
                if (i == strs.length-1) {
                    returnList.add(new ArrayList<String>(tempList));
                    break;
                }

                else    {
                    for (int j=i+1; j<strs.length; j++) {
                        if (strs[j] == null)
                            continue;

                        int temp = 0;
                        for (char c: strs[j].toCharArray())
                            temp += c;
                        
                        if (temp == sum)    {
                            tempList.add(strs[j]);
                            strs[j] = null;
                            count++;
                        }
                    }
                    returnList.add(new ArrayList<String>(tempList));
                }
                sum = 0;
            }
        }
        return returnList;
    }*/