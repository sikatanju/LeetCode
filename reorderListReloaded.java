/*public class reorderListReloaded {
1. Runs at 1ms.

class Solution {
    public void reorderList(ListNode head) {
        if(head.next == null) return;
        ListNode mid = getMid(head);
        ListNode right = reversed(mid);

        ListNode left = head;
        ListNode tail = head;
        left = left.next;

        while(left != null && right != null) {
            ListNode first = right;
            ListNode second = left;
            left = left.next;
            right = right.next;
            tail.next = first;
            tail.next.next = second;
            tail = tail.next.next;
        }

        if(right != null) tail.next = right;
        if(left!= null) tail.next = left;
    }

    public ListNode getMid(ListNode head) {
        ListNode midPrev = null;
        while(head != null && head.next!= null) {
            midPrev = midPrev == null ? head : midPrev.next;
            head = head.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }

    public ListNode reversed(ListNode mid){
        ListNode head = mid;
        ListNode tail = head;
        mid = mid.next;
        tail.next = null;
        while(mid != null) {
            ListNode temp = mid;
            mid = mid.next;
            temp.next = head;
            head = temp;
        }

        return head;
    }
}

***********************************************************

2. Runs at 2ms : 
class Solution {
     ListNode getMid(ListNode head){
        if(head == null){
            return head;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast!=null && fast.next!=null){
            fast = fast.next;
            if(fast.next!=null){
                fast = fast.next;
            }
            slow = slow.next;
        }
        
        return slow;
    }
    
    ListNode reverse(ListNode head){
        if(head == null){
            return head;
        }
        
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = head;
        
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
    void merge(ListNode headA, ListNode headB){
        if(headA == null){
            return;
        }
        if(headB == null){
            return;
        }
        
        ListNode head = headA;
        ListNode tail = headA;
        headA = headA.next;
        int x = 1;
        
        while(headA!=null && headB!=null){
            if(x%2==0){
                tail.next = headA;
                headA = headA.next;
                tail = tail.next;
            }else{
                tail.next = headB;
                headB = headB.next;
                tail = tail.next;
            }
           x++;
        }
        
        if(headA!=null){
            tail.next = headA;
        }
        if(headB!=null){
            tail.next = headB;
        }
    }
    public void reorderList(ListNode head) {
          if(head == null){
            return;
        }   
        
        ListNode mid = getMid(head);
        ListNode headB = mid.next;
        mid.next = null;
        headB = reverse(headB);
        
        merge(head, headB);
    }
}

***********************************************************

3. Runs at 3ms : 
class Solution {
    public void reorderList(ListNode head) {
                if(head == null || head.next == null){
                    return;
                }
                
                //Find the middle of the list
                ListNode slow = head;
                ListNode fast = head;
                while(fast.next != null){
                    if (fast.next.next != null){
                        slow = slow.next;
                        fast = fast.next.next;
                    }
                    else{
                        fast = fast.next;
                    }
                }
                
                //Reverse the half after middle  1->2->3->4->5->6 to 1->2->3->6->5->4
                ListNode preMiddle=slow;
                ListNode preCurrent=slow.next;
                while(preCurrent.next!=null){
                    ListNode current=preCurrent.next;
                    preCurrent.next=current.next;
                    current.next=preMiddle.next;
                    preMiddle.next=current;
                }
                
                //Start reorder one by one  1->2->3->6->5->4 to 1->6->2->5->3->4
                slow=head;
                fast=preMiddle.next;
                while(slow!=preMiddle){
                    preMiddle.next=fast.next;
                    fast.next=slow.next;
                    slow.next=fast;
                    slow=fast.next;
                    fast=preMiddle.next;
                }
            }
}
}*/
