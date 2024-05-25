package com.hello;

import java.util.Scanner;

public class StringOperation {
    private static String removeAllChar(int i, String str, char ch) {
        if(i==str.length()) return "";
        return str.charAt(i)==ch ? removeAllChar(i+1, str, ch) :
                str.charAt(i) + removeAllChar(i+1, str, ch);
    }
    private static String removeAllChar2(String str, char ch) {
        if(str.isEmpty()) return "";
        return str.charAt(0)==ch ? removeAllChar2(str.substring(1), ch) :
                str.charAt(0) + removeAllChar2(str.substring(1), ch);
    }
    private static String reverse(String str) {
        if(str.isEmpty()) return "";
        return reverse(str.substring(1))+str.charAt(0);
    }
    private static boolean isPalindrome(String str, int l, int r){
        if(l==r) return true;
        return str.charAt(l)==str.charAt(r) && isPalindrome(str, l+1, r-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char ch = sc.next().charAt(0);
        System.out.println(removeAllChar(0, str, ch));
        System.out.println(removeAllChar2(str, ch));
        System.out.println(reverse(str));
        if(isPalindrome(str, 0, str.length()-1)) System.out.println("it's Palindrome");
        else System.out.println("not Palindrome");
    }

}
