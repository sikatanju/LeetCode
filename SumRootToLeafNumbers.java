public class SumRootToLeafNumbers {
    private int totalSum;
    public int sumNumbers(TreeNode root) {
        this.totalSum = 0;
        sumRootToLeafNumbers(root, 0);
        return totalSum;
    }

    private void sumRootToLeafNumbers(TreeNode root, int i) {
        if (root == null)
            return;

        if (root.left == null && root.right == null)    {
            i += root.val;
            totalSum += i;
            return;
        }

        i += root.val;
        sumRootToLeafNumbers(root.left, i*10);
        sumRootToLeafNumbers(root.right, i*10);
    }
}
