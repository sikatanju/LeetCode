package Algorithms;

public class DivideAndConquer {
    public static int findMaxiumElement(int[] ara) {
        if (ara.length == 0)
            return -1;

        return findMaxiumElement(0, ara.length-1, ara);
    }
    private static int findMaxiumElement(int i, int j, int[] ara)  {
        if (i == j)
            return ara[i];

        int mid = (i+j)/2;
        return Math.max(
                findMaxiumElement(i, mid, ara),
                findMaxiumElement(mid+1, j, ara)
        );
    }

    public static int findMinimumElement(int[] ara) {
        if (ara.length == 0)
            return -1;

        return findMinimumElement(0, ara.length-1, ara);
    }
    private static int findMinimumElement(int i, int j, int[] ara)   {
        if (i == j)
            return ara[i];
        if (j-i == 1)
            return Math.min(ara[i], ara[j]);
        if (j-i == 2)
            return Math.min(ara[i], Math.min(ara[i+1], ara[j]));

        int split = (j-i)/3;
        int mid = i+split;
        int mid2 = i+2*split;
        return Math.min(findMinimumElement(i, mid, ara),
                Math.min(findMinimumElement(mid+1, mid2, ara),
                        findMinimumElement(mid2+1, j, ara)));

    }

    public static void main(String[] args)  {
        int[] ara = {-1, -23};
        System.out.println(findMinimumElement(ara));
    }
}
