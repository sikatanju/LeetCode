import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        List<Integer> nums = new ArrayList<>();
        int currentSize = 0;
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();

        for (int i=0; i<chars.length; i++)  {
            if (set.contains(chars[i]))
                currentSize++;
            else {
                var ch = chars[i];
                if (currentSize == 0)   {
                    currentSize++;
                    set.add(ch);
                    continue;
                }
                boolean check = false;
                if (i+1 < chars.length) {
                    for (int j=i+1; j<chars.length; j++)    {
                        var cch = chars[j];
                        if (set.contains(cch)) {
                            check = true;
                            break;
                        }
                    }
                }
                if (check)  {
                    currentSize++;
                    set.add(ch);
                }   else {
                    nums.add(currentSize);
                    currentSize = 0;
                    set = new HashSet<>();
                    i--;
                }
            }
        }
        if (currentSize > 0)
            nums.add(currentSize);

        return nums;
    }
}

// Best Runtime : 0ms

/*
import java.util.AbstractList;

class Solution {
    public List<Integer> partitionLabels(String s) {
        return new AbstractList<Integer>() {

            LinkedList<Integer> result;

            private void init() {
                result = dfs(s.toCharArray(), 0, (s.toCharArray()).length - 1, new int[26]);
            }

            private LinkedList<Integer> dfs(char[] words, int left, int right, int[] dp) {
                LinkedList<Integer> list = new LinkedList<Integer>();

                if(left > right) {
                    return list;
                }

                for(int i = right; i >= left; --i) {
                    if(0 == dp[words[i] - 'a']) {
                        dp[words[i] - 'a'] = i + 1;
                    }
                }

                while(words[right] != words[left]) {
                    right --;
                }

                for(int i = left + 1; i < right; ++i) {
                    int newRight = dp[words[i] - 'a'] - 1;
                    if(newRight > right) {
                        right = newRight;
                    }
                }

                list.add(right - left + 1);
                list.addAll(dfs(words, right + 1, words.length - 1, dp));
                return list;
            }



            private void ENTRY_NO_ENV() {
                if (null == result) {
                    init();
                    System.gc();
                  }
            }


            @Override
            public Integer get(int index) {
                ENTRY_NO_ENV();
                return result.get(index);
            }

            @Override
            public int size() {
                ENTRY_NO_ENV();
                return result.size();
            }

        };
    }

}
 */

/* Runtime : 1ms
class Solution {
    public List<Integer> partitionLabels(String s) {
        int len = s.length();
        char[] arr = s.toCharArray();
        int[] lastIndexes = new int[26];
        Arrays.fill(lastIndexes, -1);
        for(int i = 0; i < len; i++) {
            lastIndexes[arr[i] - 'a'] = i;
        }
        List<Integer> result = new ArrayList<>();
        helper(lastIndexes, arr, 0, result);
        return result;
    }
    void helper(int[] idxes, char[] arr, int idx, List<Integer> result) {
        if(idx == arr.length) return;

        int end = idxes[arr[idx] - 'a'];
        int i = idx;
        while(i < arr.length && i < end) {
            int cur = arr[i] - 'a';
            end = Math.max(end, idxes[cur]);
            i++;
        }
        result.add(end - idx + 1);
        helper(idxes, arr, end + 1, result);
    }
}
 */


/* Runtime : 2ms
class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> list = new LinkedList<>();
        int[] edge = new int[26];
        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            edge[chars[i] - 'a'] = i;
        }
        int idx = 0;
        int last = -1;
        for (int i = 0; i < chars.length; i++) {
            idx = Math.max(idx,edge[chars[i] - 'a']);
            if (i == idx) {
                list.add(i - last);
                last = i;
            }
        }
        return list;
    }
}
 */