import java.util.List;

public class TreeNode {
    int val;

    TreeNode left;
    TreeNode right;
    TreeNode next;
    List<TreeNode> childList;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
        this.right = null;
        this.left = null;
        this.childList = null;
    }

    TreeNode(int val, TreeNode left, TreeNode right, TreeNode next) {
        this.val = val;
        this.right = right;
        this.next = next;
    }

    @Override
    public String toString() {
        return "" + val;
    }
}