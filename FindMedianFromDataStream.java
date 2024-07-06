import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {

    PriorityQueue<Integer> low;
    PriorityQueue<Integer> high;
    boolean isEven;

    public FindMedianFromDataStream() {
        low = new PriorityQueue<>(Comparator.reverseOrder());
        high = new PriorityQueue<>();
        isEven = true;
    }

    public void addNum(int num) {
        if (isEven) {
            high.offer(num);
            low.offer(high.poll());
        }   else {
            low.offer(num);
            high.offer(low.poll());
        }
        this.isEven = !this.isEven;
    }

    public double findMedian() {
        if (isEven) {
            double one = low.peek();
            double two = high.peek();
            return (one+two)/2;
        }

        else
            return low.peek();
    }
}
