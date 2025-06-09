    import java.util.Arrays;
    import java.util.LinkedList;
    import java.util.Queue;

    public class PropertiesGraph3493 {
        public int numberOfComponents(int[][] properties, int k) {
            int n = properties.length, m = properties[0].length;
            boolean[] mark = new boolean[n];
            int res = 0;
            Arrays.sort(properties, (a, b) -> a[0] - b[0]);
            Queue<Integer> queue = new LinkedList<>();

            for (int i=0; i<n; i++) {
                if (mark[i])
                    continue;

                mark[i] = true;
                queue.add(i);
                res++;
                while (!queue.isEmpty()) {
                    int idx = queue.remove();
                    int[] a = properties[idx];
                    for (int j=0; j<n; j++)   {
                        if (mark[j])
                            continue;
                        int[] b = properties[j];
                        if (intersect(a, b) >= k)   {
                            mark[j] = true;
                            queue.add(j);
                        }
                    }
                }
            }


            return res;
        }

        private int intersect(int[] a, int[] b) {
            int[] cnt = new int[101];
            int res = 0;
            for (int i: a)  {
                if (cnt[i] == 0)
                    cnt[i]++;
            }
            for (int j: b)  {
                if (cnt[j] == 1)    {
                    res++;
                    cnt[j]++;
                }
            }
            return res;
        }
    }