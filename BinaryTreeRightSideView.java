import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BinaryTreeRightSideView {
    private Set<Integer> set;
    private List<Integer> list;
    public List<Integer> rightSideView(TreeNode root) {
        set = new HashSet<>();
        list = new ArrayList<>();

        addNode(root, 1);
        return null;
    }

    private void addNode(TreeNode root, int level) {
        if (root == null)
            return;

        if (!set.contains(level))   {
            list.add(root.val);
            set.add(level);
        }
        addNode(root.right, level+1);
        addNode(root.left, level+1);
    }
}

/* 0ms Runtime Solution :

class Solution {
    private void revPreorder(TreeNode root, int level, List<Integer> ans){
        if(root == null) return;

        if(ans.size() == level) ans.add(root.val);

        revPreorder(root.right, level+1, ans);
        revPreorder(root.left, level+1, ans);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        revPreorder(root, 0, ans);
        return ans;
    }
}

*/
