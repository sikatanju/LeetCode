public class BinaryTreeMaximumPathSum {
    private int result;
    public int maxPathSum(TreeNode root) {
        result = root.val;
        dfs(root);
        return result;
    }

    private int dfs(TreeNode root) {
        if (root == null)
            return 0;

        int leftMax = dfs(root.left);
        int rightMax = dfs(root.right);
        leftMax = Math.max(0, leftMax);
        rightMax = Math.max(0, rightMax);

        result = Math.max(result, root.val+leftMax+rightMax);

        return root.val + Math.max(leftMax, rightMax);
    }
}
