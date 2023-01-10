import java.util.Set;
import java.util.HashSet;

public class linkedListCycle {
    public boolean hasCycle (ListNode head)    {
        Set<ListNode> set = new HashSet<>();
        while (head != null)    {
            if (set.contains(head))
                return true;
            else
                set.add(head);

            head = head.next;
        }
        return false;
    }
}
