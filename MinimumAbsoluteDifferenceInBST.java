import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class MinimumAbsoluteDifferenceInBST {

    public int getMinimumDifference(TreeNode root) {
        Set<Integer> set = new HashSet<>();
        PriorityQueue<Integer> priorityQueue= new PriorityQueue<>();
        difference(root, set, priorityQueue);

        int min = Integer.MAX_VALUE, temp = priorityQueue.poll();
        while (!priorityQueue.isEmpty())    {
            int temp2 = priorityQueue.poll();
            min = Math.min(Math.abs(temp-temp2), min);
            temp = temp2;
        }

        return min;
    }

    private void difference(TreeNode root, Set<Integer> set, PriorityQueue<Integer> priorityQueue)    {
        if (root == null)
            return;

        int temp = root.val;
        if (!set.contains(temp))    {
            set.add(temp);
            priorityQueue.add(root.val);
        }
        difference(root.left, set, priorityQueue);
        difference(root.right, set, priorityQueue);
    }
}


/* runtime: 0ms..

class Solution {
    private int minDiff = Integer.MAX_VALUE;
    private TreeNode prevNode;

    public int getMinimumDifference(TreeNode root) {
        inOrderTraversal(root);
        return minDiff;
    }

    private void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        // In-order traversal
        inOrderTraversal(node.left);

        // Calculate and update the minimum absolute difference
        if (prevNode != null) {
            minDiff = Math.min(minDiff, Math.abs(node.val - prevNode.val));
        }

        // Update the previous node
        prevNode = node;

        // Continue the in-order traversal
        inOrderTraversal(node.right);
    }
}
 */