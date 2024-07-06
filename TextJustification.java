import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> strings = new ArrayList<>();
        int index = 0;
        while (index < words.length)    {
            int currentWidth = words[index].length();
            int next = index+1;
            while (next < words.length) {
                if (currentWidth + words[next].length()+1 > maxWidth)
                    break;

                currentWidth += words[next++].length() + 1;
            }
            StringBuilder builder = new StringBuilder();
            int numOfWords = next - index - 1;
            if (next == words.length || numOfWords == 0)   {
                for (int i=index; i<next; i++)    {
                    if (i!=index)
                        builder.append(' ');

                    builder.append(words[i]);
                }
                for (int i=builder.length(); i<maxWidth; i++)
                    builder.append(' ');

                strings.add(builder.toString());
            }   else {
                int spaces = (maxWidth - currentWidth) / numOfWords;
                int remainingSpaces = (maxWidth - currentWidth) % numOfWords;
                for (int i=index; i<next; i++)  {
                    builder.append(words[i]);
                    if (i < next-1) {
                        for (int j=0; j <= (spaces + ((i-index) < remainingSpaces ? 1: 0)); j++)
                            builder.append(' ');
                    }
                }
                strings.add(builder.toString());
            }
            index = next;
        }
        return strings;
    }
}

/*
class Solution {
    public List<String> fullJustify(String[] words, int L) {
        List<String> lines = new ArrayList<String>();

        int index = 0;
        while (index < words.length) {
            int count = words[index].length();
            int last = index + 1;
            while (last < words.length) {
                if (words[last].length() + count + 1 > L) break;
                count += words[last].length() + 1;
                last++;
            }

            StringBuilder builder = new StringBuilder();
            int diff = last - index - 1;
            // if last line or number of words in the line is 1, left-justified
            if (last == words.length || diff == 0) {
                for (int i = index; i < last; i++) {
                    builder.append(words[i] + " ");
                }
                builder.deleteCharAt(builder.length() - 1);
                for (int i = builder.length(); i < L; i++) {
                    builder.append(" ");
                }
            } else {
                // middle justified
                int spaces = (L - count) / diff;
                int r = (L - count) % diff;
                for (int i = index; i < last; i++) {
                    builder.append(words[i]);
                    if (i < last - 1) {
                        for (int j = 0; j <= (spaces + ((i - index) < r ? 1 : 0)); j++) {
                            builder.append(" ");
                        }
                    }
                }
            }
            lines.add(builder.toString());
            index = last;
        }
        return lines;
    }
}


/* I tried :

        List<String> stringList = new ArrayList<>();
        int index = 0, currentWidth = 0, numOfWords = 0;
        StringBuilder builder = new StringBuilder();

        while (currentWidth <= maxWidth) {
            int tempIndex = index;
            boolean lastNotSpace = false;
            for (; tempIndex < words.length; tempIndex++)   {
                int currentLen = words[tempIndex].length();
                if ((currentWidth + currentLen) > maxWidth)
                    break;
                else {
                    currentWidth += currentLen;
                    if (currentWidth == maxWidth)   {
                        lastNotSpace = true;
                        break;
                    }
                    currentWidth++;
                    numOfWords++;
                }
            }
            if (currentWidth == maxWidth && lastNotSpace)
                currentWidth -= (numOfWords-1);
            else
                currentWidth -= numOfWords;

            if (tempIndex == words.length) {
                while(numOfWords-- > 0) {
                    builder.append(words[index++]);
                    builder.append(' ');
                }
                int leftSpaces = maxWidth = currentWidth;
                while (leftSpaces-- > 0)
                    builder.append(' ');

                stringList.add(builder.toString());
                return stringList;
            }
            if (numOfWords == 1)    {
                int numOfSpaces = maxWidth - currentWidth;
                builder.append(words[index++]);
                while (numOfSpaces-- > 0)
                    builder.append(' ');

                stringList.add(builder.toString());
                builder = new StringBuilder();
            }
            else if (currentWidth == maxWidth)   {
                while (numOfWords-- > 0)    {
                    builder.append(words[index++]);
                    builder.append(' ');
                }
                stringList.add(builder.toString());
                builder = new StringBuilder();
            } else {
                int numOfSpaces = maxWidth - currentWidth, spaceBetweenFirst = 0, spaceBetweenRest = 0;
                if (numOfSpaces % (numOfWords-1)  == 0)  {
                    spaceBetweenRest = numOfSpaces / (numOfWords-1);
                    spaceBetweenFirst = spaceBetweenRest;
                }   else if (numOfSpaces % (numOfWords-1) >= 1) {
                    spaceBetweenFirst = numOfSpaces / (numOfWords-1);
                    spaceBetweenRest = spaceBetweenFirst;
                    spaceBetweenFirst++;
                }
                boolean firstCheck = false;
                while (numOfWords-- > 0) {
                    builder.append(words[index++]);
                    if (numOfWords == 0)
                        break;

                    if (!firstCheck)    {
                        while (spaceBetweenFirst-- > 0)
                            builder.append(' ');

                        firstCheck = true;
                    }
                    else {
                        int tempSpace = spaceBetweenRest;
                        while (tempSpace-- > 0) {
                            builder.append(' ');
                        }
                    }
                }
                stringList.add(builder.toString());
                builder = new StringBuilder();
            }
            currentWidth = numOfWords = 0;
        }
        return stringList;
    }
 */
