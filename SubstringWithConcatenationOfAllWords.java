import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> indexes = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        int totalWords = words.length, wordLen = words[0].length();
        int totalLen = totalWords*wordLen;

        char[] str = s.toCharArray();

        if (str.length < (totalLen))
            return indexes;

        for (var temp: words)   {
            if (map.containsKey(temp))  {
                map.replace(temp, map.get(temp)+1);
            }   else {
                map.put(temp, 1);
            }
        }

        for (int i=0; i<=str.length-(totalLen); i++)    {
            String temp = new String(str, i, wordLen);
            if (map.containsKey(temp))  {
                if (doesMatch(new String(str, i, (totalLen)), new HashMap<>(map), totalWords, wordLen))    {
                    indexes.add(i);
                }
            }
        }
        return indexes;
    }

    private boolean doesMatch(String s, Map<String, Integer> map, int totalWords, int wordLen)    {
        char[] str = s.toCharArray();
        int index = 0;
        while (index < s.length())    {
            String temp = new String(str, index, wordLen);
            if (map.containsKey(temp))  {
                int num = map.get(temp);
                if (num > 1)
                    map.replace(temp, num-1);
                else
                    map.remove(temp);

                totalWords--;
                index += wordLen;
            }   else    {
                return false;
            }
        }
        return (totalWords==0 && map.size()==0);
    }
}

/* Best runtime : 16ms:
import java.util.*;

class Solution {
    List<Integer> solvedRes = null;
    String concatString = null;

    public List<Integer> findSubstring(String s, String[] words) {
        return new AbstractList<>() {
            public Integer get(int index) {
                if (solvedRes == null) {
                    solvedRes = solve(s, words);
                }
                return solvedRes.get(index);
            }

            public int size() {
                if (solvedRes == null) {
                    solvedRes = solve(s, words);
                }
                return solvedRes.size();
            }
        };
    }

    List<Integer> solve(String s, String[] words) {
        Map<String, List<Integer>> wordsMap = new HashMap<>();
        int wordLength = words[0].length();
        int n = words.length;
        int totalSize = wordLength * n;
        boolean[] startingLetters = new boolean[26];
        boolean[] endingLetters = new boolean[26];

        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            startingLetters[w.charAt(0) - 'a'] = true;
            endingLetters[w.charAt(w.length() - 1) - 'a'] = true;
            wordsMap.computeIfAbsent(w, k -> new ArrayList<>());
            wordsMap.get(w).add(i);
        }

        List<Integer> res = new ArrayList<>();
        //System.out.println(Arrays.toString(startingLetters));
        //System.out.println(Arrays.toString(endingLetters));

        for (int i = 0; i <= s.length() - totalSize; i++) {
            if (startingLetters[s.charAt(i) - 'a']
                && endingLetters[s.charAt(i + totalSize - 1) - 'a']) {
                    boolean contains = consider(i, i + totalSize, s, wordsMap, n);
                    if (contains) {
                        res.add(i);
                    }
                }
        }

        return res;
    }

    private boolean consider(int from, int to, String s, Map<String, List<Integer>> words, int size) {

        if (words.size() == 1) {
            String value = concat(words);
            return value.equals(s.substring(from, to));
        }
        int len = (to - from) / size;
        boolean[] visited = new boolean[size];

        //System.out.println(from + " " + to + " " + len);
        for (int i = from; i < to; i+= len) {
            String candidate = s.substring(i, i + len);
            if (words.containsKey(candidate)) {
                int unvisitedIndex = getUnvisited(words.get(candidate), visited);
                if (unvisitedIndex >= 0) {
                    visited[unvisitedIndex] = true;
                    continue;
                }
            }

            return false;
        }
        return true;
    }

    private String concat(Map<String, List<Integer>> words) {
        if (concatString != null) {
            return concatString;
        }
        StringBuilder sb = new StringBuilder();
        String key = words.keySet().iterator().next();
        for (Integer values: words.get(key)) {
            sb.append(key);
        }
        concatString = sb.toString();
        return concatString;
    }

    private int getUnvisited(List<Integer> indexList, boolean[] visited) {
        for (int i = 0; i < indexList.size(); i++) {
            if (!visited[indexList.get(i)]) {
                return indexList.get(i);
            }
        }
        return -1;
    }
    record Pair(char start, char end){}
}
 */


/* Second best : 49ms:
    class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> ans = new ArrayList<>();
            int m = words.length, w = words[0].length();
            Map<String, Integer> map = new HashMap<>(); // <word, count>
            for (String word : words) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
            // 只需要创建 w 个哈希表
            // 分别从 [i][i + 1]...[i + w - 1] 开始搜索
            // 因为 [i + w] 开始的搜索结果被包含在 [i] 的搜索结果中
            for (int i = 0; i < w; i++) {
                Map<String, Integer> currMap = new HashMap<>();
                for (int j = i; j <= s.length() - w; j += w) {
                    String curr = s.substring(j, j + w);
                    if (j - i >= m * w) {
                        int idx = j - m * w; // 上个窗口起始索引
                        String prev = s.substring(idx, idx + w);
                        currMap.put(prev, currMap.getOrDefault(prev, 1) - 1);
                        if (currMap.get(prev) == 0) currMap.remove(prev);
                    }
                    currMap.put(curr, currMap.getOrDefault(curr, 0) + 1);
                    if (currMap.equals(map)) {
                        System.out.println(j);
                        ans.add(j - (m - 1) * w); // 新窗口起始索引
                    }
                }
            }
            return ans;
        }
    }
 */