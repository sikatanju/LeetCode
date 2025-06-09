public class InsertIntoABinarySearchTree701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        insert(root, val);
        return root == null ? new TreeNode(val): root;
    }
    private void insert(TreeNode root, int val) {
        if (root == null)
            return;

        if (val > root.val)   {
            if (root.right == null) {
                root.right = new TreeNode(val);
                return;
            }   else    {
                insert(root.right, val);
            }
        }
        else    {
            if (root.left == null)  {
                root.left = new TreeNode(val);
                return;
            }   else    {
                insert(root.left, val);
            }
        }
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