import java.util.Arrays;

public class SortAnArray {
    public int[] sortArray(int[] nums) {
        return mergeSort(0, nums.length-1, nums);
    }
    private int[] mergeSort(int i, int j, int[] nums)   {
        if (i==j)
            return Arrays.copyOfRange(nums, i, j+1);

        int mid = (i+j)/2;
        int[] firstHalf = mergeSort(i, mid, nums);
        int[] secondHalf = mergeSort(mid+1, j, nums);
        return merge(firstHalf, secondHalf);
    }
    private int[] merge(int[] firstHalf, int[] secondHalf)  {
        int[] newArray = new int[firstHalf.length+secondHalf.length];
        int i=0, j=0, n=0, len1 = firstHalf.length, len2 = secondHalf.length;
        while (i < len1 && j < len2)    {
            if (firstHalf[i] < secondHalf[j])
                newArray[n++] = firstHalf[i++];
            else
                newArray[n++] = secondHalf[j++];
        }
        while (i<len1)
            newArray[n++] = firstHalf[i++];
        while (j < len2)
            newArray[n++] = secondHalf[j++];

        return newArray;
    }
}

/* Best runtime: 11ms:
class Solution {

    public static class SortingTask extends RecursiveTask<int[]> {

    private final int[] arr;

    public SortingTask(int[] arr) {
        this.arr = arr;
    }

    @Override
    protected int[] compute() {
        if(arr.length <= 1) {
            return arr;
        }
            var task1 = new SortingTask(Arrays.copyOfRange(arr, 0, arr.length/2)).fork();
            var task2 = new SortingTask(Arrays.copyOfRange(arr, arr.length/2, arr.length)).fork();
            int[] arr1 = task1.join();
            int[] arr2 = task2.join();
            int[] result = new int[arr.length];
            int i = 0;
            int j = 0;
            for(;i+j<arr.length;) {
                if(i==arr1.length) {
                    result[i+j] = arr2[j];
                    j++;
                    continue;
                }
                if(j==arr2.length) {
                    result[i+j] = arr1[i];
                    i++;
                    continue;
                }
                if(arr1[i]<arr2[j]) {
                    result[i+j] = arr1[i];
                    i++;
                } else {
                    result[i+j] = arr2[j];
                    j++;
                }
            }
            return result;
    }
}

    public int[] sortArray(int[] nums) {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        return forkJoinPool.invoke(new SortingTask(nums));
    }
}
 */