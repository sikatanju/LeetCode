/*
public class copyListWithRandomPointer {

    public Node copyRandomList (Node head)  {
        if (head == null)
            return head;

        Node headCopy = head;
        Node copy = new Node(head.val);
        Node last = copy;

        while (head.next != null)    {
            Node temp = new Node(head.next.val);
            last.next = temp;
            last = temp;
            head = head.next;
        }

        last = copy;
        head = headCopy;

        while (head != null)    {
            if (head.random != null)    {
                var index = findIndex (headCopy, head.random);
                last.random = findNode(copy, index);
            }
            last = last.next;
            head = head.next;
        }
        int i = 0;
        return copy;
    }

    private int findIndex (Node head, Node target)  {
        Node find = head;
        int i = 0;
        while (find != null)    {
            if (find == target)
                return i;

            i++;
            find = find.next;
        }
        return i;
    }

    private Node findNode (Node copy, int index)  {
        Node temp = copy;
        int i = 0;
        while (copy != null)    {
            if (index == i)
                return temp;

            i++;
            temp = temp.next;
        }
        return temp;
    }
}
 */