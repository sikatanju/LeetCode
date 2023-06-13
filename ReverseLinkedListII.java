public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right)  {
        if (left == right || head.next == null)
            return head;

        ListNode iterate = head;
        ListNode start = null;
        ListNode end = null;
        ListNode reverse = null;
        ListNode reverseEnd = null;
        int i=0;
        while (i++ <= right)    {
            if (iterate == null)
                break;

            if (i+1 == left)
                start = iterate;

            if (i >= left && i <= right)    {
                if (reverse == null)    {
                    reverseEnd = iterate;
                    reverse = reverseEnd;
                }
                else {
                    reverseEnd.next = iterate;
                    reverseEnd = reverseEnd.next;
                }
            }
            iterate = iterate.next;
        }
        if (reverseEnd.next != null)    {
            end = reverseEnd.next;
            reverseEnd.next = null;
        }

        reverseEnd = reverse;
        reverse = reverseList(reverse);
        reverseEnd.next = end;
        if (start != null)  {
            start.next = reverse;
            return head;
        }
        else
            return reverse;
    }
    private ListNode reverseList(ListNode head)  {
        if (head == null || head.next == null)
            return head;

        ListNode temp = head.next;
        head.next = null;

        while (temp != null)    {
            ListNode insert = temp;
            temp = temp.next;
            insert.next = null;
            insert.next = head;
            head = insert;
        }
        return head;
    }
}
