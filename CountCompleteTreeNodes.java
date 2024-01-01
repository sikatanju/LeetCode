import com.sun.source.tree.Tree;

public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        int leftSubTreeHeight = leftDepth(root);
        int rightSubTreeHeight = rightDepth(root);

        if (leftSubTreeHeight == rightSubTreeHeight)    {
            return (int) Math.pow(2, leftSubTreeHeight)-1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int leftDepth (TreeNode node)   {
        int depth = 0;
        while (node != null)    {
            node = node.left;
            depth++;
        }
        return depth;
    }
    private int rightDepth (TreeNode node) {
        int depth = 0;
        while (node != null)   {
            node = node.right;
            depth++;
        }
        return depth;
    }
}

/* Another approach :
class Solution {
    //main function
    public int countNodes(TreeNode root) {

        int left=leftDepth(root);
        int right=rightDepth(root);

        //if both the leftmost and right most depth are equal that means
		//its perfect tree so no. of nodes would be 2^h-1
        if(left==right){
            return (int)Math.pow(2,left)-1;
        }
        //otherwise it will call count function for left and right subtrees
		//and add 1 for root node
        return 1+countNodes(root.left)+countNodes(root.right);
    }

    //function to find depth of tree on left side
    int leftDepth(TreeNode node){
        int depth=0;
        while(node!=null){
            node=node.left;
            depth++;
        }
        return depth;
    }

    //function to find depth of tree on right side
    int rightDepth(TreeNode node){
        int depth=0;
        while(node!=null){
            node=node.right;
            depth++;
        }
        return depth;
    }
}
 */
/* ########### Best runtime : 0ms :


        if (root == null)
            return 0;

        int leftSide = leftHeight(root.left);
        int rightSide = leftHeight(root.right);
        if (leftSide == rightSide)
            return countNodes(root.right) + (1<<leftSide);

        return countNodes(root.left) + (1<<rightSide);
    }

    private int leftHeight(TreeNode node) {
        int height = 0;
        while (node != null)   {
            height++;
            node = node.left;
        }
        return height;
    }
 */