/*public class swapNodeInPairs {
    public ListNode swapPairs(ListNode head)    {
        if (head == null || head.next == null)
            return head;

        ListNode returnNode = new ListNode(0);
        returnNode.next = head;
        ListNode swap = returnNode;

        while (swap.next != null && swap.next.next != null) {
            ListNode second = swap.next.next;
            ListNode first = swap.next;

            first.next = second.next;
            swap.next = second;
            second.next = first;

            swap = first;
        }

        return returnNode.next;
    }
}
*/