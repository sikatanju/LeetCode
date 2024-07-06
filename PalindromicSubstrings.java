import java.util.HashMap;
import java.util.Map;

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int len = s.length();
        int substringCount = 0;
        boolean[][] matrix = new boolean[len][len];

        for (int i=0; i<len; i++)   {
            matrix[i][i] = true;
            substringCount++;
        }

        for (int i=0; i<len-1; i++) {
            if (s.charAt(i) == s.charAt(i+1))   {
                matrix[i][i+1] = true;
                substringCount++;
            }
        }

        for (int ll=3; ll <= len; ll++)   {
            for (int i=0; i<len-ll+1; i++)  {
                if (s.charAt(i) == s.charAt(i+ll-1) && matrix[i+1][i+ll-2]) {
                    matrix[i][i+ll-1] = true;
                    substringCount++;
                }
            }
        }
        return substringCount;
    }
}

/* Best runtime : 5ms

class Solution {
    int start=0,length=0,maxLength=0,count=0;
    public int countSubstrings(String s) {
        length =s.length();

        for(int i=0;i<length;i++){
            i = countAndReturnNextIndex(s,i);
        }
        return count;
    }
    public int countAndReturnNextIndex(String s,int k){

        int left = k-1,right=k;
        while(right<length -1 && s.charAt(right) == s.charAt(right+1)) right++;
        int countOfSameChar = right-left;
        if(countOfSameChar >=1){
            count+= (countOfSameChar*(countOfSameChar+1))/2 ;
        }
        int nextIndex = right++;
        while(left>=0 && right<length && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
            count++;
        }
        return nextIndex;

    }
}

 */

/*

    public int countSubstrings(String s) {
        int palindromicSubstrings = 0;
        Map<String, Boolean> map = new HashMap<>();
        for (int i=0; i<s.length(); i++)    {
            for (int j=i+1; j<=s.length(); j++)  {
                String subString = s.substring(i, j);
                boolean palindrome = isPalindrome(subString, map);
                if (palindrome)
                    palindromicSubstrings++;

                map.put(getString(i, j-1), palindrome);
            }
        }
    return palindromicSubstrings;
    }

    private String getString(int i, int j) {
        String a = Integer.toString(i);
        String b = Integer.toString(j);
        return a+b;
    }

    private boolean isPalindrome(String subString, Map<String, Boolean> map) {
        char[] str = subString.toCharArray();
        int len = str.length;
        if (len == 1)
            return true;

        int low = 0, high = len-1;

        while (low < high)  {
            if (str[low] != str[high])
                return false;
            else    {
                low++;
                high--;

                if (low == high && str[low] == str[high])
                    return true;

                String key = getString(low, high);
                if (map.containsKey(key))  {
                    return map.get(key);
                }
            }
        }
        return true;
    }
 */
