import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class LRUCache {
    class DoubleLinkedList {
        int value;
        int key;

        DoubleLinkedList next;
        DoubleLinkedList prev;
    }

    private int capacity;
    private int count;
    private DoubleLinkedList head, tail;
    private Map<Integer, DoubleLinkedList> cache = new HashMap<Integer, DoubleLinkedList>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;

        head = new DoubleLinkedList();
        tail = new DoubleLinkedList();

        head.prev = null;
        tail.next = null;

        head.next = tail;
        tail.prev = head;
    }

    private void addNode(DoubleLinkedList node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DoubleLinkedList node) {
        var prev = node.prev;
        var next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void moveToHead(DoubleLinkedList node) {
        removeNode(node);
        addNode(node);
    }

    private DoubleLinkedList removeTail() {
        var prev = tail.prev;
        removeNode(prev);
        return prev;
    }

    public int get(int key) {
        DoubleLinkedList node = cache.get(key);

        if (node == null)
            return -1;

        this.moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DoubleLinkedList node = cache.get(key);
        if (node == null) {
            DoubleLinkedList newNode = new DoubleLinkedList();
            newNode.key = key;
            newNode.value = value;

            addNode(newNode);
            cache.put(key, newNode);

            count++;

            if (count > capacity) {
                DoubleLinkedList tail = this.removeTail();
                this.cache.remove(tail.key);
                count--;
            }
        } else {
            node.value = value;
            this.moveToHead(node);
        }
    }
}

/* Fastest Submission


class LRUCache {
    class Node{
        int key;
        int value;

        Node prev;
        Node next;

        Node(int key, int value){
            this.key= key;
            this.value= value;
        }
    }

    public Node[] map;
    public int count, capacity;
    public Node head, tail;

    public LRUCache(int capacity) {
         this.capacity= capacity;
        count= 0;

        map= new Node[10_000+1];

        head= new Node(0,0);
        tail= new Node(0,0);

        head.next= tail;
        tail.prev= head;

        head.prev= null;
        tail.next= null;
    }
    public void deleteNode(Node node){
        node.prev.next= node.next;
        node.next.prev= node.prev;

        return;
    }

    public void addToHead(Node node){
        node.next= head.next;
        node.next.prev= node;
        node.prev= head;

        head.next= node;

        return;
    }

    public int get(int key) {
        if( map[key] != null ){

            Node node= map[key];

            int nodeVal= node.value;

            deleteNode(node);

            addToHead(node);

            return nodeVal;
        }
        else
            return -1;
    }

    public void put(int key, int value) {
        if(map[key] != null){

            Node node= map[key];

            node.value= value;

            deleteNode(node);

            addToHead(node);

        } else {

            Node node= new Node(key,value);

            map[key]= node;

            if(count < capacity){
                count++;
                addToHead(node);
            }
            else {

                map[tail.prev.key]= null;
                deleteNode(tail.prev);

                addToHead(node);
            }
        }

        return;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

