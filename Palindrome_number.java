import java.util.Scanner;
public class Palindrome_number {
    public boolean isPalindrome(int x) {
        int rev=0, check = x;

        if (check == 0) return true;
        
        while (x>0) {
            rev *= 10;
            rev += x % 10;
            x /= 10;
        }

        if (rev == check)   return true;
        else    return false;
    }
    static Scanner any = new Scanner(System.in);
    
    public static void main(String[] args)  {
        Palindrome_number aa = new Palindrome_number();
        
        
        System.out.println (aa.isPalindrome(any.nextInt()));
    }
}