// Minimum Number of Moves to Seat Everyone -- 
// https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/
// Difficulty : Easy.

public class minimumNumberMoves {
    
    public static void quickSort(int[] ara)  {
        quickSort(ara, 0, ara.length-1);
    }

    public static void quickSort(int[] ara, int start, int end) {
        if (start >= end)
            return;

        int boundary = partition(ara, start, end);
        
        quickSort(ara, start, boundary-1);
        quickSort(ara, boundary+1, end);
    }
    
    public static int partition(int[] ara, int start, int end) {
        int pivot = ara[end];
        int boundary = start - 1;
        
        for (int i=start; i<=end; i++)  {
            if (ara[i] <= pivot)    
                swap(ara, i, ++boundary);
        }

        return boundary;
    }

    public static void swap(int[] ara, int i, int j)    {
        int temp = ara[i];
        ara[i] = ara[j];
        ara[j] = temp;
    }

    public int minMovesToSeat(int[] seats, int[] students) {
        quickSort(seats);
        quickSort(students);
        
        int count = 0;
        for (int i=0; i<seats.length; i++)  {
            count += Math.abs(seats[i] - students[i]);
        }
        return count;
    }

    public static void main(String[] args)  {
        int[] ara = {1, 4, 5, 9};
        int[] stu = {1, 2, 3, 6};

        minimumNumberMoves obj = new minimumNumberMoves();
        System.out.println(obj.minMovesToSeat(ara, stu));
    }
}
