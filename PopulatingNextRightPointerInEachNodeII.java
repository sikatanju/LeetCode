import java.util.HashMap;
import java.util.Map;

public class PopulatingNextRightPointerInEachNodeII {
    public TreeNode connect(TreeNode root)  {
        Map<Integer, TreeNode> map = new HashMap<>();
        connectNode(root, map, 1);
        return root;
    }

    private void connectNode(TreeNode root, Map<Integer,TreeNode> map, int i) {
        if (root == null)
            return;

        if (!map.containsKey(i))
            map.put(i, root);

        if (map.containsKey(i)) {
            if (map.get(i) != root)    {
                map.get(i).next = root;
                map.replace(i, root);
            }
        }

        connectNode(root.left, map, i+1);
        connectNode(root.right, map, i+1);
    }
}


/* 0ms solution :

class Solution {
    public Node connect(Node root) {
        Node curr = root;
        Node startPointer = new Node(-101);
        Node nextHead = startPointer;
        Node prev = nextHead;

        while(curr != null) {
            while(curr != null) {
                if(curr.left != null) {
                    prev.next = curr.left;
                    prev = prev.next;
                }
                if(curr.right != null) {
                    prev.next = curr.right;
                    prev = prev.next;
                }
                curr = curr.next;
            }
            curr = nextHead.next;
            nextHead.next = null;
            prev = nextHead;
        }
        return root;
    }
}
 */