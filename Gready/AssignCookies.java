
import java.util.Arrays;


class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int n = g.length;
        int m = s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        while(i < n && j < m){
            if(g[i]<=s[j]) i++;
            j++;
        }
        return i;
    }
}

public class AssignCookies {
    public static void main(String[] args) {
        int[] g = {1,2,3};
        int[] s = {1,1,2};
        Solution ac = new Solution();
        System.out.println(ac.findContentChildren(g, s)); // Output: 2
    }
}
