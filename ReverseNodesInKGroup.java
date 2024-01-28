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
            reverse.next = temp;
            if (!check) {
                head = tempNode;
                reverse.next = null;
                tail = reverse;
                check = true;
            }
            else    {
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


/* My last solution :

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
 */



/* ### Best runtime: 0ms :

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) return head;
        ListNode current = head, next = null, prev = null;

        for (int i = 0; i < k; i++) {
            if (current == null) return head;
            current = current.next;
        }
        current = head;
        for (int i = 0; i < k && current != null; i++) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        if (next != null) {
            head.next = reverseKGroup(next, k);
        }
        return prev;
    }
}
*/