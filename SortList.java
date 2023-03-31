public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode prev = null, slow = head, fast = head;
        while (fast != null && fast.next != null)   {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        ListNode listOne = sortList(head);
        ListNode listTwo = sortList(slow);

        return merge(listOne, listTwo);
    }
    private ListNode merge (ListNode l1, ListNode l2)   {
        ListNode returnList = new ListNode(0), last = returnList;
        while (l1 != null && l2 != null)    {
            if (l1.val < l2.val)    {
                last.next = l1;
                l1 = l1.next;
            }
            else    {
                last.next = l2;
                l2 = l2.next;
            }
            last = last.next;
        }

        if (l1 != null)
            last.next = l1;

        if (l2 != null)
            last.next = l2;

        return returnList.next;
    }
}






/*
        if (head == null)
            return head;

        Map<Integer, ListNode> map = new HashMap<>();
        ArrayList<ListNode> linkedList = new ArrayList<>();
        ArrayList<Integer> araList = new ArrayList<>();
        while (head != null)    {
            if (map.containsKey(head.val))  {
                linkedList.add(head);
                head = head.next;
            }
            else    {
                map.put(head.val, head);
                araList.add(head.val);
                head = head.next;
            }
        }

        Collections.sort(araList);
        head = map.get(araList.get(0));
        ListNode last = head;
        for (int i=1; i<araList.size(); i++)    {
            last.next = map.get(araList.get(i));
            last = last.next;
        }
        last.next = null;
        return head;
 */