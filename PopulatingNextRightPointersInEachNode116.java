//import java.util.ArrayDeque;
//import java.util.Queue;

public class PopulatingNextRightPointersInEachNode116 {
/*
    class Node {
        public int val;
        public Solution.Node left;
        public Solution.Node right;
        public Solution.Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Solution.Node _left, Solution.Node _right, Solution.Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
    class Pair {
        Solution.Node node;
        int level;

        Pair(Solution.Node node, int level)  {
            this.node = node;
            this.level = level;
        }
    }

    public Solution.Node connect(Solution.Node root) {
        if (root == null)
            return null;

        int level = 0;
        Solution.Pair temp = new Solution.Pair(root, level++);
        Queue<Solution.Pair> queue = new ArrayDeque<>();
        queue.add(new Solution.Pair(root, 0));
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i=0; i<n; i++)  {
                Solution.Pair pair = queue.poll();
                if (temp.node != root && temp.level == pair.level)
                    temp.node.next = pair.node;

                temp = pair;
                if (pair.node.left != null)
                    queue.add(new Solution.Pair(pair.node.left, level));
                if (pair.node.right != null)
                    queue.add(new Solution.Pair(pair.node.right, level));
            }
            level++;
        }
        return root;
    }
*/
}

/* Best runtime: 0ms:
class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Node prev = root;

        while (prev.left != null) {
            Node first = prev.left;
            first.next = prev.right;
            Node cur = first.next;

            while (prev.next != null) {
                prev = prev.next;
                cur.next = prev.left;
                cur.next.next = prev.right;
                cur = cur.next.next;
            }
            prev = first;
        }

        return root;
    }
}
*/
