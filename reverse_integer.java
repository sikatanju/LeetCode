import java.util.Scanner;

public class reverse_integer {
    static Scanner any = new Scanner(System.in);
    public int reverse(int x)   {
        int rev = 0, i=0, count = 0;

        if (x >= 0)    {
            while (x > 0)   {
                rev *= 10;
                rev += x % 10;
                x /= 10;
            }
            return rev;
        }
        else    {
            while (x<0) {

                rev += x % 10;
                x /= 10;
            }
            return rev;
        }
    }
    public static void main(String[] args)  {
        reverse_integer obj = new reverse_integer();
        System.out.println (obj.reverse(any.nextInt()));
    }
}
