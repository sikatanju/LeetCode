import java.util.ArrayList;
import java.util.List;

public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root)  {
        if (root == null || (root.left == null && root.right == null))
            return;

        List<TreeNode> listRoot = new ArrayList<>();
        preTraversal(root, listRoot);

        root = null;
        root = listRoot.get(0);
        root.left = null;
        root.right = null;
        TreeNode end = root;

        for (int i=1; i<listRoot.size(); i++)   {
            TreeNode temp = listRoot.get(i);
            temp.left = null;
            temp.right = null;
            end.left = null;
            end.right = temp;
            end = end.right;
        }
        return;
    }

    private void preTraversal(TreeNode root, List<TreeNode> listRoot) {
        if (root == null)
            return;

        listRoot.add(root);
        preTraversal(root.left, listRoot);
        preTraversal(root.right, listRoot);
    }
}


/*
        if (root == null || (root.left == null && root.right == null))
            return;

        TreeNode listRoot = new TreeNode();
        preTraversal(root, listRoot);
        root = listRoot.right;
        return;
    }

    private void preTraversal(TreeNode root, TreeNode listRoot) {
        if (root == null)
            return;

        TreeNode temp = new TreeNode(root.val);
        if (listRoot != null && listRoot.right != null)   {
            while (listRoot.right != null)
                listRoot = listRoot.right;

            listRoot.right = temp;
        }
        else if (listRoot == null)
            listRoot = temp;
        else
            listRoot.right = temp;

        preTraversal(root.left, listRoot.right);
        preTraversal(root.right, listRoot.right);
    }

 */
