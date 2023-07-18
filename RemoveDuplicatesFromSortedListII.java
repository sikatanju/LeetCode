public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode currentNode = head;
        ListNode lastNode = null;
        int count = 0;
        int currentValue = head.val;

        while (currentNode != null) {
            if (currentNode.next == null)   {
                if (lastNode == null) {
                    lastNode = currentNode;
                    head = lastNode;
                }
                else
                    lastNode.next = currentNode;

                break;
            }
            if (currentNode.next != null && currentNode.next.val != currentValue)   {
                if (lastNode == null && count == 0) {
                    head = null;
                    head = currentNode;
                    lastNode = head;
                }
                else if (lastNode == null)
                    lastNode = currentNode;

                else    {
                    lastNode.next = currentNode;
                    lastNode = currentNode;
                }
                currentNode = currentNode.next;
                currentValue = currentNode.val;
            }
            else if (currentNode.next != null && currentNode.next.val == currentValue)  {
                while (currentNode != null && currentNode.val == currentValue)
                    currentNode = currentNode.next;

                if (currentNode == null)    {
                    if (lastNode == null)
                        return null;

                    lastNode.next = null;
                    break;
                }
                currentValue = currentNode.val;
                continue;
            }
            count++;
        }
        return head;
    }
}
