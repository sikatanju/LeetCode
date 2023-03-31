import java.util.ArrayList;
import java.util.List;

public class BSTLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom (TreeNode root)  {
        List<List<Integer>> returnList = new ArrayList<>();
        List<List<Integer>> returnListII = new ArrayList<>();
        levelOrderBottom(root, 0, returnList);
        for (int i=returnList.size()-1; i>=0; i--)  {
            returnListII.add(returnList.get(i));
        }
        return returnListII;
    }
    private void levelOrderBottom(TreeNode root, int depth, List<List<Integer>> returnList) {
        if (root == null)
            return;

        depth++;
        if (returnList.size() < depth)  {
            List<Integer> tempList = new ArrayList<>();
            returnList.add(tempList);
        }
        returnList.get(depth-1).add(root.val);

        levelOrderBottom(root.left, depth, returnList);
        levelOrderBottom(root.right, depth, returnList);
    }
}
