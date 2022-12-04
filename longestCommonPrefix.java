/*public class longestCommonPrefix    {
    public String prefix (String[] strs)    {
        String pre = strs[0];

        for (int index=1; index<strs.length; index++)   {
            while (strs[index].indexOf(pre) != 0)
                pre = pre.substring(0, pre.length()-1);
        }
        return pre;
    }
}

/*(Working:
1)Take the first(index=0) string in the array as prefix.
2)Iterate from second(index=1) string till the end.
3)Use the indexOf() function to check if the prefix is there in the strs[i] or not.
If the prefix is there the function returns 0 else -1.
4)Use the substring function to chop the last letter from prefix each time the function return -1.

eg:
strs=["flower", "flow", "flight"]
prefix=flower
index=1
    while(strs[index].indexOf(prefix) != 0) means while("flow".indexOf("flower")!=0)
    Since flower as a whole is not in flow, it return -1 and  prefix=prefix.substring(0,prefix.length()-1) reduces prefix to "flowe"
    Again while(strs[index].indexOf(prefix) != 0) means while("flow".indexOf("flowe")!=0)
    Since flowe as a whole is not in flow, it return -1 and  prefix=prefix.substring(0,prefix.length()-1) reduces prefix to "flow"
    Again while(strs[index].indexOf(prefix) != 0) means while("flow".indexOf("flow")!=0)
    Since flow as a whole is in flow, it returns 0 so now prefix=flow
index=2
    while(strs[index].indexOf(prefix) != 0) means while("flight".indexOf("flow")!=0)
    Since flow as a whole is not in flight, it return -1 and  prefix=prefix.substring(0,prefix.length()-1) reduces prefix to "flo"
    Again while(strs[index].indexOf(prefix) != 0) means while("flight".indexOf("flo")!=0)
    Since flo as a whole is not in flight, it return -1 and  prefix=prefix.substring(0,prefix.length()-1) reduces prefix to "fl"
    Again while(strs[index].indexOf(prefix) != 0) means while("flight".indexOf("fl")!=0)
    Since fl as a whole is in flight, it returns 0 so now prefix=fl
index=3, for loop terminates and we return prefix which is equal to fl
*/


/*for (int i=0; i<strs.length; i++) {
            if (strs[0].equals(str)) {
                return str;
            }
            char check = strs[0].charAt(i);
            int trueOrNot = 0, j=1;

            while (j<strs.length)    {
                if (check != strs[j++].charAt(i))   {
                    trueOrNot = 1;
                    break;
                }
            }


            if (trueOrNot == 0)
                str += check;
            else
                break;
        }*/
