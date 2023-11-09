import java.util.HashMap;
import java.util.Map;

public class ImplementTrie {
    private class Node {
        private char value;
        private Map<Character, Node> children;
        private boolean isEndOfWord;

        Node()  {
            this.children = new HashMap<>();
        }
        Node(char ch)  {
            this.children = new HashMap<>();
            this.value = ch;
        }
    }
    private Node root;

    public ImplementTrie() {
        this.root = new Node();
    }

    public void insert(String word) {
        Node temp = root;

        for (char ch: word.toCharArray()) {
            if (!temp.children.containsKey(ch))
                temp.children.put(ch, new Node(ch));

            temp = temp.children.get(ch);
        }
        temp.isEndOfWord = true;
    }

    public boolean search(String word) {
        // Node temp = root.children.get(word.charAt(0));
        Node temp = root;

        for (char ch : word.toCharArray())  {
            if (!temp.children.containsKey(ch))
                return false;

            temp = temp.children.get(ch);
        }
        if (temp.isEndOfWord)
            return true;
        else
            return false;
    }

    public boolean startsWith(String prefix) {
        Node temp = root;
        for (char ch : prefix.toCharArray())    {
            if (!temp.children.containsKey(ch))
                return false;

            temp = temp.children.get(ch);
        }
        return true;
    }
}
