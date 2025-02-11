public class ExtraCharactersInAString2707 {
    class Trie {
        public Trie[] children;
        public boolean isWord;

        public Trie() {
            this.children = new Trie[26];
            this.isWord = false;
        }

        public void addWord(String str) {
            Trie temp = this;
            for (var ch: str.toCharArray()) {
                if (temp.children[ch-'a'] == null)
                    temp.children[ch-'a'] = new Trie();

                temp = temp.children[ch-'a'];
            }
            temp.isWord = true;
        }
    }

    public int minExtraChar(String s, String[] dictionary) {
        Trie trie = new Trie();
        for (var str: dictionary)
            trie.addWord(str);

        Integer[] dp = new Integer[s.length()+1];
        return backtrack(0, s.toCharArray(), dp, trie);
    }
    private int backtrack(int i, char[] s, Integer[] dp, Trie trie)   {
        if (i == s.length)
            return 0;

        if (dp[i] != null)
            return dp[i];

        dp[i] = 1 + backtrack(i+1, s, dp, trie);
        var temp = trie;

        for (int j=i; j<s.length; j++)    {
            int idx = s[j]-'a';
            if (temp.children[idx] == null)
                break;

            temp = temp.children[idx];

            if (temp.isWord)    {
                dp[i] = Math.min(dp[i], backtrack(j+1, s, dp, trie));
            }
        }
        return dp[i];
    }
}

/* Recursive Memoization solution:
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> set = new HashSet<>(Arrays.asList(dictionary));
        Integer[] dp = new Integer[s.length()+1];
        return backtrack(0, s, set, dp);
    }

    private int backtrack(int i, String s, Set<String> dictionary, Integer[] dp)  {
        if (i==s.length())
            return 0;
        if (dp[i] != null)
            return dp[i];

        dp[i] = 1+backtrack(i+1, s, dictionary, dp);
        for (int j=i; j<s.length(); j++)    {
            if (dictionary.contains(s.substring(i, j+1)))
                dp[i] =  Math.min(dp[i], backtrack(j+1, s, dictionary, dp));
        }
        return dp[i];
    }
 */