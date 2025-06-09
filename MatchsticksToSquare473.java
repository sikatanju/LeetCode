import java.util.Arrays;

public class MatchsticksToSquare473 {
    public boolean makesquare(int[] matchSticks) {
        int sum = Arrays.stream(matchSticks).sum();
        if (sum % 4 != 0)
            return false;

        Arrays.sort(matchSticks);
        reverse(matchSticks);
        return check(matchSticks, 0, 4, sum/4, 0, new boolean[matchSticks.length]);
    }

    private boolean check(int[] ara, int i, int k, int target, int currSum, boolean[] visited) {
        if (k == 0)
            return true;

        if (currSum == target)
            return check(ara, 0, k-1, target, 0, visited);

        for (; i<ara.length; i++)   {
            if (visited[i] || currSum + ara[i] > target)
                continue;

            visited[i] = true;
            if (check(ara, i+1, k, target, currSum+ara[i], visited))
                return true;

            visited[i] = false;
            if (currSum == 0)
                return false;
        }
        return false;
    }

    private void reverse(int[] ara)    {
        int low = 0, high = ara.length-1;
        while (low <= high) {
            int temp = ara[low];
            ara[low++] = ara[high];
            ara[high--] = temp;
        }
    }
}
