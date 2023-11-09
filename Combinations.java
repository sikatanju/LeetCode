import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        combine(1, n, k, new ArrayList<>(), list);
        return list;
    }

    private void combine(int i, int n, int k, List<Integer> tempList, List<List<Integer>> list) {
        if (tempList.size() == k)   {
            list.add(new ArrayList<>(tempList));
            return;
        }
        if (i > n || tempList.size() > k)
            return;

        tempList.add(i);
        combine(i+1, n, k, tempList, list);
        tempList.remove(tempList.size()-1);
        combine(i+1, n, k, tempList, list);
    }
}



// <-.#.time:2023.10.3 #.0371 (1)
// 0ms runtime :
class Solution1 {
    private List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        return new AbstractList<List<Integer>>() {
            @Override
            public int size() {
                init();
                return res.size();
            }
            @Override
            public List<Integer> get(int index) {
                init();
                return res.get(index);
            }
            protected void init() {
                if (res != null)
                    return ;
                res = new ArrayList<List<Integer>>();
                dfsHelper(-1, n, k, res, new ArrayList<Integer>());
            }
        };
    }
    private void dfsHelper(int parentDepth, int n, int k, List<List<Integer>> res, List<Integer> subset) {
        parentDepth += 1;
        if (parentDepth == n) {
            if (subset.size() == k) {
                res.add(new ArrayList<Integer>(subset));
            }
        } else {
            /* <-.前序决策左、右子结点: */
//          Preorder decision making for left and right child nodes
            dfsHelper(parentDepth, n, k, res, subset);

            subset.add(parentDepth + 1);
            dfsHelper(parentDepth, n, k, res, subset);
            subset.remove(subset.size() - 1);
        }
    }
}

/*
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        combine(1, n, k, new ArrayList<>(), list);
        return list;
    }

    private void combine(int i, int n, int k, List<Integer> tempList, List<List<Integer>> list) {
        if (tempList.size() == k)   {
            list.add(new ArrayList<>(tempList));
            return;
        }
        if (i > n || tempList.size() > k)
            return;

        tempList.add(i);
        combine(i+1, n, k, tempList, list);
        tempList.remove(tempList.size()-1);
        combine(i+1, n, k, tempList, list);
    }
*/
// 6ms runtime :
class Solution2 {
    private List<List<Integer>> list = new ArrayList<List<Integer>>();
    private List<Integer> stack;

    public List<List<Integer>> combine(int n, int k) {
        this.stack = new ArrayList<Integer>(k);
        for(var i = 0; i < k; i++) this.stack.add(0);
        backtrack(1, 0, n, k - 1);
        return list;
    }

    public void backtrack(int p0, int p1, int n, int k) {
        while (p0 <= n - k + p1) {
            stack.set(p1, p0);
            if (p1 == k) {
                list.add(new ArrayList<>(stack));
            }
            else backtrack(p0 + 1, p1 + 1, n, k);
            p0++;
        }
    }
}
