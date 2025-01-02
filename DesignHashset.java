import java.util.Arrays;

public class DesignHashset {
    private boolean[] ara;

    public DesignHashset() {
        this.ara = new boolean[1000001];
    }

    public void add(int key) {
        this.ara[key] = true;
    }

    public void remove(int key) {
        this.ara[key] = false;
    }

    public boolean contains(int key) {
        return this.ara[key];
    }
}
//
//class MyHashSet {
//
//    public MyHashSet() {
//
//    }
//
//    public void add(int key) {
//
//    }
//
//    public void remove(int key) {
//
//    }
//
//    public boolean contains(int key) {
//        return false;
//    }
//}
