import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation784 {
    public List<String> letterCasePermutation(String s) {
        s = s.toLowerCase();
        List<String> res = new ArrayList<>();
        permutate(0, s.toCharArray(), res, new StringBuilder());
        return res;
    }
    private void permutate(int i, char[] str, List<String> res, StringBuilder temp) {
        if (i == str.length)    {
            res.add(temp.toString());
            return;
        }

        if (Character.isDigit(str[i])) {
            temp.append(str[i]);
            permutate(i+1, str, res, temp);
            temp.deleteCharAt(temp.length()-1);
        }   else    {
            temp.append(str[i]);
            permutate(i+1, str, res, temp);
            temp.deleteCharAt(temp.length()-1);
            temp.append(Character.toUpperCase(str[i]));
            permutate(i+1, str, res, temp);
            temp.deleteCharAt(temp.length()-1);
        }
    }
}

// Best runtime: 1ms

/*
class Solution {
    public void permutations(int index, int n, String base, StringBuilder builder, List<String> ans){
        if(index==n){
            ans.add(builder.toString());
            return;
        }
        char current = base.charAt(index);
        if(current>='a' && current<='z'){
            char toMake = (char)('A' + (current-'a'));
            builder.setCharAt(index, toMake);
            permutations(index+1, n, base, builder, ans);
            builder.setCharAt(index, current);
        }
        else if(current>='A' && current<='Z'){
            char toMake = (char)('a' + (current-'A'));
            builder.setCharAt(index, toMake);
            permutations(index+1, n, base, builder, ans);
            builder.setCharAt(index, current);
        }
        permutations(index+1, n, base, builder, ans);
    }
    public List<String> letterCasePermutation(String s) {
        int n = s.length();
        StringBuilder builder = new StringBuilder(s);
        List<String> ans = new ArrayList<>();
        permutations(0, n, s, builder, ans);
        return ans;
    }
}
 */