import java.util.List;
import java.util.ArrayList;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder (TreeNode root)   {
        List<List<Integer>> returnList = new ArrayList<>();
        int depth = findDepth(root);

        for (int i=0; i<depth; i++) {
            List<Integer> tempList = new ArrayList<>();
            levelOrderTraversal(tempList, root, i);
            returnList.add(tempList);
        }

        return returnList;
    }
    private int findDepth (TreeNode root)   {
        if (root == null)
            return 0;

        return 1 + Math.max(findDepth(root.left), findDepth(root.right));
    }
    private void levelOrderTraversal (List<Integer> tempList, TreeNode root, int distance) {
        if (root == null)
            return;

        if (distance == 0)  {
            tempList.add(root.val);
            return;
        }

        levelOrderTraversal(tempList, root.left, distance-1);
        levelOrderTraversal(tempList, root.right, distance-1);
    }
}
