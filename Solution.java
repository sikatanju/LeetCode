import java.util.TreeMap;

class Solution {
    private static void run() {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(1, 2);
        
        System.out.println(treeMap.floorKey(3));
        treeMap.put(9, 5);
        System.out.println(treeMap.ceilingKey(3));
    }

    public static void main(String[] args) {
        run();       
    }
}