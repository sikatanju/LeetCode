/*
public class removeNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null)  {
            head = null;
            return head;
        }
        if (head.next.next == null) {
            if (n==1)
                head.next = null;
            else
                head = head.next;
            
            return head;
        }
        
        int size = 1;
        ListNode copy = head;

        ListNode temp = new ListNode();
        ListNode last = temp;

        temp.val = copy.val;
        copy = copy.next;

        while (copy != null)    {
            size++;
            ListNode tt = new ListNode(copy.val);
            last.next = tt;
            last = tt;
            copy = copy.next;
        }
        size -= n;
        n = 1;
        if (size == 0)  {
            temp = temp.next;
            head.val = temp.val;
            head.next = null;
            last = head;
            temp = temp.next;
        }
        else    {
            head.next = null;
            last = head;
            temp = temp.next;
        }
        while (temp != null)    {
            if (n == size)  {
                temp = temp.next;
                n++;
                continue;
            }
            ListNode tt = new ListNode(temp.val);
            last.next = tt;
            last = tt;
            temp = temp.next;
            n++;
        }
        return head;   
    }
}

*/