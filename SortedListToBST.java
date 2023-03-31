import java.util.List;
import java.util.ArrayList;

public class SortedListToBST {
    public TreeNode sortedListToBST(ListNode head)  {

        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        TreeNode root =  sortIt(list, 0, list.size()-1);
        return root;
    }

    private TreeNode sortIt(List<Integer> list, int left, int right)    {
        if (left > right)
            return null;

        int middle = (left+right)/2;
        TreeNode node = new TreeNode(list.get(middle));
        node.left = sortIt(list, left, middle-1);
        node.right = sortIt(list, middle+1, right);
        return node;
    }
}
;