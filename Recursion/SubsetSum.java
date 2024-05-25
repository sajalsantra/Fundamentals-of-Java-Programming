package com.hello;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubsetSum {
    private static void subsetSum(int idx, int sum, int []arr, List<Integer>list){
        if(idx==arr.length){
            list.add(sum);
            return;
        }
        subsetSum(idx+1, sum, arr, list);
        subsetSum(idx+1, sum+arr[idx], arr, list);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        List<Integer> result = new ArrayList<>();
        subsetSum(0, 0, arr, result);
        for(int val : result) System.out.print(val+" ");
        System.out.println();
    }
}
