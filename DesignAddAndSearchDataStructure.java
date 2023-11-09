import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DesignAddAndSearchDataStructure {
    private class Node  {
        private char value;
        private Map<Character, Node> children;
        private boolean isEndOfWord;

        Node()  {
            this.children = new HashMap<>();
        }
        Node(char ch)   {
            this.children = new HashMap<>();
            this.value = ch;
        }

        public boolean hasChild(char ch)    {
            return children.containsKey(ch);
        }

        public void addChild(char ch)   {
            children.put(ch, new Node(ch));
        }

        public Node getChild(char ch) {
            return children.get(ch);
        }

        public Node[] getChildren() {
            return children.values().toArray(new Node[0]);
        }
    }

    private Node root;

    public DesignAddAndSearchDataStructure() {
        this.root = new Node();
    }

    public void addWord(String word) {
        Node temp = root;
        for (char ch : word.toCharArray())  {
            if (!temp.hasChild(ch))
                temp.addChild(ch);

            temp = temp.getChild(ch);
        }
        temp.isEndOfWord = true;
    }

    public boolean search(String word) {
        return search(root, word, 0);
    }

    private boolean search(Node root, String word, int index)   {
        if (index == word.length())
            return root.isEndOfWord;

        var ch = word.charAt(index);

        if (ch == '.')  {
            for (var child : root.children.values())    {
                if (search(child, word, index+1))
                    return true;
            }
            return false;
        }
        else {
            var temp = root.getChild(ch);
            if (temp == null)
                return false;

            return search(temp, word, index+1);
        }
    }
}

/* Best Runtime : 146 ms.

class TrieNode{
    public boolean isEnd;
    public TrieNode[] children;
    public TrieNode(){
        isEnd = false;
        children = new TrieNode[26];
    }
}
class WordDictionary {
    public TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        int i = 0;
        while(i < word.length()){
            char ch = word.charAt(i);
            if(cur.children[ch-'a'] == null){
                cur.children[ch-'a'] = new TrieNode();
            }
            cur = cur.children[ch-'a'];
            i++;
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        return searchHelper(word,0,root);
    }

    public boolean searchHelper(String word, int index, TrieNode cur){
        if(index == word.length())
            return cur.isEnd;
        char ch = word.charAt(index);
        if(ch == '.'){
            for(TrieNode node : cur.children){
                if(node!=null && searchHelper(word, index+1, node)){
                    return true;
                }
            }
            return false;
        }
        else{
            TrieNode node = cur.children[ch-'a'];
            if(node == null)
                return false;
            return searchHelper(word, index+1, node);
        }

    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */