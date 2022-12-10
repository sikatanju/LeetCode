// **********************     Stack          *************************

/*import java.util.Stack;

public class reorderList   {
    public void reorderlist(ListNode head)  {
        Stack<Integer> stack = new Stack<> ();
        ListNode newHead = head;

        int size = 0;
        while (true)    {
            stack.push(head.val);
            size++;
            if (head.next == null)
                break;
            
            head = head.next;
        }

        // head = new ListNode();
        int count = 1;
        head = newHead;
        newHead = newHead.next;
        head.next = null;
        // head.val = newHead.val;
        ListNode last = head;
        

        while (count < size)   {
            if (count % 2 != 0) {
                ListNode temp = new ListNode(stack.pop());
                last.next = temp;
                last = temp;
                count++;
            }
            else    {
                ListNode temp = new ListNode(newHead.val);
                last.next = temp;
                last = temp;
                newHead = newHead.next;
                count++;
            }
        }
        while (true)   {
            System.out.print (head.val + " ");
            if (head.next == null)
                break;
                
            head = head.next;
        }
    }
}*/