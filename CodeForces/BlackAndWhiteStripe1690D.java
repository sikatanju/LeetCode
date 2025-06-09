package CodeForces;

import java.util.Scanner;

public class BlackAndWhiteStripe1690D {
    static Scanner sc = new Scanner(System.in);

    private static void solve() {
        int n = sc.nextInt();
        int k = sc.nextInt();
        String str = sc.next();
        sc.nextLine();

        int[] prefix = new int[n+1];
        int min = Integer.MAX_VALUE;
        for (int i=1; i<=n; i++)
            prefix[i] = prefix[i-1] + (str.charAt(i-1) == 'W' ? 1 : 0);

        for (int i=k; i<=n; i++)
            min = Math.min(min, prefix[i]-prefix[i-k]);

        System.out.println(min);
    }

    public static void main(String[] args)  {
        int tc = sc.nextInt();

        while (tc-- > 0)
            solve();
    }
}