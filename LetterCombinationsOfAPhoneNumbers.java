import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumbers {
    private List<String> stringList;
    private Map<Character, char[]> map;
    private char[] araOne = {'a', 'b', 'c'};
    private char[] araTwo = {'d', 'e', 'f'};
    private char[] araThree = {'g', 'h', 'i'};
    private char[] araFour = {'j', 'k', 'l'};
    private char[] araFive = {'m', 'n', 'o'};
    private char[] araSix = {'p', 'q', 'r', 's'};
    private char[] araSeven = {'t', 'u', 'v'};
    private char[] araEight = {'w', 'x', 'y', 'z'};
    private String ara;

    public List<String> letterCombinations(String digits) {
        int digitLen = digits.length();
        this.ara = digits;

        stringList = new ArrayList<>();
        if (digitLen == 0)
            return stringList;

        map = new HashMap<>();
        map.put('2', araOne);
        map.put('3', araTwo);
        map.put('4', araThree);
        map.put('5', araFour);
        map.put('6', araFive);
        map.put('7', araSix);
        map.put('8', araSeven);
        map.put('9', araEight);

        switch (digitLen)   {
            case 1 -> callOne();
            case 2 -> callTwo();
            case 3 -> callThree();
            default -> callFour();
        }
        return stringList;
    }

    private void callFour() {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = new StringBuilder();

        char one = ara.charAt(0);
        char two = ara.charAt(1);
        char three = ara.charAt(2);
        char four = ara.charAt(3);

        char[] oneAra = map.get(one);
        char[] twoAra = map.get(two);
        char[] threeAra = map.get(three);
        char[] fourAra = map.get(four);

        for (int i=0; i<4; i++) {
            if (i==3 && (one == '7' || one == '9'))
                sb.append(oneAra[i]);
            else if (i<3)
                sb.append(oneAra[i]);
            else
                break;

            for (int j=0; j<4; j++) {
                sb2.append(sb);

                if (j==3 && (two == '7' || two == '9'))
                    sb2.append(twoAra[j]);
                else if (j<3)
                    sb2.append(twoAra[j]);
                else
                    break;

                for (int k=0; k<4; k++) {
                    sb3.append(sb2);
                    if (k==3 && (three == '7' || three == '9'))
                        sb3.append(threeAra[k]);
                    else if (k<3)
                        sb3.append(threeAra[k]);
                    else
                        break;

                    for (int l=0; l<4; l++) {
                        sb4.append(sb3);

                        if (l==3 && (four == '7' || four == '9'))
                            sb4.append(fourAra[l]);
                        else if (l<3)
                            sb4.append(fourAra[l]);
                        else
                            break;

                        stringList.add(sb4.toString());
                        sb4 = new StringBuilder();
                    }
                    sb4 = new StringBuilder();
                    sb3 = new StringBuilder();
                }
                sb3 = new StringBuilder();
                sb2 = new StringBuilder();
            }
            sb2 = new StringBuilder();
            sb = new StringBuilder();
        }
    }

    private void callThree() {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();

        char one = ara.charAt(0);
        char two = ara.charAt(1);
        char three = ara.charAt(2);

        char[] oneAra = map.get(one);
        char[] twoAra = map.get(two);
        char[] threeAra = map.get(three);

        for (int i=0; i<4; i++) {
            if (i==3 && (one == '7' || one == '9'))
                sb.append(oneAra[i]);
            else if (i<3)
                sb.append(oneAra[i]);
            else
                break;
            for (int j=0; j<4; j++)  {
                sb2.append(sb);

                if (j==3 && (two == '7' || two == '9'))
                    sb2.append(twoAra[j]);
                else if (j<3)
                    sb2.append(twoAra[j]);
                else
                    break;

                for (int k=0; k<4; k++) {
                    sb3.append(sb2);
                    if (k==3 && (three == '7' || three == '9'))
                        sb3.append(threeAra[k]);
                    else if (k<3)
                        sb3.append(threeAra[k]);
                    else
                        break;

                    stringList.add(sb3.toString());
                    sb3 = new StringBuilder();
                }
                sb3 = new StringBuilder();
                sb2 = new StringBuilder();
            }
            sb2 = new StringBuilder();
            sb = new StringBuilder();
        }
    }

    private void callTwo() {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        char one = ara.charAt(0);
        char two = ara.charAt(1);

        char[] oneAra = map.get(one);
        char[] twoAra = map.get(two);

        for (int i=0; i<4; i++) {
            if (i==3 && (one == '7' || one == '9'))
                sb.append(oneAra[i]);
            else if (i<3)
                sb.append(oneAra[i]);
            else
                break;

            for (int j=0; j<4; j++) {
                sb2.append(sb);

                if (j==3 && (two == '7' || two == '9'))
                    sb2.append(twoAra[j]);
                else if (j<3)
                    sb2.append(twoAra[j]);
                else
                    break;

                stringList.add(sb2.toString());
                sb2 = new StringBuilder();
            }
            sb = new StringBuilder();
            sb2 = new StringBuilder();
        }
    }

    private void callOne() {
        StringBuilder sb = new StringBuilder();
        for (var ch: map.get(ara.charAt(0)))   {
            stringList.add(sb.append(ch).toString());
            sb = new StringBuilder();
        }
    }
}
