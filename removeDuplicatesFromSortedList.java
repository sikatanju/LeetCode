public class removeDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;

        ListNode newHead = new ListNode(head.val);
        ListNode last = newHead;
        head = head.next;

        while (head != null)   {
            if (head.val != last.val)    {
                last.next = head;
                last = head;
            }
            head = head.next;
        }
        last.next = null;
        return newHead;
    }
}

