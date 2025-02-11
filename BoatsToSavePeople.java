import java.util.Arrays;

public class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int len = people.length, minBoats = 0;
        int low = 0, high = len-1;
        while (people[high] == limit)   {
            high--;
            minBoats++;
        }
        while (low <= high)  {
            int sum = people[low]+people[high];
            if (sum > limit)
                high--;
            else {
                low++;
                high--;
            }
            minBoats++;
        }
        return minBoats;
    }
}
