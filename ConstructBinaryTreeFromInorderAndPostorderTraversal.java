import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inorderIndex = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<inorder.length; i++)    {
            stack.push(postorder[i]);
            inorderIndex.put(inorder[i], i);
        }

        return buildTree(0, inorder.length-1, inorderIndex, stack);
    }
    private TreeNode buildTree (int left, int right, Map<Integer, Integer> map, Stack<Integer> stack)  {
        if (left > right)
            return null;

        var root = new TreeNode(stack.pop());
        var idx = map.get(root.val);
        root.right = buildTree(idx+1, right, map, stack);
        root.left = buildTree(left, idx-1, map, stack);
        return root;
    }
}

/*  ######### 0ms runtime :

class Solution {
    int [] inorder;
    int[] postorder;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        return helper(postorder.length -1 , 0, inorder.length -1);
    }

    private TreeNode helper(int preEnd , int start , int end){
        if(preEnd < 0 || start > end)
            return null;

        TreeNode root = new TreeNode(postorder[preEnd]);

        int index = end;
        for(int i = end ; i >= start ; i --)    {
            if(root.val == inorder[i])  {
                index = i;
                break;
            }
        }
        root.right = helper(preEnd - 1, index + 1 , end);
        root.left = helper(preEnd - (end - index) - 1, start , index -1);
        return root;
    }
}





####################### 1ms runtime :

class Solution {
    int index;
    Map<Integer, Integer> inorderMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index = inorder.length-1;
        inorderMap = new HashMap<>();
        for(int i=0;i<=index;i++)
            inorderMap.put(inorder[i], i);

        return buildTree(inorder, postorder, 0, index);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder, int start, int end) {
        if(start > end) return null;

        int nodeVal = postorder[index--];
        int inorderNodeIndex = inorderMap.get(nodeVal);

        TreeNode root = new TreeNode(nodeVal);
        root.right = buildTree(inorder, postorder, inorderNodeIndex+1, end);
        root.left = buildTree(inorder, postorder, start, inorderNodeIndex-1);
        return root;
    }
}

*/
