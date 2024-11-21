public class HouseRobberIII {
    public int rob(TreeNode root) {
        int[] ara = dfs(root);
        return Math.max(ara[0], ara[1]);
    }
    private int[] dfs(TreeNode root)    {
        if (root == null)
            return new int[2];

        var left = dfs(root.left);
        var right = dfs(root.right);
        int[] arr = new int[2];
        arr[0] = root.val + left[1] + right[1];
        arr[1] = Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        return arr;
    }
}
