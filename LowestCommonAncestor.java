import com.sun.source.tree.Tree;

public class LowestCommonAncestor {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null)
            return root;

        return left != null ? left : right;
    }

//    private void traversePreorder(TreeNode root, TreeNode p, TreeNode q, int level) {
//        if (root == null)
//            return;
//
//        if (root == p)  {
//            foundP = true;
//            pLevel = level;
//        }
//        if (root == q)  {
//            foundQ = true;
//            qLevel = level;
//        }
//        traversePreorder(root.left, p, q, level+1);
//        traversePreorder(root.right, p, q, level+1);
//    }
}
