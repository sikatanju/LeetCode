import java.util.ArrayList;
import java.util.List;

public class MyCalendarI729 {
    class MyCalendar {
        private List<int[]> list;
        public MyCalendar() {
            list = new ArrayList<>();
        }

        public boolean book(int startTime, int endTime) {
            if (list.isEmpty()) {
                list.add(new int[]{startTime, endTime});
                return true;
            }   else    {
                boolean check = true;
                for (int[] arr: list)   {
                    if (endTime <= arr[0] || (startTime >= arr[1])) {
                        continue;
                    }   else    {
                        check = false;
                        break;
                    }
                }
                if (check)  {
                    list.add(new int[]{startTime, endTime});
                    return true;
                }
            }
            return false;
        }
    }

}
/* Best runtime: 12ms: (LinkedList approach).
class MyCalendar {
    class Node {
        int s, e;
        Node left, right;
        Node (int s, int e) {
            this.s = s;
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }
    Node root;
    public MyCalendar() {
        this.root = null;
    }

    public boolean book(int startTime, int endTime) {
        if (root == null) {
            root = new Node(startTime, endTime);
            return true;
        }
        Node current = root;
        while (current != null) {
            if (endTime <= current.s) {
                if (current.left == null) {
                    current.left = new Node(startTime, endTime);
                    return true;
                } else current = current.left;
            } else if (startTime >= current.e) {
                if (current.right == null) {
                    current.right = new Node(startTime, endTime);
                    return true;
                } else current = current.right;
            } else return false;
        }
        return false;
    }
}
 */


/* Most accepted runtime: Using TreeMap:
class MyCalendar {

    private TreeMap<Integer, Integer> events;

    public MyCalendar() {
        events = new TreeMap<>();
    }

    public boolean book(int startTime, int endTime) {
        Map.Entry<Integer, Integer> floor = events.floorEntry(startTime);
        if(floor != null && floor.getValue() > startTime)
            return false;

        Map.Entry<Integer, Integer> ceiling = events.ceilingEntry(startTime);
        if(ceiling != null && ceiling.getKey() < endTime)
            return false;

        events.put(startTime, endTime);
        return true;
    }
}
*/


/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */