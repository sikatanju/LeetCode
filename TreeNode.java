public class TreeNode {
    int val;

    TreeNode left;
    TreeNode right;
    TreeNode next;

    TreeNode() {}

    TreeNode(int val) { this.val = val; }

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