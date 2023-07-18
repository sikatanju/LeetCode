public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null)
            return head;

        ListNode lessNode = null;
        ListNode lessTail = lessNode;
        ListNode givenTail = head;

        while (givenTail != null)   {
            if (givenTail == head && givenTail.val < x)   {
                if (lessNode == null)    {
                    lessNode = head;
                    lessTail = lessNode;
                }
                else {
                    lessTail.next = head;
                    lessTail = lessTail.next;
                }
                head = head.next;
                givenTail = head;
                lessTail.next = null;
                continue;
            }
            if (givenTail.next != null && givenTail.next.val < x)   {
                if (lessNode == null)   {
                    lessNode = givenTail.next;
                    lessTail = lessNode;
                }
                else {
                    lessTail.next = givenTail.next;
                    lessTail = lessTail.next;
                }
                givenTail.next = givenTail.next.next;
                lessTail.next = null;
                continue;
            }
            givenTail = givenTail.next;
        }
        if (lessTail != null)   {
            lessTail.next = head;
            return lessNode;
        }
        return head;
    }
}
