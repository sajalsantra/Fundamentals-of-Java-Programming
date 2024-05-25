package com.hello;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Subsequences {
    private static void printSubsequences(String s, String t, List<String> list){
        if(s.isEmpty()){
            list.add(t);
            return;
        }
        char first = s.charAt(0);
        printSubsequences(s.substring(1), t, list);
        printSubsequences(s.substring(1), t+first, list);
    }
    private static List<String> subsequences(String str){
        List<String> list = new ArrayList<>();
        if(str.isEmpty()) {
            list.add(str);
            return list;
        }
        char ch = str.charAt(0);
        List<String> smallAns = subsequences(str.substring(1));
        for(String sa: smallAns){
            list.add(sa);
            list.add(ch+sa);
        }
        return list;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        List<String> result = subsequences(str);
        for(String val : result) System.out.print(val +" ");
        System.out.println();
        List<String> ans = new ArrayList<>();
        printSubsequences(str, "", ans);
        for(String val : ans) System.out.print(val +" ");
        System.out.println();
    }
}
