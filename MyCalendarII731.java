public class MyCalendarII731 {
    /*
    class MyCalendarTwo {
        private List<int[]> list;
        private List<int[]> oList;
        public MyCalendarTwo() {
            this.list = new ArrayList<>();
            this.oList = new ArrayList<>();
        }

        public boolean book(int startTime, int endTime) {
            if (list.isEmpty()) {
                list.add(new int[]{startTime, endTime});
                return true;
            }   else    {
                for (int[] arr: oList)  {
                    if (Math.max(startTime, arr[0]) < Math.min(endTime, arr[1]))
                        return false;
                }
                for (int[] arr: list)   {
                    if (startTime >= arr[1] || endTime <= arr[0])   {
                        continue;
                    }   else    {
                        int start = Math.max(arr[0], startTime);
                        int end = Math.min(arr[1], endTime);
                        oList.add(new int[]{start, end});
                    }
                }
                list.add(new int[]{startTime, endTime});
                return true;
            }
        }
    }
     */
}

/* Best runtime: 16ms:
class MyCalendarTwo {
    class Node {
        int start, end;
        boolean overlap;
        Node left, right;
        Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    Node root;

    public MyCalendarTwo() {
        root = null;
    }

    public boolean book(int startTime, int endTime) {
        Node node = new Node(startTime, endTime);
        Node temp = insert(root, node);

        if (temp == null) return false;
        root = temp;
        return true;
    }


    private Node insert(Node root, Node node) {
        if (root == null) return node;

        if (node.end <= root.start) {
            Node temp = insert(root.left, node);
            if (temp == null) return null;
            root.left = temp;
            return root;
        }
        if (root.end <= node.start) {
            Node temp = insert(root.right, node);
            if (temp == null) return null;
            root.right = temp;
            return root;
        }
        if (root.overlap) return null;
        int start = Math.max(root.start, node.start);
        int end = Math.min(root.end, node.end);

        int lstart = Math.min(root.start, node.start);
        int lend = start;

        int rstart = end;
        int rend = Math.max(root.end, node.end);

        if (!canInsert(root.left, lstart, lend) || !canInsert(root.right, rstart, rend)) {
            return null;
        }
        root.start = start;
        root.end = end;
        root.overlap = true;

        root.left = insert(root.left, new Node(lstart, lend));
        root.right = insert(root.right, new Node(rstart, rend));
        return root;
    }

    private boolean canInsert(Node root, int start, int end) {
        if (root == null) return true;
        if (end <= root.start) {
            return canInsert(root.left, start, end);
        }
        if (start >= root.end) {
            return canInsert(root.right, start, end);
        }
        if (root.overlap) return false;
        int lstart = Math.min(root.start, start);
        int lend = Math.max(root.start, start);
        int rstart = Math.min(root.end, end);
        int rend = Math.max(root.end, end);

        return canInsert(root.left, lstart, lend) && canInsert(root.right, rstart, rend);
    }
}
 */