import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<String> strings = new ArrayList<>();
        List<List<String>> stringsList = new ArrayList<>();
        partition(0, s.toCharArray(), strings, stringsList);
        return stringsList;
    }

    private void partition(int i, char[] str,List<String> strings, List<List<String>> lists)  {
        if (i >= str.length)    {
            lists.add(new ArrayList<>(strings));
            return;
        }
        for (int j=i; j<str.length; j++)    {
            if (isPalindrome(str, i, j))    {
                StringBuilder stringBuilder = new StringBuilder();
                int tempI = i;
                while (tempI <= j)
                    stringBuilder.append(str[tempI++]);

                strings.add(stringBuilder.toString());
                partition(j+1, str, strings, lists);
                strings.removeLast();
            }
        }
    }

    private boolean isPalindrome(char[] str, int i, int j) {
        while (i < j) {
            if (str[i++] != str[j--])
                return false;
        }
        return true;
    }
}

/* 0ms runtime :
import java.util.AbstractList;

class Solution {

    private StringBuilder givenStr;
    private int givenStrLength;

    private List<List<String>> result;
    private List<String> subsResult;

    public List<List<String>> partition(String s) {

        // result = new ArrayList<List<String>>();
        givenStr = new StringBuilder(s);
        givenStrLength = s.length();
        subsResult = new ArrayList<String>();

        // dfs(0);
        // return result;

        return new AbstractList<List<String>>() {
            @Override
            public int size() {
                init();
                return result.size();
            }

            @Override
            public List<String> get(int index) {
                init();
                return result.get(index);
            }

            private void init() {
                if (result != null) return;
                result = new ArrayList<List<String>>();
                dfs(0);
            }
        };

    }

     private void dfs(int startIndex) {
        if (startIndex == givenStrLength) {
            result.add(new ArrayList<String>(subsResult));
            return;
        }

        for (int i = startIndex; i < givenStrLength; i++) {
            // we do not need to process further
            // if the first part of the string (startIndex to i) is not palindrome
            if (!isPalindrome(givenStr, startIndex, i)) continue;

            // It means that first part (startIndex to i) is palindrome.
            // Let add into the subResult
            subsResult.add(givenStr.substring(startIndex, i + 1));

            // Now let process the second part (i+1 to string length)
            dfs(i + 1);

            // Repeat the for (startIndex to i+1), so let remove from the list
            subsResult.remove(subsResult.size() - 1);
        }

    }

    private boolean isPalindrome(StringBuilder s, int low, int high) {
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) return false;
            low++;
            high--;
        }
        return true;
    }

}
 */






// ################################## 3ms runtime: More of a cup of tea : ##############################################
/*
class Solution {
    int n;
    boolean[][] is_palindrome;
    String[][] substrings;

    List<List<String>> ans;

    void FindSubstrings(int ind, ArrayList<String> list) {
        if (ind == n) {
            ans.add(new ArrayList<String>(list));
            return;
        }

        for (int i = ind + 1; i <= n; i++) {
            if (!is_palindrome[ind][i]) continue;
            list.add(substrings[ind][i]);
            FindSubstrings(i, list);
            list.remove(list.size() - 1);
        }
    }

    public List<List<String>> partition(String s) {
        n = s.length();
        is_palindrome = new boolean[n + 1][n + 1];
        substrings = new String[n + 1][n + 1];
        for (int i = 0; i < n; i++) for (int j = i + 1; j <= n; j++) {
            substrings[i][j] = s.substring(i, j);
            is_palindrome[i][j] = IsPalindrome(substrings[i][j]);
        }

        ans = new ArrayList<List<String>>();
        FindSubstrings(0, new ArrayList<String>());
        return ans;
    }

    boolean IsPalindrome(String s) {
        int lower = 0;
        int higher = s.length() - 1;
        while (lower < higher) {
            if (s.charAt(lower) != s.charAt(higher)) return false;
            lower++;
            higher--;
        }
        return true;
    }
}
 */


/*        6ms runtime :
import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<String>> res;
    String s;

    public List<List<String>> partition(String s) {
        this.res = new ArrayList<>();
        this.s = s;
        recursiveBacktrack(new ArrayList<>(), 0);
        return this.res;
    }

    void recursiveBacktrack(ArrayList<String> current, int index) {
        if (index == s.length()) {
            res.add(new ArrayList<>(current));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                current.add(s.substring(index, i + 1));
                recursiveBacktrack(current, i + 1);
                current.remove(current.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String str, int left, int right) {
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
 */