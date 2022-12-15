/*
public class deleteTheMiddleNode {
    public ListNode deleteMiddle (ListNode head)    {
        if (head == null)
            return head;

        ListNode dummy = new ListNode(-1, head);
        int i = 0;
        while (head != null)    {
            i++;
            head = head.next;
        }
        head = dummy;
        i = i / 2;
        int j = 0;
        while (j <= i)    {
            if (j++ == i)
                dummy.next = dummy.next.next;

            dummy = dummy.next;
        }
        return head.next;
    }
}
*/