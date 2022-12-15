/*public class addTwoNumbersReloaded {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = l1;
        int carry = 0;
        ListNode prev = null;
        while(l1!=null && l2!=null){
            prev = l1;
            int sum = l1.val + l2.val + carry;
            l1.val = sum%10;
            carry = sum/10;
            l1=l1.next;
            l2=l2.next;
        }
        if(l1==null){
            prev.next=l2;
        }
        while(l1!=null){
            prev = l1;
            int sum = l1.val + carry;
            l1.val = sum%10;
            carry = sum/10;
            l1=l1.next;
        }
        while(l2!=null){
            prev = l2;
            int sum = l2.val + carry;
            l2.val = sum%10;
            carry = sum/10;
            l2=l2.next;
        }
        if(carry>0){
            prev.next=new ListNode(1);
        }
        return head;
    }
}
*/