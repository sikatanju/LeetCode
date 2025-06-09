package Algorithms;

import java.util.Scanner;

public class ContiguousSegmentsOfIdenticalValues  {
    static Scanner sc = new Scanner(System.in);
    private static void solve() {
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        for (int i=0; i<n; i++)
            arr1[i] = sc.nextInt();
        for (int i=0; i<n; i++)
            arr2[i] = sc.nextInt();

        int[] freqA = new int[2*n+1], freqB = new int[2*n+1];
        int idx = 1;
        for (int i=2; i<=n; i++) {
            if (arr1[i-1] != arr1[i-2])   {
                freqA[arr1[i-2]] = Math.max(freqA[arr1[i-2]], i-idx);
                idx = i;
            }
        }
        freqA[arr1[n-1]] = Math.max(freqA[arr1[n-1]], n-idx+1);
        idx = 1;
        for (int i=2; i<=n; i++) {
            if (arr2[i-1] != arr2[i-2])   {
                freqB[arr2[i-2]] = Math.max(freqB[arr2[i-2]], i-idx);
                idx = i;
            }
        }
        freqB[arr2[n-1]] = Math.max(freqB[arr2[n-1]], n-idx+1);

        int maxLen = Integer.MIN_VALUE;
        for (int i=0; i<=2*n; i++) {
            maxLen = Math.max(maxLen, freqA[i]+freqB[i]);
        }
        System.out.println(maxLen);
    }

    public static void main(String[] args)  {
        int tc = sc.nextInt();
        sc.nextLine();
        while (tc-- > 0)    {
            solve();
        }
    }
}