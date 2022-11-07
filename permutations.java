import java.util.*;

public class permutations {
    public static int[] repeat(int[] araa) {
        int [] ara = new int[araa.length];
        int len = araa.length;

        for (int i=0; i<len; i++)   {
            for (int j=0; j<len; j++) {
                if (j == i)
                    j++;
                if (j == len)
                    break;

                int count = 0, upto = len - 2;
                int jj = j;
                while (count++ < upto)    {
                    if (j==len)
                        j = 0;

                    ara[0] = araa[i];
                    ara[1] = araa[j];
                    int last;
                    if (jj+1 == len)
                        last = 0;
                    else
                        last = ++jj;

                    int k = 2;
                    while (k < upto + 2)   {
                        if (last == i || last == j || last == len) {
                            if (last == i && last+1 ==j)
                                last += 2;
                            else
                                last++;

                            if (last == len)
                                last = 0;
                            continue;
                        }
                        if (ara[k] == araa[last])
                            last++;
                        else    {
                            ara[k++] = araa[last++];
                        }
                        if (last == len)  {
                            if (i==0 && j!=1)
                                last = 1;
                            else if (i==0 && j==1)
                                last = 2;
                            else
                                last = 0;
                        }
                    }
                    System.out.println (Arrays.toString(ara));
                }
            }
        }
        int[] arra = {1};
        return arra;
    }
    public static void main(String[] args)  {
        int[] ara = {1, 2, 3, 4, 5, 6};
        repeat(ara);
    }
}


    /****************************************
    public static int[] repeat(int[] araa) {
        int [] ara = new int[araa.length];
        int len = araa.length;
        for (int i=0; i<len; i++)   {
            for (int j=0; j<len; j++) {
                if (j == i)
                    j++;
                if (j == len)
                    break;

                int count = 0, upto = len - 2;
                int jj = j;
                while (count++ < upto)    {
                    if (j==len)
                        j = 0;

                    ara[0] = araa[i];
                    ara[1] = araa[j];
                    int last;
                    if (jj+1 == len)
                        last = 0;
                    else
                        last = ++jj;
                    int k = 2;
                    while (k < upto + 2)   {
                        if (last == i || last == j || last == len) {
                            if (last == i && last+1 ==j)
                                last += 2;
                            else
                                last++;
                            if (last == len)
                                last = 0;
                            continue;
                        }
                        if (ara[k] == araa[last])
                            last++;
                        else    {
                            ara[k++] = araa[last++];
                        }
                        if (last == len)  {
                            if (i==0 && j!=1)
                                last = 1;
                            else if (i==0 && j==1)
                                last = 2;
                            else
                                last = 0;
                        }
                    }
                    System.out.println (Arrays.toString(ara));
                }
            }
        }
        int[] arra = {1};
        return arra;
    }
    *******************************************/