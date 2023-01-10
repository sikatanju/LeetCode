public class addDigits {
    public int addNum(int num)  {
        if (num < 10)
            return num;

        while (num > 9) {
            int temp = 0;
            while (num > 0) {
                temp += num % 10;
                num /= 10;
            }
            if (temp < 10)
                return temp;
            else
                num = temp;
        }
        return num;
    }
}
