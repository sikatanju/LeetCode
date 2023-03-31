public class ValidateBST {
    public boolean isValidBST (TreeNode root)   {
        return validateBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private boolean validateBST(TreeNode node, int min, int max)    {
        if (node == null)
            return true;

        if (node.val < min || node.val > max)
            return false;

        if (node.val == Integer.MIN_VALUE)
            if (node.left != null)
                return false;

        if (node.val == Integer.MAX_VALUE)
            if(node.right != null)
                return false;

        return validateBST(node.left, min, node.val - 1) && validateBST(node.right, node.val + 1, max);
    }
}
