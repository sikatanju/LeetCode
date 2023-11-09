public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null && head.next == null)
            return head;

        ListNode tail = head;
        ListNode newHead = head.next;
        ListNode newTail = newHead;

        while (tail != null && newTail != null)    {
            if (newTail != null)    {
                if (newTail.next == null)
                    break;

                tail.next = newTail.next;
                tail = tail.next;
            }
            if (tail != null)   {
                newTail.next = tail.next;
                newTail = newTail.next;
            }
        }

        tail.next = newHead;
        return head;
    }
}
