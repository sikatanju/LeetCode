import java.util.Arrays;

public class DesignHashMap {
    private int[] ara;

    public DesignHashMap() {
        this.ara = new int[1000001];
        Arrays.fill(ara, -1);
    }

    public void put(int key, int value) {
        this.ara[key] = value;
    }

    public int get(int key) {
        return this.ara[key];
    }

    public void remove(int key) {
        this.ara[key]= -1;
    }
}

