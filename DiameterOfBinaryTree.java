public class DiameterOfBinaryTree {
    private int maxLen;
    public int diameterOfBinaryTree(TreeNode root) {
        this.maxLen = Integer.MIN_VALUE;
        dfs(root);
        return maxLen == Integer.MIN_VALUE ? 0: maxLen;
    }
    private int dfs(TreeNode root)  {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;

        int leftCount = dfs(root.left);
        int rightCount = dfs(root.right);
        maxLen = Math.max(maxLen, leftCount+rightCount);
        return 1+Math.max(leftCount, rightCount);
    }
}
