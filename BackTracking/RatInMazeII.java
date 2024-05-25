package com.hello;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RatInMazeII {
    static List<String> list;
    private static int mazeII(int i, int j, int n, int m, String str, boolean [][] isVisit){
        if(i<0 || i>n || j<0 || j>m) return 0;
        if(isVisit[i][j]) return 0;
        if(i==n && j==m){
            list.add(str);
            return 1;
        }

        isVisit[i][j] = true;
        int right = mazeII(i, j+1, n, m, str+"R", isVisit);
        int left = mazeII(i, j-1, n, m, str+"L", isVisit);
        int up = mazeII(i-1, j, n, m, str+"U", isVisit);
        int down = mazeII(i+1, j, n, m, str+"D", isVisit);
        isVisit[i][j] = false;
        return left + right + up + down;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean [][] isVisit = new boolean[n][m];
        list = new ArrayList<>();
        int result = mazeII(0, 0, n-1, m-1, "", isVisit);
        System.out.println(result);
        for (String str : list) System.out.println(str);
    }
}
