import java.util.Queue;
import java.util.LinkedList;

public class DesignCircularQueue {

    private int size;
    private Queue<Integer> queue;
    private int front;
    private int rear;
    public DesignCircularQueue(int k) {
        this.size = k;
        this.queue = new LinkedList<>();
    }
    public boolean enQueue(int value) {
        if (queue.size() == size)   {
            return false;
        }
        queue.add(value);
        if (queue.size() == 1)  {
            this.front = value;
        }
        this.rear = value;
        return true;
    }

    public boolean deQueue() {
        if (queue.size() > 0)   {
            queue.poll();
            if (this.queue.size() > 0)   {
                this.front = queue.peek();
            }   else if (this.queue.size() == 1) {
                this.front = queue.peek();
                this.rear = queue.peek();
            }   else {
                this.front = -1;
                this.rear = -1;
            }
            return true;
        }
        return false;
    }

    public int Front() {
        if (queue.size() > 0)   {
            return this.front;
        }
        return -1;
    }

    public int Rear() {
        if (queue.size() > 0)   {
            return this.rear;
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    public boolean isFull() {
        return this.size == this.queue.size();
    }
}
