import java.util.*;

public class FindAllAnargramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        int ara1[] = new int[26];
        int ara2[] = new int[26];
        List<Integer> list = new ArrayList<>();

        if(s.length()<p.length())
            return list;

        for(int i=0; i<p.length(); i++){
            ara1[s.charAt(i)-'a']++;
            ara2[p.charAt(i)-'a']++;
        }

        int low = 0;
        int high = p.length();

        if(Arrays.equals(ara1,ara2))
            list.add(low);

        while(high<s.length())  {
            ara1[s.charAt(low)-'a']--;
            ara1[s.charAt(high)-'a']++;

            if(Arrays.equals(ara1,ara2))
                list.add(low+1);

            low++;
            high++;
        }
        return list;
    }
}


/*
    private Set<Character> set;
    private int str1Len, str2Len, dupLen;
    private String duplicate;



    public List<Integer> findAnagrams(String str1, String str2) {
        List<Integer> list = new ArrayList<>();
        set = new HashSet<>();

        str1Len = str1.length();
        str2Len = str2.length();
        dupLen = 0;

        String str = new String(str2);

        duplicate = "";

        for (char ch: str2.toCharArray())   {
            if (set.contains(ch))   {
                duplicate += ch;
                dupLen++;
            }
            set.add(ch);
        }


        for (int i=0; i<str1Len; i++)   {
            if (set.contains(str1.charAt(i)))   {
                if (checkValid(str1, i))
                    list.add(i);
            }
        }
        return list;
    }

    private boolean checkValid(String str1, int i) {
        var tempSet = new HashSet<>(set);

        if (i+str2Len > str1Len)
            return false;

        else {
            int j=0;
            boolean check = false;
            while (j<str2Len)   {
                var ch = str1.charAt(i);

                if (!tempSet.contains(ch))  {
                    if (dupLen == 0)
                        return false;

                    else {
                        for (int k=0; k<dupLen; k++)    {
                            if (ch == duplicate.charAt(k))
                                check = true;
                        }
                        if (check == true)  {
                            i++;
                            j++;
                            continue;
                        }

                        else
                            return false;
                    }
                }

                else
                    tempSet.remove(ch);

                i++;
                j++;
            }
        }
        return true;
    }
 */
