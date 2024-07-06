public class LongestCommonSuffixQueries {
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        int queryLen = wordsQuery.length, containerLen = wordsContainer .length;

        int[] ans = new int[wordsQuery.length];

        for (int i=0; i<queryLen; i++)  {
            char[] query = wordsQuery[i].toCharArray();
            int prevLen = Integer.MAX_VALUE, prevLenMatched = Integer.MIN_VALUE, ansIndex = 0;

            for (int j=containerLen-1; j>=0; j--)   {
                char[] container = wordsContainer[j].toCharArray();
                int queryIndex = query.length - 1, containerIndex = container.length-1;
                if (j == containerLen-1)
                    prevLen = container.length;

                int currentLenMatched = 0, currentLen = container.length;

                while (queryIndex >= 0) {
                    if (containerIndex >= 0)    {
                        if (query[queryIndex] != container[containerIndex])
                            break;
                        else {
                            currentLenMatched++;
                        }
                    }
                    else {
                        break;
                    }
                    containerIndex--;
                    queryIndex--;
                }
                if (currentLenMatched > prevLenMatched) {
                    ansIndex = j;
                    prevLenMatched = currentLenMatched;
                    prevLen = currentLen;
                }
                else if (currentLenMatched == prevLenMatched)   {
                    if (currentLen < prevLen)   {
                        ansIndex = j;
                        prevLen = currentLen;
                    }
                    else if (currentLen == prevLen)
                        ansIndex = j;
                }
            }
            ans[i] = ansIndex;
        }
        return ans;
    }
}

/* Solution from LeetCode :
class TrieNode {
    public int index;
    public TrieNode[] children;

    public TrieNode() {
        index = Integer.MAX_VALUE;
        children = new TrieNode[26];
    }
}

class Trie {
    private TrieNode root;
    private String[] words;

    private boolean change(int i, int j) { // change i to j ?
        int n = words.length;
        return (0 <= j && j < n) && // j should be valid
            (!(0 <= i && i < n) || // change if i is not valid
             words[j].length() < words[i].length()); // or if less size
             // or if less index: REMOVED as we are inserting words from container with increasing index
    }

    public Trie(String[] words) {
        int n = words.length;
        root = new TrieNode();
        this.words = words;
        for (int i = 0; i < n; i++) {
            insertSuffix(words[i], i);
        }
    }

    public void insertSuffix(String s, int index) {
        TrieNode curr = root;
        char[] str = s.toCharArray();
        for (int i = str.length - 1; i >= 0; i--) {
            if (curr.children[str[i] - 'a'] == null) {
                curr.children[str[i] - 'a'] = new TrieNode();
            }
            if (change(curr.index, index)) {
                curr.index = index;
            }
            curr = curr.children[str[i] - 'a'];
        }
        if (change(curr.index, index)) {
            curr.index = index;
        }
    }

    public int longestCommonSuffix(String s) {
        TrieNode curr = root;
        char[] str = s.toCharArray();
        for (int i = str.length - 1; i >= 0 && curr.children[str[i] - 'a'] != null; i--) {
            curr = curr.children[str[i] - 'a'];
        }
        return curr.index;
    }
}

class Solution {
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        int m = wordsQuery.length;
        Trie trie = new Trie(wordsContainer);
        int[] result = new int[m];
        for (int i = 0; i < m; i++) {
            result[i] = trie.longestCommonSuffix(wordsQuery[i]);
        }
        return result;
    }
}
 */