public class PathSumIII {
    private int pathCount;
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return 0;

        pathCount = 0;
        int depth = maxDepth(root, 0);

        for (int i=0; i<=depth; i++)
            pathSum(root, targetSum, 0, 0, i);

        return pathCount;
    }

    private void pathSum(TreeNode root, int targetSum, long sum,  int currentLevel, int levelCheck)   {
        if (root == null)
            return;

        if (currentLevel >= levelCheck)
            sum += root.val;

        if (sum == targetSum)
            if (currentLevel >= levelCheck)
                this.pathCount++;

        pathSum(root.left, targetSum, sum, currentLevel+1, levelCheck);
        pathSum(root.right, targetSum, sum, currentLevel+1, levelCheck);
    }

    private int maxDepth(TreeNode root, int count)  {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null)
            return 0;

        return 1+Math.max(maxDepth(root.left, count+1), maxDepth(root.right, count+1));
    }
}


/* 2ms runtime solution :

class Solution {
    public int pathSum(TreeNode root, int targetSum){
        HashMap<Long, Integer> prePathSum = new HashMap<>();
        prePathSum.put(0l, 1);
        return recurse(root, targetSum, 0, prePathSum);
    }

    private int recurse(TreeNode root, int targetSum, long currentSum, HashMap<Long, Integer> prePathSum){
        if (root == null){
            return 0;
        }
        currentSum += root.val;

        int res = prePathSum.getOrDefault(currentSum - targetSum, 0);
        prePathSum.put(currentSum, prePathSum.getOrDefault(currentSum, 0) + 1);
        int left = recurse(root.left, targetSum, currentSum, prePathSum);
        int right = recurse(root.right, targetSum, currentSum, prePathSum);

        prePathSum.put(currentSum, prePathSum.getOrDefault(currentSum, 0) - 1);
        return res + left + right;
    }
}

##############  3ms runtime solution :

class Solution {

    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> countMap = new HashMap<>();
        return traverse(root, countMap, 0, targetSum);
    }

    private int traverse(TreeNode root, Map<Long, Integer> countMap, long sum, int target) {
        if(root == null) return 0;

        sum += root.val;

        int count = 0;
        if(sum == target) count++;

        count += countMap.getOrDefault(sum - target, 0);

        countMap.put(sum, countMap.getOrDefault(sum, 0) + 1);

        count += traverse(root.left, countMap, sum, target);
        count += traverse(root.right, countMap, sum, target);

        countMap.put(sum, countMap.get(sum) - 1);

        return count;
    }
}
*/

