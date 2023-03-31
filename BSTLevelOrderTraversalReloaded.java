import java.util.List;
import java.util.ArrayList;

public class BSTLevelOrderTraversalReloaded {
    public List<List<Integer>> levelOrder (TreeNode root)   {
        List<List<Integer>> returnList = new ArrayList<>();
        levelOrder(root, 0, returnList);
        return returnList;
    }

    private void levelOrder(TreeNode root, int distance, List<List<Integer>> returnList)    {
        if (root == null)
            return;

        distance++;
        if (returnList.size() < distance)   {
            List<Integer> tempList = new ArrayList<>();
            returnList.add(tempList);
        }
        returnList.get(distance-1).add(root.val);

        levelOrder(root.left, distance, returnList);
        levelOrder(root.right, distance, returnList);
    }
}
