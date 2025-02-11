package Algorithms;

// Cycle sort is a very efficient sorting algorithm, which sorts an array in O(n) runtime and uses constant space.
// *** The only catch is that the array can only contain elements ranges from 1 to N (N being the length of the array)

import java.util.Arrays;

public class CycleSort {
    private static int[] cycleSort(int[] ara) {
        int i=0, n = ara.length;
        while (i<n) {
            int correctPosition = ara[i]-1;
            if (ara[i] > 0 && ara[i] < n && ara[i]+1 != correctPosition)
                swap(i++, correctPosition, ara);
            else
                i++;
        }
        return ara;
    }
    private static void swap(int i, int j, int[] ara)   {
        int temp = ara[i];
        ara[i] = ara[j];
        ara[j] = temp;
    }

    public static void main(String[] args)  {
        int[] ara = { 2, 3, 1, 4,7,6,9,8,5};
        System.out.println(Arrays.toString(cycleSort(ara)));
    }
}
