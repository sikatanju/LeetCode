import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.LinkedList;

public class BSTZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        LinkedList<LinkedList<Integer>> linkedList = new LinkedList<>();
        zigzagLevelOrder (root, 0, linkedList);
        List<List<Integer>> returnList = new LinkedList<>(linkedList);
        return returnList;
    }
    private void zigzagLevelOrder (TreeNode root, int depth, LinkedList<LinkedList<Integer>> returnList)   {
        if (root == null)
            return;

        depth++;
        if (returnList.size() < depth)  {
            LinkedList<Integer> tempList = new LinkedList<>();
            returnList.add(tempList);
        }
        if ((depth-1) == 0)
            returnList.get(depth-1).add(root.val);
        else if ((depth-1) % 2 != 0)
            returnList.get(depth-1).addLast(root.val);
        else
            returnList.get(depth-1).addFirst(root.val);

        zigzagLevelOrder(root.left, depth, returnList);
        zigzagLevelOrder(root.right, depth, returnList);
    }
}
