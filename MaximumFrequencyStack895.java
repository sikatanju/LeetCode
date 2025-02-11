import java.util.Map;
import java.util.HashMap;
import java.util.Stack;

public class MaximumFrequencyStack895 {
    private static class Node {
        public Node next;
        public Node prev;
        public int value;

        public Node(int val)   {
            this.value = val;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;
    private Node tail;
    private int max;
    private Map<Integer, Stack<Node>> map;
    private Map<Integer, Integer> freqMap;

    public MaximumFrequencyStack895() {
        this.head = null;
        this.tail = null;
        this.max = 0;
        this.map = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    public void push(int val) {
        if (max == 0 && head == null)   {
            head = new Node(val);
            tail = head;
            max += 1;
            map.computeIfAbsent(max, i-> new Stack<>()).push(head);
            freqMap.put(val, freqMap.getOrDefault(val, 0)+1);
        }   else    {
            if (!freqMap.containsKey(val))  {
                freqMap.put(val, 1);
                Node newNode = new Node(val);
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
                // map.computeIfAbsent(1, i-> new Stack<>()).push(newNode);
                map.get(1).push(newNode);
            }   else    {
                int freq = freqMap.get(val);
                freqMap.put(val, freq+1);
                Node newNode = new Node(val);
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
                map.computeIfAbsent(freq+1, i-> new Stack<>()).push(newNode);
                max = Math.max(max, freq+1);
            }
        }
    }

    public int pop() {
        Node tempNode = map.get(max).pop();
        var freq = freqMap.get(tempNode.value);
        if (freq > 1)
            freqMap.put(tempNode.value, freq-1);
        else
            freqMap.remove(tempNode.value);

        if (map.get(max).isEmpty())   {
            max -= 1;
        }
        Node prev = tempNode.prev;
        Node next = tempNode.next;
        if (prev != null)
            prev.next = next;
        if (next != null)
            next.prev = prev;

        tempNode.next = null;
        tempNode.prev = null;
        return tempNode.value;
    }
}