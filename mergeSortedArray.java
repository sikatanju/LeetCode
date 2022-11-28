import java.util.Arrays;

public class mergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int temp = n;
        int j=0;
        for (int i = nums1.length-1; i>=nums1.length-temp; i--)   {
            nums1[i] = nums2[j++];
        }
        Arrays.sort(nums1);
    } 

    public static void main(String[] args)  {
        int[] ara = {-1,0,0,3,3,3,0,0,0};
        int[] nums1 = {1,2,2};

        mergeSortedArray ob = new mergeSortedArray();
        ob.merge(ara, 6, nums1, 3);
    }
}