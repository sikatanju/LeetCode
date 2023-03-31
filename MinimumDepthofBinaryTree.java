public class MinimumDepthofBinaryTree {
    private int depth;
    private boolean check;
    MinimumDepthofBinaryTree () {
        this.depth = Integer.MAX_VALUE;
        check = false;
    }
    public int minDepth (TreeNode root) {
        minDepth(root, 0);
        if (this.depth == 0 && check)
            return 1;
        else if (this.depth == 0)
            return 0;
        else
            return this.depth + 1;
    }
    private void minDepth(TreeNode root, int distance) {
        if (root == null)
            return;

        if (root.left == null && root.right == null && distance < this.depth)    {
            this.depth = distance;
            check = true;
        }
        minDepth(root.left, distance+1);
        minDepth(root.right, distance+1);
    }
}
