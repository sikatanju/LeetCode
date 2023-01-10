public class rotateList { // Medium
    public ListNode rotateRight (ListNode head, int k)  {
        if (head == null || head.next == null || k == 0)
            return head;

        int count = 1;
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null)   {
            if (fast.next.next == null) {
                fast = fast.next;
                count++;
            }
            else    {
                slow = slow.next;
                fast = fast.next.next;
                count += 2;
            }
        }
        if (k == count)
            return head;

        while (k >= count)  {
            k -= count;
            if (k == 0)
                return head;
        }

        slow = head;
        int temp = count - k;
        while (temp-- > 0)
            slow = slow.next;

        fast.next = head;
        temp = count - k;
        while (temp-- > 1)
            head = head.next;

        head.next = null;
        return slow;
    }
}
/*

        if (k >= count/2)    {
            slow = head;
            var temp = count - k;
            while (temp-- > 0)    {
                slow = slow.next;
            }
        }
        else    {
            if (count % 2 != 0) {
                if (k == 1) {
                    var temp = count/2;
                    while (temp-- > 0)
                        slow = slow.next;
                }
                else    {
                    var temp = k;
                    while (temp-- > 1)
                        slow = slow.next;
                }
            }
            else    {
                if (k==1)   {
                    var temp = count/2 - k;
                    temp++;
                    while (temp-- > 0)
                        slow = slow.next;
                }
                var temp = k;
                while (temp-- > 0)
                    slow = slow.next;
            }
        }

        var temp = count - k;
        fast.next = head;
        while (temp-- > 1)  {
            head = head.next;
        }
        head.next = null;
        return slow;
 */