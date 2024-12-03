import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class DetectSquares {
    private Map<List<Integer>, Integer> pointsMap;
    private List<List<Integer>> points;

    public DetectSquares() {
        this.pointsMap = new HashMap<>();
        this.points = new ArrayList<>();
    }

    public void add(int[] point) {
        List<Integer> pnt = List.of(point[0], point[1]);
        pointsMap.put(pnt, pointsMap.getOrDefault(pnt, 0)+1);
        points.add(pnt);
    }

    public int count(int[] point) {
        int qx = point[0], qy = point[1], res = 0;
        for (List<Integer> list: points)    {
            int x = list.get(0), y = list.get(1);
            if (Math.abs(qx-x) != Math.abs(qy-y) || x == qx || y == qy)
                continue;

            res += pointsMap.getOrDefault(List.of(x, qy), 0) * pointsMap.getOrDefault(List.of(qx, y), 0);
        }
        return res;
    }
}
