public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;

        if (left == null || right == null || left.val != right.val)
            return false;

        return (isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left));
    }
}
