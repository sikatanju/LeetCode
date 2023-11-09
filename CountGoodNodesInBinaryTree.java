public class CountGoodNodesInBinaryTree {
    private int count;
    private int max;

    public int goodNodes(TreeNode root) {
        if (root.left == null && root.right == null)
            return 1;

        count = 0;
        max = Integer.MIN_VALUE;
        traverse(root, max);
        return count;
    }

    private void traverse(TreeNode root, int maxValue)  {
        if (root == null)
            return;

        if (root.val >= maxValue)   {
            count++;
            maxValue = root.val;
        }
        traverse(root.left, maxValue);
        traverse(root.right, maxValue);
    }
}
