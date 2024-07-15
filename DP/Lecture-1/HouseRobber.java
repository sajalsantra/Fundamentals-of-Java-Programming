
import java.util.Arrays;

class Solution {
    public int helper(int i, int []nums, int []dp){
        if(i<0) return 0;
        if(dp[i]!=-1) return dp[i];

        int pick = nums[i] + helper(i-2, nums, dp);
        int notPick = helper(i-1, nums, dp);
        return dp[i] = Math.max(pick, notPick);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int []dp = new int[n];
        Arrays.fill(dp, -1);
        return helper(n-1, nums, dp);
    }
}

public class HouseRobber {
    public static void main(String[] args) {
        
    }
}
