import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AlienDictionary {
    private Map<Character, Set<Character>> adj;
    private Map<Character, Boolean> visited;
    private List<Character> res;

    public String foreignDictionary(String[] words) {
        this.adj = new HashMap<>();

        for (String word: words)    {
            for (char ch: word.toCharArray())
                adj.putIfAbsent(ch, new HashSet<>());
        }

        for (int i=0; i<words.length-1; i++)    {
            String word1 = words[i], word2 = words[i+1];
            int len1 = word1.length(), len2 = word2.length();
            int minLen = Math.min(len1, len2);
            if (len1 > len2 && word1.substring(0, minLen).equals(word2.substring(0, minLen)))
                return "";

            for (int j=0; j<minLen; j++)   {
                if (word1.charAt(j) != word2.charAt(j)) {
                    adj.get(word1.charAt(j)).add(word2.charAt(j));
                    break;
                }
            }
        }
        this.visited = new HashMap<>();
        this.res = new ArrayList<>();

        for (char ch: adj.keySet()) {
            if (dfs(ch))
                return "";
        }

        Collections.reverse(res);
        StringBuilder str = new StringBuilder();

        for (char ch: res)
            str.append(ch);

        return str.toString();
    }
    private boolean dfs(char ch)   {
        if (visited.containsKey(ch))
            return visited.get(ch);

        visited.put(ch, true);
        for (char c: adj.get(ch))   {
            if (dfs(c))
                return true;
        }
        visited.put(ch, false);
        res.add(ch);
        return false;
    }
}
