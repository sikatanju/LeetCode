public class KthSmallestElementInABST {
    private int count;
    private int returnValue;
    public int kthSmallest(TreeNode root, int k) {
        this.count = 0;
        this.returnValue = 0;
        findKthSmallest(root, k);
        return returnValue;
    }

    private void findKthSmallest(TreeNode root, int k) {
        if (root == null)
            return;

        findKthSmallest(root.left, k);
        count++;
        if (count == k) {
            returnValue = root.val;
            return;
        }
        findKthSmallest(root.right, k);
    }
}
