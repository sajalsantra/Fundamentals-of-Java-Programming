package com.hello;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RatInMaze {
    private static int maze(int n, int m){
        if(n==0 || m==0) return 0;
        if(n==1 && m==1) return 1;
        return maze(n-1, m) + maze(n, m-1);
    }
    private static void printPath(int n, int m, String str, List<String> list){
        if(n==0 || m==0) return ;
        if(n==1 && m==1) {
            list.add(str);
            return;
        }
        printPath(n, m-1, str+"R", list);
        printPath(n-1, m, str+"D", list);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int result = maze(n, m);
        System.out.println(result);
        List<String> list = new ArrayList<>();
        printPath(n, m, "", list);
        for(String val : list) System.out.println(val);
    }
}
