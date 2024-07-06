public class ShortestUncommonSubstringInAnArray {
    public String[] shortestSubstrings(String[] arr) {
        int len = arr.length;
        String[] strings = new String[len];
        for (int i=0; i<len; i++)   {
            String min = null;
            int tempLen = arr[i].length();
            for(int j=0; j<tempLen; j++)    {
                inner:
                for (int k=j+1; k<=tempLen; k++) {
                    String temp = arr[i].substring(j, k);
                    for (int l=0; l<len; l++)   {
                        if (l==i)
                            continue;
                        if (arr[l].contains(temp))
                            continue inner;
                    }
                    if (min == null || temp.length() < min.length() || (temp.length() == min.length() && temp.compareTo(min) < 0))
                        min = temp;
                }
            }
            if (min == null)
                min = "";

            strings[i] = min;
        }
        return strings;
    }
}

/* Best runtime : 121ms:
class Solution {
    public String[] shortestSubstrings(String[] arr) {
        int n = arr.length;
        List<Set<String>> list = new ArrayList<>();
        for (String s: arr) {
            list.add(getSubstrings(s));
        }
        // System.out.println(list);
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            List<String> substrings = new ArrayList<>(list.get(i));
            Collections.sort(substrings, (a, b) -> {
                if (a.length() == b.length()) return a.compareTo(b);
                return a.length() - b.length();
            });
            res[i] = "";
            for (String s: substrings) {
                boolean flag = true;
                for (int j = 0; j < n; j++) {
                    if (i == j) continue;
                    if (list.get(j).contains(s)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    res[i] = s;
                    break;
                }
            }
        }
        return res;
    }

    private Set<String> getSubstrings(String s) {
        Set<String> set = new HashSet<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j <= n; j++) {
                set.add(s.substring(i, j));
            }
        }
        return set;
    }
}
 */

/* Solution from uwi (japan)

public static String[] shortestSubstrings(String[] arr) {
        int n = arr.length;
        String[] ret = new String[n];
        for(int i = 0;i < n;i++){
            String best = null;
            for(int j = 0;j < arr[i].length();j++)  {
                inner:
                for(int k = j+1;k <= arr[i].length();k++){
                    String t = arr[i].substring(j, k);
                    for(int l = 0;l < n;l++){
                        if (l == i)
                            continue;

                        if (arr[l].contains(t))  {
                            continue inner;
                        }
                    }
                    if  (best == null || t.length() < best.length() || (t.length() == best.length() && t.compareTo(best) < 0))   {
                        best = t;
                    }
                }
            }
            if (best == null)
                best = "";

            ret[i] = best;
        }
        return ret;
    }

 */