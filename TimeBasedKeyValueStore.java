import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeBasedKeyValueStore {
}

class TimeMap {

    public TimeMap() {
        this.map = new HashMap<>();
    }

    Map<String, TreeMap<Integer, String>> map;

    public void set(String key, String value, int timestamp) {
        if (map.containsKey(key))   {
            map.get(key).put(timestamp, value);
        }   else {
            TreeMap<Integer, String> newMap = new TreeMap<>();
            newMap.put(timestamp, value);
            this.map.put(key, newMap);
        }
    }

    public String get(String key, int timestamp) {
        if (!this.map.containsKey(key))
            return "";
        else {
            var newMap = this.map.get(key);
            if (newMap.containsKey(timestamp))
                return newMap.get(timestamp);
            else {
                var newKey = newMap.floorKey(timestamp);
                if (newKey != null)
                    return newMap.get(newKey);
                else
                    return "";
            }
        }
    }
}



/* Best runtime : 113ms


class TimeMap {
    public class Time{
        String key;
        String value;
        int timestamp;
        Time prev;

        public Time(String key, String value, int timestamp){
            this.key = key;
            this.value = value;
            this.timestamp = timestamp;
            this.prev = null;

        }
    }

    Time timeMap;

    public TimeMap() {
        timeMap = null;
    }

    public void set(String key, String value, int timestamp) {
        Time temp = new Time(key,value,timestamp);
        temp.prev = timeMap;
        timeMap = temp;
    }

    public String get(String key, int timestamp) {
        return get(key, timestamp, timeMap);
    }
    private String get(String key, int timestamp, Time map){
        if (map == null){
            return "";
        }
        if (key.equals(map.key)){
            if (map.timestamp <= timestamp){
                return map.value;
            }
        }
        return get(key, timestamp, map.prev);
    }
}

*/

/* Second Best runtime : 114ms

class TimeMap {
    public class Time {
        String key;
        String value;
        int timestamp;
        Time prev;

        public Time(String key, String value, int timestamp) {
            this.key = key;
            this.value = value;
            this.timestamp = timestamp;
            this.prev = null;

        }
    }

    Time timeMap;

    public TimeMap() {
        timeMap = null;
    }

    public void set(String key, String value, int timestamp) {
        Time temp = new Time(key, value, timestamp);
        temp.prev = timeMap;
        timeMap = temp;
    }

    public String get(String key, int timestamp) {
        return get(key, timestamp, timeMap);
    }

    private String get(String key, int timestamp, Time map) {
        if (map == null) {
            return "";
        }
        if (key.equals(map.key)) {
            if (map.timestamp <= timestamp) {
                return map.value;
            }
        }
        return get(key, timestamp, map.prev);
    }
}

 */

/* Binary Search Implementation :

class Pair {
    int timestamp;
    String val;

    Pair(int timestamp, String val) {
        this.timestamp = timestamp;
        this.val = val;
    }
}

public class TimeMap {

    private HashMap<String, ArrayList<Pair>> hashMap;

    public TimeMap() {
        hashMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (hashMap.containsKey(key)) {
            hashMap.get(key).add(new Pair(timestamp, value));
        } else {
            ArrayList<Pair> arr = new ArrayList<>();
            arr.add(new Pair(timestamp, value));
            hashMap.put(key, arr);
        }
    }

    public String get(String key, int timestamp) {

        String cand = "";

        if (hashMap.containsKey(key)) {
            ArrayList<Pair> arr = hashMap.get(key);
            int low = 0, high = arr.size() - 1;

            while (low <= high) {
                int mid = (low + high) / 2;
                int timeVal = arr.get(mid).timestamp;
                if (timeVal == timestamp) {
                    return arr.get(mid).val;
                } else if (timeVal < timestamp) {
                    cand = arr.get(low).val;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return cand;
    }

}

 */