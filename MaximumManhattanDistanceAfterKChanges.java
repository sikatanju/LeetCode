public class MaximumManhattanDistanceAfterKChanges {
    public int maxDistance(String str, int k) {
        int n = 0, s = 0, e = 0, w = 0, max = -1;
        for (var ch: str.toCharArray()) {
            if (ch == 'N')
                n++;
            else if (ch == 'S')
                s++;
            else if (ch == 'E')
                e++;
            else
                w++;

            int maxX = Math.max(n, s), minX = Math.min(n, s);
            int maxY = Math.max(e, w), minY = Math.min(e, w);
            int currK = k;

            int dY = Math.min(currK, minY);
            maxY += dY;
            minY -= dY;
            currK -= dY;

            int dX = Math.min(currK, minX);
            maxX += dX;
            minX -= dX;

            int tempMax = (maxX-minX) + (maxY-minY);
            max= Math.max(max, tempMax);
        }
        return max;
    }
}

/*
    public int maxDistance(String s, int k) {
        int north = 0, south = 0, east = 0, west = 0;
        int max = -1;
        for (var ch: s.toCharArray())   {
            switch (ch) {
                case 'N':
                    north++;
                    break;
                case 'S':
                    south++;
                    break;
                case 'E':
                    east++;
                    break;
                case 'W':
                    west++;
                    break;
            }
            max = Math.max(north + east - south - west + (2*Math.min(south+west, k)), max);
            max = Math.max(north + west - south - east + (2* Math.min(south+east, k)), max);
            max = Math.max(south + east - north - west + (2 * Math.min(north+west, k)), max);
            max = Math.max(south + west - north - east + (2 * Math.min(north+east, k)), max);
        }
        return max;
    }
 */