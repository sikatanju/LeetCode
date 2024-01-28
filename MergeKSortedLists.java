import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        Map<Integer, List<ListNode>> map = new HashMap<>();
        for (var temp: lists)   {
            while (temp != null)    {
                int val = temp.val;
                if (!map.containsKey(val))   {
                    heap.add(val);
                    map.put(val, new ArrayList<>());
                    map.get(val).add(temp);
                }
                else    {
                    map.get(val).add(temp);
                }
                temp = temp.next;
            }
        }
        ListNode head = null;
        ListNode tail = null;
        while (!heap.isEmpty()) {
            int val = heap.poll();
            for (var temp: map.get(val))    {
                if (head == null)   {
                    head = temp;
                    head.next = null;
                    tail = head;
                }   else {
                    tail.next = temp;
                    tail = tail.next;
                }
            }
        }
        return head;
    }
}

/* 2ms runtime :
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeKListsHelper(lists, 0, lists.length - 1);
    }

    private ListNode mergeKListsHelper(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        if (start + 1 == end) {
            return merge(lists[start], lists[end]);
        }
        int mid = start + (end - start) / 2;
        ListNode left = mergeKListsHelper(lists, start, mid);
        ListNode right = mergeKListsHelper(lists, mid + 1, end);
        return merge(left, right);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
}
*/
