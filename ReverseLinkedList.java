// Difficulty : Easy

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head)  {
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
