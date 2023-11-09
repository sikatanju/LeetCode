import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int num: stones)
            heap.add(num);

        while (true)    {
            int num1 = 0, num2 = 0;

            if (!heap.isEmpty())
                num1 = heap.remove();

            if (heap.isEmpty())
                return num1;

            if (!heap.isEmpty())
                num2 = heap.remove();

            heap.add(Math.abs(num1-num2));
        }
    }
}
