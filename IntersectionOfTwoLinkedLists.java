import java.util.Set;
import java.util.HashSet;

public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode (ListNode headA, ListNode headB) {
       if (headA.next == null && headB.next == null) {
           if (headA == headB)
                return headA;
           else
                return null;
       }
       ListNode copyHeadA = headA;
       ListNode copyHeadB = headB;
       Set<ListNode> set = new HashSet<>();
        while (copyHeadA != null) {
            set.add(copyHeadA);
            copyHeadA = copyHeadA.next;
        }
        while (copyHeadB != null)   {
            if (set.contains(copyHeadB))
                return copyHeadB;

            copyHeadB = copyHeadB.next;
        }
        return null;
    }
}


//        if (headA.next == null && headB.next == null)
//                    return (headA==headB) ? headA : null;
//
//                    ListNode copyA = headA, copyB = headB;
//                    Set<ListNode> set = new HashSet<>();
//        while (true)  {
//        if (copyA != null)  {
//        set.add(copyA);
//        copyA = copyA.next;
//        }
//        if (set.contains(copyB) || set.contains(copyA))
//        return (set.contains(copyA)) ? copyA : copyB;
//
//        if (copyB != null)  {
//        set.add(copyB);
//        copyB = copyB.next;
//        }
//        if (copyA == null && copyB == null)
//        break;
//        }
//        return null;
//        }
