class Solution {
    private TreeNode notRoot;
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        this.notRoot = root;
        return dfs(root, target);
    }

    private TreeNode dfs(TreeNode root, int target)    {
        if (root == null)
            return null;

        TreeNode left = dfs(root.left, target);
        TreeNode right = dfs(root.right, target);
        if (left != null && left.left == null && left.right == null && left.val == target)
            root.left = null;
        if (right != null && right.left == null && right.right == null && right.val == target)
            root.right = null;

        return root;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */