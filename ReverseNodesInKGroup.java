public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        int len = 0;
        ListNode temp = head, tail = head;
        while (temp != null)    {
            len++;
            temp = temp.next;
        }
        temp = head;
        boolean check = false;
        while (len > 0 && k <= len)  {
            var reverse = temp;
            int tempK = k;
            while (tempK-- > 0)
                temp = temp.next;

            ListNode tempNode = reverseList(reverse, k);
            var tempNode2 = tempNode;
            while (tempNode2.next != null)
                tempNode2 = tempNode2.next;

            tempNode2.next = temp;
            if (!check) {
                head = tempNode;
                tail = head;
                tempK = k;
                while (tempK-- > 1)
                    tail = tail.next;

                tail.next = null;
                check = true;
            }
            else    {
                while (tail.next != null)
                    tail = tail.next;

                tail.next = tempNode;
                tempK = k;
                while (tempK-- > 0)
                    tail = tail.next;

                tail.next = null;
            }
            len -= k;
        }
        if (temp != null)
            tail.next = temp;

        return head;
    }
    private ListNode reverseList (ListNode head, int k) {
        ListNode temp = head.next;
        head.next = null;
        while (k-- > 1)   {
            ListNode tempNode = temp;
            temp = temp.next;
            tempNode.next = null;
            tempNode.next = head;

            head = tempNode;
        }
        return head;
    }
}
