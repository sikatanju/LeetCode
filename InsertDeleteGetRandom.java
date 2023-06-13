import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InsertDeleteGetRandom {

    Map<Integer, Integer> map;
    ArrayList<Integer> list;


    /*public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }*/

    public boolean insert(int val) {
        if (map.containsKey(val))   {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (map.containsKey(val))   {
            int index = map.get(val);
            int lastIndex = list.size()-1;
            if (index != lastIndex) {
                int lastValue = list.get(lastIndex);
                list.set(index, lastValue);
                map.replace(lastValue, index);
            }
            list.remove(lastIndex);
            map.remove(val);
            return true;
        }
        return false;
    }

    public int getRandom() {
        return list.get((int)(Math.random()*list.size()));
    }
}


/* public class RandomizedSet {

    Map<Integer, Integer> map;
    ArrayList<Integer> list;


    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val))   {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (map.containsKey(val))   {
            int index = map.get(val);
            int lastIndex = list.size()-1;
            if (index != lastIndex) {
                int lastValue = list.get(lastIndex);
                list.set(index, lastValue);
                map.replace(lastValue, index);
            }
            list.remove(lastIndex);
            map.remove(val);
            return true;
        }
        return false;
    }

    public int getRandom() {
        return list.get((int)(Math.random()*list.size()));
    }
}


/* class RandomizedSet {
    Map<Integer, Integer> m = new HashMap();
    Random rand = new Random();
    int[] t = new int[20001];
    int n = 0;

    public RandomizedSet() { }
    public boolean insert(int val) {
        boolean is_present = this.m.containsKey(val);
        if(is_present) return false;
        this.m.put(val, n);
        this.t[n++] = val;
        return true;
    }

    public boolean remove(int val) {
        boolean is_present = this.m.containsKey(val);
        if(!is_present) return false;
        int idx = this.m.get(val);
        this.t[idx] = 0;
        this.m.remove(val, idx);
        this.n--;
        if(this.n == 0)
            return true;

        this.t[idx] = this.t[n];
        this.m.put(this.t[idx], idx);
        return true;
    }

    public int getRandom() {
        int idx = this.rand.nextInt(this.n);
        return this.t[idx];
    }
}
 */
