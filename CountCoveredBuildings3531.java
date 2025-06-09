public class CountCoveredBuildings3531 {
//    public int countCoveredBuildings(int n, int[][] buildings) {
//        Map<Integer, int[]> xMap = new HashMap<>();
//        Map<Integer, int[]> yMap = new HashMap<>();
//
//        for (int[] arr: buildings)  {
//            int x = arr[0], y = arr[1];
//
//            xMap.putIfAbsent(x, new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE});
//            yMap.putIfAbsent(y, new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE});
//
//            xMap.get(x)[0] = Math.min(xMap.get(x)[0], y);
//            xMap.get(x)[1] = Math.max(xMap.get(x)[1], y);
//
//            yMap.get(y)[0] = Math.min(yMap.get(y)[0], x);
//            yMap.get(y)[1] = Math.max(yMap.get(y)[1], x);
//        }
//
//        int cnt = 0;
//        for (int[] arr: buildings)  {
//            int x = arr[0], y = arr[1];
//
//            int[] xArr = xMap.get(x);
//            int[] yArr = yMap.get(y);
//
//            if (y > xArr[0] && y < xArr[1] && x > yArr[0] && x < yArr[1])
//                cnt++;
//        }
//
//        return cnt;
//    }
}

/* Runtime is already Best :) */