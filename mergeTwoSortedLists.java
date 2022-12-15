/*
public class mergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2)   {
        if (list1 == null || list2 == null) {
            if (list1 == null)  return list1;
            else    return list2;
        }

        ListNode returnNode;

        if (list1.val < list2.val)  {
            returnNode = new ListNode(list1.val);
            list1 = list1.next;
        }
        else    {
            returnNode = new ListNode(list2.val);
            list2 = list2.next;
        }

        ListNode last = returnNode;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val)  {
                ListNode temp = new ListNode(list1.val);
                last.next = temp;
                last = temp;
                list1 = list1.next;
            }
            else    {
                ListNode temp = new ListNode(list2.val);
                last.next = temp;
                last = temp;
                list2 = list2.next;
            }
        }
        while (list1 != null)   {
            ListNode temp = new ListNode(list1.val);
            last.next = temp;
            last = temp;
            list1 = list1.next;
        }
        while (list2 != null)   {
            ListNode temp = new ListNode(list2.val);
            last.next = temp;
            last = temp;
            list2 = list2.next;
        }

        return returnNode;
    }
}
*/