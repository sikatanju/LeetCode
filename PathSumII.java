import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    private List<List<Integer>> returnList;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum)    {
        returnList = new ArrayList<>();

        allPathSum(root, targetSum, new ArrayList<Integer>());
        return returnList;
    }

    private void allPathSum(TreeNode root, int targetSum, List<Integer> currentPath) {
        if (root == null)
            return;

        currentPath.add(root.val);
        if (root.left == null && root.right == null && targetSum == root.val)
            returnList.add(new ArrayList<>(currentPath));

        else {
            allPathSum(root.left, targetSum - root.val, currentPath);
            allPathSum(root.right, targetSum - root.val, currentPath);
        }
        currentPath.remove(currentPath.size()-1);
    }
}

/* Oms solution...;


class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        int[] nodes = new int[depth(root)];
        helper(root, targetSum, nodes, 0);
        return res;
    }

    private void helper(TreeNode root, int targetSum, int[] nodes, int i) {
        if(root==null) {
            return;
        }
        nodes[i++]=root.val;
        if(root.left==null && root.right==null) {
            if(targetSum==root.val) {
                List<Integer> list = new ArrayList<>();
                for(int j=0;j<i;j++) {
                    list.add(nodes[j]);
                }
                res.add(list);
            }
            return;
        }
        helper(root.left, targetSum-root.val, nodes, i);
        helper(root.right, targetSum-root.val, nodes, i);
    }

    private int depth(TreeNode root) {
        if(root==null) {
            return 0;
        }
        return 1+Math.max(depth(root.left), depth(root.right));
    }
}

 */



/* -- My solution, wasn't accepted.

    List<List<Integer>> allPath;
    private TreeNode mainRoot;
    private int count;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum)    {
        this.allPath = new ArrayList<>();
        this.mainRoot = root;
        this.count = 0;

        checkPathSum(root, targetSum, new ArrayList<>(), 0, 0);
        return  allPath;
    }

    private void checkPathSum(TreeNode root, int targetSum, List<Integer> currentPath, int currentSum, int count) {
        if (root == null)
            return;


        currentSum += root.val;
        if (currentPath.size() > (count)) {
            currentPath.remove(count-1);
            count--;
        }

        if (root.left == null && root.right == null)
            if (currentSum != targetSum)
                return;

        currentPath.add(root.val);
        count++;
        if (currentSum == targetSum && root.right == null && root.left == null)    {
            allPath.add(currentPath);
            currentPath = new ArrayList<>();
        }

        checkPathSum(root.left, targetSum, currentPath, currentSum, count);

        if (root == this.mainRoot) {
            currentPath = new ArrayList<>();
            currentPath.add(root.val);
        }

        checkPathSum(root.right, targetSum, currentPath, currentSum, count);
    }
 */