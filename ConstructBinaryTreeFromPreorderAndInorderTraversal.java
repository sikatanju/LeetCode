import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree   (int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;
        if (preorder.length == 1)
            return new TreeNode(preorder[0]);

        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i=0; i<inorder.length; i++)
            inorderMap.put(inorder[i], i);

        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, inorderMap);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap)    {
        if (preStart > preEnd || inStart > inEnd)
            return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = buildTree(preorder, preStart+1, preStart + numsLeft, inorder, inStart, inRoot-1, inMap);
        root.right= buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot+1, inEnd, inMap);

        return root;
    }
}


/*public TreeNode buildTree(int[] preorder, int[] inorder) {
    Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();

    for(int i = 0; i < inorder.length; i++) {
        inMap.put(inorder[i], i);
    }

    TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
    return root;
}

public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
    if(preStart > preEnd || inStart > inEnd) return null;

    TreeNode root = new TreeNode(preorder[preStart]);
    int inRoot = inMap.get(root.val);
    int numsLeft = inRoot - inStart;

    root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, inMap);
    root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);

    return root;
}

 */
