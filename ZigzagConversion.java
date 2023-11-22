public class ZigzagConversion {
    public String convert(String s, int rows) {
        if (rows == 1)
            return s;

        StringBuilder[] strs = new StringBuilder[rows];
        boolean bottom = true, top = false;
        int index = 0;
        for (int i=0; i<rows; i++)
            strs[i] = new StringBuilder();

        for (var ch: s.toCharArray())   {
            strs[index].append(ch);
            if (bottom) {
                if (index == rows-1)    {
                    bottom = false;
                    top = true;
                    index--;
                }
                else
                    index++;
            }
            else if (top)   {
                if (index == 0) {
                    top = false;
                    bottom = true;
                    index++;
                }
                else
                    index--;
            }
        }
        String str = "";
        for (var tempStr: strs)
            str += tempStr.toString();

        return str;
    }
}

/* 1ms Runtime :
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int step = numRows * 2 - 2;
        int size = s.length();
        int row = 0;
        int index = 0;
        int subStep = step;
        char[] chars = new char[size];
        for (int i = 0; i < size; i++) {
            chars[i] = s.charAt(index);
            if (subStep > 0 && subStep < step && index + subStep < size) {
                chars[++i] = s.charAt(index + subStep);
            }
            index += step;
            if (index >= size) {
                index = ++row;
                subStep -= 2;
            }
        }
        return new String(chars);
    }
}





###################### 2ms runtime :
import java.util.ArrayList;
import java.util.List;

class Solution {
    public String convert(String s, int numRows)
  {
    if(numRows == 1 || s.length() <= numRows)
    {
      return s;
    }

    StringBuilder[] rows = new StringBuilder[numRows];
    for(int i = 0; i < numRows; i++)
    {
      rows[i] = new StringBuilder();
    }

    int index = 0;
    int direction = -1;
    for(char c : s.toCharArray())
    {
      rows[index].append(c);
      if(index == 0) {
        direction = 1; // Change direction to down if reaching the first row
      } else if (index == numRows-1)
      {
        direction = -1; // Change direction to up if reaching the last row
      }
      index += direction;
    }

    StringBuilder result = new StringBuilder();
    for(StringBuilder row: rows) {
      result.append(row);
    }
    return result.toString();
  }
}
 */
