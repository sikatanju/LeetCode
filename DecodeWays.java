public class DecodeWays {
    public int numDecodings(String s) {
        int dpLow = 1, dpHigh = 0, len = s.length();
        for (int i=len-1; i>=0; i--)    {
            var dp = s.charAt(i) == '0' ? 0 : dpLow;
            if (i < len-1 && (s.charAt(i) == '1' || s.charAt(i)=='2' && s.charAt(i+1) < '7'))
                dp += dpHigh;

            dpHigh = dpLow;
            dpLow = dp;
        }
        return dpLow;
    }
}



//public int numDecodings(String s) {
//    int dpLow=1, dpHigh=0, n=s.length();
//    for(int i=n-1;i>=0;i--) {
//        int dp=s.charAt(i)=='0'?0:dpLow;
//        if(i<n-1&&(s.charAt(i)=='1'||s.charAt(i)=='2'&&s.charAt(i+1)<'7'))
//            dp+=dpHigh;
//        dpHigh=dpLow;
//        dpLow=dp;
//    }
//    return dpLow;
//}