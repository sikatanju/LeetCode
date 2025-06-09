public class StringCompression {
    public int compress(char[] chars) {
        String temp = "";
        char prev = chars[0];
        int prevIdx = 0, n = chars.length, idx = 0;
        int currIdx = 0;
        for (int i=1; i<n; i++) {
            if (chars[i] != prev)  {
                if (i-currIdx > 1)  {
                    String str = String.valueOf(i-currIdx);
                    int len = str.length();

                    chars[prevIdx++] = prev;
                    prev = chars[i];
                    currIdx = i;
                    idx = 0;
                    while (len-- > 0)
                        chars[prevIdx++] = str.charAt(idx++);
                }   else    {
                    chars[prevIdx++] = prev;
                    prev = chars[i];
                    currIdx = i;
                }
            }
        }
        if (n-currIdx > 1)    {
            String str = String.valueOf(n-currIdx);
            int len = str.length();
            idx = 0;
            chars[prevIdx++] = prev;
            while (len-- > 0)
                chars[prevIdx++] = str.charAt(idx++);
        }   else    {
            chars[prevIdx++] = prev;
        }
        return prevIdx;
    }
}

/* Best runtime: 0ms
class Solution {
    public int compress(char[] chars) {
        int len=0;
        int cnt=0;
        char ch=chars[0];
        int n=chars.length;
        for(int i=0;i<n;i++) {
            if(ch==chars[i]) ++cnt;
            else {
                if(cnt==1) {
                    chars[len]=ch;
                    ++len;
                } else {
                    chars[len]=ch;
                    ++len;
                    if(cnt<10) {
                        chars[len]=(char)(cnt+'0');
                        ++len;
                    }
                    else {
                        char[] tmp=String.valueOf(cnt).toCharArray();
                        for(char c: tmp) {
                            chars[len]=c;
                            ++len;
                        }
                    }
                }
                cnt=1;
                ch=chars[i];
            }
        }
        if(cnt==1) {
            chars[len]=ch;
            ++len;
        } else {
            chars[len]=ch;
            ++len;
            if(cnt<10) {
                chars[len]=(char)(cnt+'0');
                ++len;
            }
            else {
                char[] tmp=String.valueOf(cnt).toCharArray();
                for(char c: tmp) {
                    chars[len]=c;
                    ++len;
                }
            }
        }
        return len;
    }
}
 */
