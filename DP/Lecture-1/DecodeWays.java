class Solution {
    @SuppressWarnings("unused")
    private int helper(String str, int idx, int []dp){
        if(idx<=0) return 1;
        if(dp[idx]!=-1) return dp[idx];
        int pickOne = 0;
        int pickDouble = 0;
        if(str.charAt(idx)!='0') pickOne = helper(str, idx-1, dp);
        if(str.charAt(idx-1)=='1' || str.charAt(idx-1)=='2' && str.charAt(idx)<='6') pickDouble = helper(str, idx-2, dp);
        return dp[idx] = pickOne + pickDouble;
    }
    public int numDecodings(String s) {
        int n = s.length();
        if(n==0 || s.charAt(0)=='0') return 0;
        int []dp = new int[n+1];
        
        // Arrays.fill(dp, -1);
        // return helper(s, n-1, dp);

        dp[0] = 1;
        dp[1] = (s.charAt(0)=='0') ? 0 : 1;
        for(int idx=2; idx<=n; idx++){
            int pickOne = 0;
            int pickDouble = 0;
            if(s.charAt(idx-1)!='0') pickOne = dp[idx-1];
            if(s.charAt(idx-2)=='1' || s.charAt(idx-2)=='2' && s.charAt(idx-1)<='6') pickDouble = dp[idx-2];
            dp[idx] = pickOne + pickDouble;
        }
        return dp[n];
    }
}

public class DecodeWays {
    public static void main(String[] args) {
        
    }
}
