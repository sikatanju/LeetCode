import java.util.List;
import java.util.ArrayList;

public class BinaryTreeInorderTraversal {
    List<Integer> returnNodes = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null)
            return returnNodes;

        inorderTraversal(root.left);
        returnNodes.add(root.val);
        return inorderTraversal(root.right);
    }
}



