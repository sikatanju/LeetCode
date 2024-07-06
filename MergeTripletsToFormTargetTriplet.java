import java.util.Arrays;

public class MergeTripletsToFormTargetTriplet {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] ara = new boolean[3];
        Arrays.fill(ara, false);

        for (int i=0; i<triplets.length; i++)   {
            if (ara[0] && ara[1] && ara[2])
                break;

            if (!ara[0])    {
                if (triplets[i][0] == target[0] && triplets[i][1] <= target[1] && triplets[i][2] <= target[2])
                    ara[0] = true;
            }
            if (!ara[1])    {
                if (triplets[i][1] == target[1] && triplets[i][0] <= target[0] && triplets[i][2] <= target[2])
                    ara[1] = true;
            }
            if (!ara[2])    {
                if (triplets[i][2] == target[2] && triplets[i][0] <= target[0] && triplets[i][1] <= target[1])
                    ara[2] = true;
            }
        }
        return ara[0] && ara[1] && ara[2];
    }
}

/* Best runtime : 0ms :

class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        return check(triplets, target, 0) && check(triplets, target, 1) && check(triplets, target, 2);
    }

    private boolean check(int[][] triplets, int[] target, int i) {
        int t = target[i];
        if (i == 0) {
            for (int[] tri : triplets) {
                if (tri[0] == t && tri[1] <= target[1] && tri[2] <= target[2]) return true;
            }
            return false;
        }

        if (i == 1) {
            for (int[] tri : triplets) {
                if (tri[1] == t && tri[0] <= target[0] && tri[2] <= target[2]) return true;
            }
            return false;
        }

        if (i == 2) {
            for (int[] tri : triplets) {
                if (tri[2] == t && tri[1] <= target[1] && tri[0] <= target[0]) return true;
            }
            return false;
        }

        return false;
    }
}
 */
