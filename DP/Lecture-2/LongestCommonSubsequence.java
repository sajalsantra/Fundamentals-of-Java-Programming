import java.util.Scanner;

public class LongestCommonSubsequence {
    private static int helper(int i, int j, String s, String t){
        if(i < 0 || j < 0) return 0;

        if(s.charAt(i)==t.charAt(j)) return 1 + helper(i-1, j-1, s, t);
        return Math.max(helper(i-1, j, s, t), helper(i, j-1, s, t));
    }
    public static int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        return helper(n-1, m-1, text1, text2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text1 = sc.next();
        String text2 = sc.next();
        int result = longestCommonSubsequence(text1, text2);
        System.out.println(result);
        sc.close();
    }
}
