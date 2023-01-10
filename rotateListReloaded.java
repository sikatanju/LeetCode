public class rotateListReloaded {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;

        ListNode temp = head;
        int count = 0;
        while (temp != null)    {
            count++;
            temp = temp.next;
        }
        k %= count;
        for (int i=0; i<k; i++) {
            ListNode any = head;
            while (any.next.next != null)
                any = any.next;

            any.next.next = head;
            head = any.next;
            any.next = null;
        }
        return head;
    }
}


























/*
        if(head == null || k <= 0 || head.next == null)
            return head;

        ListNode temp = head;
        int count = 0;
        while(temp != null) {
            temp = temp.next;
            count++;
        }

        k = k % count;
        for(int i = 0;i<k;i++)  {
            ListNode curr = head;
            while(curr.next.next!=null)
                curr = curr.next;

            curr.next.next = head;
            head = curr.next;
            curr.next = null;
        }
        return head;

 */