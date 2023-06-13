/*import java.util.Scanner;


public class RomanToInteger {
    static Scanner any = new Scanner(System.in);

    /*public int romanToInt(String str)    {
        int num = 0, limit = str.length();
        for (int i=0; i<str.length(); i++)  {
            if (str.charAt(i) == 'I' && i != limit-1 && str.charAt(i+1) == 'V') {
                num += 4;
                i++;
                continue;
            }
            if (str.charAt(i) == 'I'&& i != limit-1  && str.charAt(i+1) == 'X') {
                num += 9;
                i++;
                continue;
            }
            if (str.charAt(i) == 'I')   num += 1;

            if (str.charAt(i) == 'V')   num += 5;

            if (str.charAt(i) == 'X' && i != limit-1  && str.charAt(i+1) == 'L')    {
                num += 40;
                i++;
                continue;
            }
            if (str.charAt(i) == 'X' && i != limit-1  && str.charAt(i+1) == 'C')    {
                num += 90;
                i++;
                continue;
            }
            if (str.charAt(i) == 'X')   num += 10;

            if (str.charAt(i) == 'L')   num += 50;

            if (str.charAt(i) == 'C' && i != limit-1  && str.charAt(i+1) == 'D')    {
                num += 400;
                i++;
                continue;
            }
            if (str.charAt(i) == 'C' && i != limit-1  && str.charAt(i+1) == 'M')    {
                num += 900;
                i++;
                continue;
            }
            if (str.charAt(i) == 'C')   num += 100;
            if (str.charAt(i) == 'D')   num += 500;
            if (str.charAt(i) == 'M')   num += 1000;    
        }
        return num;
    }
    public static void main(String[] args)  {
        String str = any.nextLine();
        RomanToInteger obj = new RomanToInteger();
        System.out.println (obj.romanToInt(str));
    }
}*/