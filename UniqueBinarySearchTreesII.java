import com.sun.source.tree.Tree;

import java.util.List;
import java.util.ArrayList;

public class UniqueBinarySearchTreesII  {
    public List<TreeNode> generateTrees(int n) {
        return generateBinarySearchTrees(1, n);
    }

    private List<TreeNode> generateBinarySearchTrees(int low, int high)    {
        List<TreeNode> res = new ArrayList<>();
        if (low > high) {
            res.add(null);
            return res;
        }
        for (int i=low; i<=high; i++)   {
            var leftSubTrees = generateBinarySearchTrees(low, i-1);
            var rightSubTrees = generateBinarySearchTrees(i+1, high);
            for (var leftTree: leftSubTrees)    {
                for (var rightTree: rightSubTrees)  {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
