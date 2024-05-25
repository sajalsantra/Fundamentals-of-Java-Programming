package com.hello;

import java.util.Scanner;

public class FindGCD {
    private static int findGCD(int x, int y) {
        while (x % y!=0){
            int rem = x % y;
            x = y;
            y = rem;
        }
        return y;
    }
    private static int gcd(int x, int y) {
        if(y==0) return x;
        return gcd(y, x%y);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.println("GCD is: " + findGCD(x, y));
        System.out.println("GCD is: " + gcd(x, y));
    }


}
