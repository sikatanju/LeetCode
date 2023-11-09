import java.util.ArrayList;
import java.util.List;
// import java.util.Stack;

public class JustForPractice {
    public void flatten(TreeNode root) {
        if (root == null)
            return;

        List<TreeNode> list = new ArrayList<>();
        preorderTraversal(root, list);

        root = null;
        root = list.get(0);
        root.left = null;
        TreeNode temp = root;

        for (TreeNode node : list)  {
            node.left = null;
            node.right = null;
            temp.right = node;
            temp = node;
        }
    }
    private void preorderTraversal (TreeNode root, List<TreeNode> list) {
        if (root == null)
            return;


        list.add(root);
        preorderTraversal(root.left, list);
        preorderTraversal(root.right, list);
    }
}
