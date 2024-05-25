package com.hello;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KeyboardCombination {
    private static void combination(String s, String res, String []kp, List<String> list){
        if(s.isEmpty()){
            list.add(res);
            return;
        }
        int currNum = s.charAt(0)-'0';
        String currChoice = kp[currNum];
        for(int i=0; i<currChoice.length(); i++){
            combination(s.substring(1), res+currChoice.charAt(i), kp, list);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String digit = sc.nextLine();
        List<String> result = new ArrayList<>();
        String []kp ={" ", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        combination(digit, "", kp, result);
        for(String val : result) System.out.print(val + " ");
        System.out.println();
    }
}
