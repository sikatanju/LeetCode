import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AverageOfLevelsInBinaryTree {
    Map<Integer, Long> mapOfSum;
    Map<Integer, Integer> mapOfNum;
    public List<Double> averageOfLevels(TreeNode root) {
        mapOfSum = new HashMap<>();
        mapOfNum = new HashMap<>();
        List<Double> list = new ArrayList<>();
        averageOfLevels(root, 0);
        int i=0;
        while (true)    {
            if (!mapOfSum.containsKey(i))
                break;

            double sum = mapOfSum.get(i);
            double num = mapOfNum.get(i++);
            list.add(sum/num);
        }
        return list;
    }

    private void averageOfLevels(TreeNode root, int level) {
        if (root == null)
            return;

        if (!mapOfSum.containsKey(level))   {
            mapOfSum.put(level, (long)root.val);
            mapOfNum.put(level, 1);
        }   else {
            mapOfSum.replace(level, mapOfSum.get(level)+root.val);
            mapOfNum.replace(level, mapOfNum.get(level)+1);
        }
        averageOfLevels(root.left, level+1);
        averageOfLevels(root.right, level+1);
    }
}


/* Best runtime : 1ms :

class Solution {
    // BFS
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<Double>();
        if (root == null) {
            return res;
        }
        // BFS
        List<TreeNode> q = new ArrayList<TreeNode>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            double sum = 0.0;
            for (int i = 0; i < size; i++) {
                TreeNode t = q.get(i);
                sum += t.val;
                if (t.left != null) {
                    q.add(t.left);
                }
                if (t.right != null) {
                    q.add(t.right);
                }
            }
            for (int i = 0; i < size; i++) {
                q.remove(0);
            }
            res.add(sum / size);
        }
        return res;
        // BFS finish :)


        // DFS
        List<Integer> nodeNum = new ArrayList<Integer>();
        dfs(root, 0, res, nodeNum);
        for (int i = 0; i < res.size(); i++) {
            res.set(i, res.get(i) / nodeNum.get(i));
        }
        return res;
    }

    public void dfs(TreeNode root, int level, List<Double> res, List<Integer> nodeNum) {
        if (root == null) {
            return;
        }
        // reach level i first time, add the number
        if (level == res.size()) {
            res.add(root.val + 0.0);
            nodeNum.add(1);
        } else {
            res.set(level, res.get(level) + root.val);
            nodeNum.set(level, nodeNum.get(level) + 1);
        }

        dfs(root.left, level + 1, res, nodeNum);
        dfs(root.right, level + 1, res, nodeNum);
    }
}
*/

// ############## 2ms runtime :

/*
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if(root==null)
        {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty())
        {
            double avg =0.0;
            int levelsz = q.size();
            for(int i=0;i<levelsz;i++)
            {
                TreeNode currNode = q.poll();
                avg+=currNode.val;
                if(currNode.left!=null)
                {
                    q.offer(currNode.left);
                }
                if(currNode.right!=null)
                {
                    q.offer(currNode.right);
                }
            }
            avg=avg/levelsz;
            res.add(avg);
        }
        return res;
    }
}
*/