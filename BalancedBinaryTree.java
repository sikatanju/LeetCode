public class BalancedBinaryTree {
    private int maxDiff;
    public boolean isBalanced(TreeNode root) {
        this.maxDiff = Integer.MIN_VALUE;
        dfs(root);
        return maxDiff <= 1;
    }

    private int dfs(TreeNode root)  {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null)
            return 1;

        int leftCount = dfs(root.left);
        int rightCount = dfs(root.right);

        int tempDiff = Math.abs(leftCount-rightCount);
        maxDiff = Math.max(maxDiff, tempDiff);
        return 1+Math.max(leftCount, rightCount);
    }
}

/*
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int left = height(root.left);
        int right = height(root.right);
        if(Math.abs(left-right) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public static int height(TreeNode root){
        if(root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left, right)+1;
    }
}
 */