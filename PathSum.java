public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;

        return preorder(root, targetSum, 0);
    }
    private boolean preorder(TreeNode root, int targetSum, int sum) {
        if (root == null)
            return false;

        sum += root.val;
        if (root.right == null && root.left == null)    {
            if (targetSum == sum)
                return true;
        }
        return (preorder(root.left, targetSum, sum) || preorder(root.right, targetSum, sum));
    }
}
