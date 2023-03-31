public class ConvertSortedArrayToBST {
    private int[] ara;
    public TreeNode sortedArrayToBST(int[] nums) {
        this.ara = nums;
        return createNode(0, nums.length-1);
    }
    private TreeNode createNode(int left, int right)    {
        if (left > right)
            return null;

        int middle = (left+right) / 2;
        TreeNode node = new TreeNode(ara[middle]);
        node.left = createNode(left, middle-1);
        node.right = createNode(middle+1, right);
        return node;
    }
}
