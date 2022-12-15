public class addTwoNumbers {
    public ListNode addTwoNumber(ListNode l1, ListNode l2)  {
        return l1;
    }
}









/*
public ListNode addTwoNumber(ListNode l1, ListNode l2)  {
        List<Integer> returnList = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        while (l1 != null || l2 != null)    {
            if (l1 != null) {   list1.add(l1.val); l1 = l1.next;    }
            if (l2 != null) {   list2.add(l2.val); l2 = l2.next;   }
        }

        byte size1 = (byte)list1.size(), size2 = (byte)list2.size();
        byte i = 0, j = 0;
        int rm = 0;
        while (i != size1 || j != size2)    {
            if (i != size1 && j != size2)   {
                rm = list1.get(i++) + list2.get(j++) + rm;
                if (rm <= 9) {  ListNode temp = new ListNode(rm); rm = 0;}
                else    {   ListNode temp = new ListNode(rm%10);  rm /= 10;   }
            }
            else if (i == size1)   {
                rm = list2.get(j++) + rm;
                if (rm <= 9) {  ListNode temp = new ListNode(rm); rm = 0; }
                else    {   ListNode temp = new ListNode(rm%10);  rm /= 10;   }
            }
            else    {
                rm = list1.get(i++) + rm;
                if (rm <= 9)    {   ListNode temp = new ListNode(rm); rm = 0; }
                else    {   ListNode temp = new ListNode(rm%10);  rm /= 10;   }
            }
        }
        if (rm != 0)
            ListNode temp = new ListNode(rm);

        i = 0;
        int size = returnList.size();
        l1 = new ListNode(returnList.get(i++));
        l2 = l1;
        
        while (i != size)  {
            ListNode temp = new ListNode(returnList.get(i++));
            l2.next = temp;
            l2 = temp;
        }

        return l1;
    }


 */