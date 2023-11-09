import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KthLargestElementInAStream {
    PriorityQueue<Integer> heap;
    private int k;

    public KthLargestElementInAStream(int k, int[] nums) {
        heap  = new PriorityQueue<>();
        this.k = k;
        for (var num: nums)
            heap.add(num);
    }

    public int add(int val) {
        heap.add(val);
        while (heap.size() > k)
            heap.remove();

        return heap.peek();
    }
}
