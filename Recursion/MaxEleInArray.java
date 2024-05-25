package com.hello;

import java.util.Scanner;

public class MaxEleInArray {
    private static int maxEle(int idx, int []arr){
        if(idx == arr.length-1) return arr[idx];
        return Math.max(arr[idx], maxEle(idx+1, arr));
    }
    private static int totalSum(int idx, int []arr){
        if(idx==arr.length-1) return arr[idx];
        return arr[idx] + totalSum(idx+1, arr);
    }
    private static boolean isfound(int idx, int target, int []arr){
        if(idx>= arr.length) return false;
        if(arr[idx]==target) return true;
        return isfound(idx+1, target, arr);
    }
    private static int findIndex(int idx, int target, int []arr){
        if(idx>= arr.length) return -1;
        if(arr[idx]==target) return idx+1;
        return findIndex(idx+1, target, arr);
    }
    private static int findAllIndex(int idx, int target, int []arr){
        if(idx>= arr.length) return -1;
        if(arr[idx]==target){
            System.out.print(idx + " ");
        }
        return findAllIndex(idx+1, target, arr);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Max Element In Array: "+maxEle(0, arr));
        System.out.println("Sum of All Element: "+totalSum(0, arr));
        int target = sc.nextInt();
        if(isfound(0, target, arr)) System.out.println("Target is present");
        else System.out.println("Target is not present");
        System.out.println("Target first index is(1 base index): "+findIndex(0, target, arr));
        System.out.print("Target All index are : ");
        findAllIndex(0, target, arr);
        System.out.println();
    }
}
