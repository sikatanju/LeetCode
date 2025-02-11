import java.util.ArrayDeque;
import java.util.Map;
import java.util.HashMap;

public class LFUCache460 {
    private class Node {
        public Node prev;
        public Node next;

        public int key;
        public int value;
        public int freq;

        public Node(int key, int val, int f)    {
            this.prev = null;
            this.next = null;
            this.key = key;
            this.value = val;
            this.freq = f;
        }
    }

    private int cap, min;
    private int count;
    private Map<Integer, Node> map;
    private Map<Integer, ArrayDeque<Node>> freqMap;


    public LFUCache460(int capacity) {
        this.count = 0;
        this.min = Integer.MAX_VALUE;
        this.cap = capacity;
        this.map = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key))   {
            Node node = map.get(key);
            int freq = node.freq++;
            freq++;
            freqMap.computeIfAbsent(freq, i -> new ArrayDeque<>()).addLast(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (count == cap && !map.containsKey(key))   {
            removeNode();
        }   else if (!map.containsKey(key)){
            count++;
        }
        if (map.containsKey(key))   {
            Node tempNode = map.get(key);
            tempNode.value = value;
            tempNode.freq++;
            freqMap.computeIfAbsent(tempNode.freq, i -> new ArrayDeque<>()).addLast(tempNode);
            min = Math.min(min, tempNode.freq);
        }
        else    {
            Node newNode = new Node(key, value, 1);
            map.put(key, newNode);
            freqMap.computeIfAbsent(1, i -> new ArrayDeque<>()).addLast(newNode);
            min = 1;
        }
    }
    private void removeNode()   {
        ArrayDeque<Node> ara = freqMap.get(min);
        while (true)   {
            if (!ara.isEmpty() && ara.peekFirst().freq == min)
                break;

            if (ara.isEmpty())
                ara = freqMap.get(++min);

            while (!ara.isEmpty() && ara.peekFirst().freq != min)    {
                ara.pollFirst();
            }
        }
        if (!ara.isEmpty() && ara.peekFirst().freq == min)    {
            Node temp = ara.pollFirst();
            map.remove(temp.key);
        }
        while (!ara.isEmpty() && ara.peekFirst().freq != min)    {
            ara.pollFirst();
        }
        if (ara.isEmpty())
            min++;
    }
}

/* Best runtime: 35ms:
class FreqNode {
    int freq;
    FreqNode prev;
    FreqNode next;
    DataNode head;
    DataNode tail;

    FreqNode(int freq) {
        this.freq = freq;
    }
}
class DataNode {
    int key;
    int val;
    DataNode prev;
    DataNode next;
    FreqNode freq;

    DataNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
class LFUCache {
    int capacity;
    int curSize;
    DataNode[] map;

    FreqNode head;
    FreqNode tail;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        map = new DataNode[100001];
    }

    public int get(int key) {
        DataNode data = map[key];
        if (data == null)
            return -1;

        FreqNode freq = data.freq;
        FreqNode nextFreq = freq.next;

        if (nextFreq == null || nextFreq.freq != freq.freq + 1) {
            freq.next = new FreqNode(freq.freq + 1);
            freq.next.next = nextFreq;
            freq.next.prev = freq;
            if (nextFreq != null)
                nextFreq.prev = freq.next;
            nextFreq = freq.next;
            if (freq == head)
                head = nextFreq;
        }

        if (data != freq.head)
            data.prev.next = data.next;
        else
            freq.head = data.next;

        if (data != freq.tail)
            data.next.prev = data.prev;
        else
            freq.tail = data.prev;

        if (freq.head != null)
            freq.head.prev = freq.tail.next = null;
        else {
            if (freq != tail) {
                freq.prev.next = freq.next;
            }
            else {
                tail = freq.next;
            }

            freq.next.prev = freq.prev;
        }

        if (nextFreq.tail != null) {
            nextFreq.tail.next = data;
            data.prev = nextFreq.tail;
        } else {
            nextFreq.head = data;
            data.prev = null;
        }

        data.next = null;
        nextFreq.tail = data;
        data.freq = nextFreq;
        return data.val;
    }

    public void put(int key, int value) {
        if (get(key) != -1) {
            map[key].val = value;
            return;
        }

        DataNode cur = new DataNode(key, value);
        FreqNode temp = tail;
        if (tail != null && tail.freq == 1) {
            tail.tail.next = cur;
            cur.prev = tail.tail;
            tail.tail = cur;
        } else {
            FreqNode curFreq = new FreqNode(1);

            if (tail == null)
                head = tail = curFreq;
            else {
                tail.prev = curFreq;
                curFreq.next = tail;
                tail = curFreq;
            }
            tail.head = tail.tail = cur;
        }

        cur.freq = tail;
        if (curSize++ == capacity) {
            map[temp.head.key] = null;

            temp.head = temp.head.next;
            if (temp.head != null)
                temp.head.prev = null;
            else {
                tail.next = temp.next;
                if (temp != head)
                    temp.next.prev = tail;
                else
                    head = tail;
            }
            curSize--;
        }

        map[key] = cur;
    }
}
*/