import java.util.*;
class FibonacciNumber{
    
    private static long helper(int i, long []dp){
        if(i<=1) return i;
        if(dp[i]!=-1) return dp[i];
        
        return dp[i] = (helper(i-1, dp) + helper(i-2, dp)) % 1000000007;
    }
    private  static long topDown(int n) {
        long []dp = new long[n+1];
        Arrays.fill(dp, -1);
        return helper(n, dp);
    }

    static long bottomUp(int n) {
        
        long []dp = new long[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<=n; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
        }
        // return dp[n];

        long i0 = 0;
        long i1 = 1;
        for(int i=2; i<=n; i++){
            long temp = (i1 + i0) % 1000000007;
            i0 = i1;
            i1 = temp;
        }
        return i1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Number: ");
        int n = sc.nextInt();
        System.out.println("TopDown Result is: "+topDown(n));
        System.out.println("Bottom Up Result: "+bottomUp(n));
    }
}
