public class palindromeLinkedList {
    public boolean isPalindrome(ListNode head)  {
        ListNode last = head;
        ListNode middle = head;

        while (last != null && last.next != null)  {
            last = last.next.next;
            middle = middle.next;
        }
        if (last != null)
            middle = middle.next;

        middle = reverse(middle);

        while (middle != null)  {
            if (head.val != middle.val)
                return false;

            head = head.next;
            middle = middle.next;
        }
        return true;
    }

    private ListNode reverse(ListNode middle)   {
        ListNode rev = null;
        while (middle != null)  {
            ListNode temp = middle.next;
            middle.next = rev;
            rev = middle;
            middle = temp;
        }
        return rev;
    }
}
/*

    while (last != null && middle != null)  {
        last = last.next.next;
        middle = middle.next;
    }

    if (last != null)   {
        middle = middle.next;
    }




 */