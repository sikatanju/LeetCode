import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        var numOfFleet = 0;
        double[] ara = new double[target];

        for (int i=0; i<position.length; i++)
            ara[position[i]] = (double) (target-position[i]) / speed[i];

        double prev = 0.0;

        for (int i=target-1; i>=0; i--) {
            double curr = ara[i];
            if (curr > prev)    {
                numOfFleet++;
                prev = curr;
            }
        }
        return numOfFleet;
    }
}
