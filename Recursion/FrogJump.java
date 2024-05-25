package com.hello;

import java.util.Scanner;

public class FrogJump {
    private static int minimumCost(int i, int []height){
        if(i==height.length-1) return 0;
        int jumpOne = Integer.MAX_VALUE;
        int jumpTwo = Integer.MAX_VALUE;
        if(i<height.length-1) jumpOne = Math.abs(height[i]-height[i+1]) + minimumCost(i+1, height);
        if(i<height.length-2) jumpTwo = Math.abs(height[i]-height[i+2]) + minimumCost(i+2, height);
        return Math.min(jumpOne, jumpTwo);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []height = new int[n];
        for(int i=0; i<n; i++){
            height[i] = sc.nextInt();
        }
        int result = minimumCost(0, height);
        System.out.println("Min Cost: "+result);
    }
}
