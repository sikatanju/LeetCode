import com.sun.source.tree.Tree;

public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null)
            return subRoot == null;

        if (dfs(root, subRoot))
            return dfs(root, subRoot);

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    private boolean dfs(TreeNode root, TreeNode subroot) {
        if (root == null && subroot == null)
            return true;
        if (root == null || subroot == null)
            return false;

        return root.val == subroot.val && dfs(root.left, subroot.left) && dfs(root.right, subroot.right);
    }
}
