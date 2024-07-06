import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordSearchII {
    private class Node  {
        private char value;
        private boolean isEndOfWord;
        private Map<Character, Node> children;
        Node()  {
            this.children = new HashMap<>();
        }
        Node(char ch)   {
            this.value = ch;
            this.children = new HashMap<>();
        }
    }

    private void insert(String word)    {
        Node temp = root;
        for(char ch: word.toCharArray())    {
            if (!temp.children.containsKey(ch))
                temp.children.put(ch, new Node(ch));

            temp = temp.children.get(ch);
        }
        temp.isEndOfWord = true;
    }


    private Node root;
    private int rowLen;
    private int columnLen;
    private Set<String> result;

    public List<String> findWords(char[][] board, String[] words) {
        this.root = new Node();
        for (var word: words)
            insert(word);

        this.rowLen = board.length;
        this.columnLen = board[0].length;

        this.result = new HashSet<>();
        for (int i=0; i<rowLen; i++)    {
            for (int j=0; j<columnLen; j++) {
                dfs(i, j, new boolean[rowLen][columnLen], "", board, root);
            }
        }
        return result.stream().toList();
    }

    private void dfs(int row, int column, boolean[][] visited, String word, char[][] board, Node node) {
        if (row < 0 || column < 0 || row == rowLen || column == columnLen || visited[row][column] || !node.children.containsKey(board[row][column])) {
            return;
        }
        visited[row][column] = true;
        node = node.children.get(board[row][column]);
        word += board[row][column];
        if (node.isEndOfWord)
            this.result.add(word);

        dfs(row+1, column, visited, word, board, node);
        dfs(row, column+1, visited, word, board, node);
        dfs(row-1, column, visited, word, board, node);
        dfs(row, column-1, visited, word, board, node);
        visited[row][column] = false;
    }
}


/* Second best : 39ms runtime :

class Solution {

private class TrieNode {
    boolean isWord;
    String cur;
    int countNext;
    TrieNode[] next;
    TrieNode(boolean isWord, String cur) {
        this.isWord = isWord;
        this.cur = cur;
        countNext = 0;
        next = new TrieNode[26];
    }
}

public List<String> findWords(char[][] board, String[] words) {
    List<String> ans = new ArrayList<>();

    //build trie
    TrieNode rootDummy = new TrieNode(false, "");
    for (String word : words) {
        TrieNode current = rootDummy;
        for (int i=0; i<word.length(); i++) {
            if (current.next[word.charAt(i)-'a'] == null) {
                current.next[word.charAt(i)-'a'] = new TrieNode(false, word.substring(0,i+1));
                current.countNext++;
            }
            current = current.next[word.charAt(i)-'a'];
        }
        current.isWord = true;
    }

    //flood
    for (int i=0; i<board.length; i++) {
        for (int j=0; j<board[0].length; j++) {
            flood(rootDummy, i, j, board, ans);
        }
    }

    return ans;
}

private void flood(TrieNode cur, int x, int y, char[][] board, List<String> ans) {
    if (board[x][y] == '#' || cur.next[board[x][y]-'a'] == null) return;
    TrieNode parent = cur;
    cur = cur.next[board[x][y]-'a'];
    if (cur.isWord) {
        ans.add(cur.cur);
        cur.isWord = false;
    }
    if (cur.countNext == 0) {
        parent.next[cur.cur.charAt(cur.cur.length()-1)-'a'] = null;
        parent.countNext--;
        return;
    }
    char c = board[x][y];
    board[x][y] = '#';
    if (x < board.length-1) flood(cur, x+1, y, board, ans);
    if (x > 0) flood(cur, x-1, y, board, ans);
    if (y < board[0].length-1) flood(cur, x, y+1, board, ans);
    if (y > 0) flood(cur, x, y-1, board, ans);
    board[x][y] = c;
}
}

 */
/* Time limit exceeds, could handle around 61 test cases out of 65

public class WordSearchII {
    private int rowLen;
    private int columnLen;

    private class NodeIndex {
        private int rowIndex;
        private int columnIndex;
        NodeIndex() {
        }
        NodeIndex(int rowIndex, int columnIndex)    {
            this.rowIndex = rowIndex;
            this.columnIndex = columnIndex;
        }
    }
    public List<String> findWords(char[][] board, String[] words) {
        this.rowLen = board.length;
        this.columnLen = board[0].length;

        Set<Character> set = new HashSet<>();
        Map<Character, List<NodeIndex>> map = new HashMap<>();
        boolean[][] visited = new boolean[rowLen][columnLen];

        for (var word: words)
            set.add(word.charAt(0));

        for (int i=0; i<rowLen; i++)    {
            for (int j=0; j<columnLen; j++) {
                if (set.contains(board[i][j]))  {
                    map.putIfAbsent(board[i][j], new ArrayList<>());
                    map.get(board[i][j]).add(new NodeIndex(i, j));
                }
            }
        }
        List<String> wordsToReturn = new ArrayList<>();
        Set<String> takenWords = new HashSet<>();
        for (var word: words)   {
            if (takenWords.contains(word))
                continue;

            if (map.containsKey(word.charAt(0)))    {
                var listOfNodes = map.get(word.charAt(0));
                for (var temp: listOfNodes) {
                    if (dfs(temp.rowIndex, temp.columnIndex, 0, word.toCharArray(), visited, board))    {
                        if (!takenWords.contains(word))
                            wordsToReturn.add(word);

                        takenWords.add(word);
                    }
                    visited = new boolean[rowLen][columnLen];
                }
            }
        }
        return wordsToReturn;
    }

    private boolean dfs(int row, int column, int charAt, char[] word, boolean[][] visited, char[][] board)  {
        if (charAt == word.length)
            return true;

        if (row < 0 || row == rowLen || column < 0 || column == columnLen || word[charAt] != board[row][column] || visited[row][column])
            return false;

        visited[row][column] = true;
        if (dfs(row+1, column, charAt+1, word, visited, board) ||
                dfs(row, column+1, charAt+1, word, visited, board) ||
                dfs(row-1, column, charAt+1, word, visited, board) ||
                dfs(row, column-1, charAt+1, word, visited, board)) {
            return true;
        }
        visited[row][column] = false;
        return false;
    }
}

 */