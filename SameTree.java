public class SameTree   {
    public boolean isSameTree (TreeNode first, TreeNode second) {
        if (first == null && second == null)
            return true;

        if (first != null && second != null)
            return first.val == second.val
                    && isSameTree(first.left, second.left)
                    && isSameTree(first.right, second.right);

        return false;
    }
}