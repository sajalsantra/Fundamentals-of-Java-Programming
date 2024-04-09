package Sorting;

import java.util.Scanner;

public class RadixSort {

    public static void printArray(int []arr){
        for(int val : arr) System.out.print(val+" ");
        System.out.println();
    }
    public static int findMax(int []arr){
        int max = Integer.MIN_VALUE;
        for(int val : arr){
            max = Math.max(max, val);
        }
        return max;
    }
    public static void countSort(int []arr, int place){
        int n = arr.length;
        int []count = new int[10];
        for(int val : arr){
            int idx = (val/place)%10;
            count[idx]++;
        }
        for(int i=1; i<=9; i++){
            count[i] += count[i-1];
        }
        int []output = new int[n];
        for(int i=n-1; i>=0; i--){
            int val = (arr[i]/place)%10;
            int idx = count[val]-1;
            output[idx] = arr[i];
            count[val]--;
        }
        for(int i=0; i<n; i++){
            arr[i] = output[i];
        }
    }
    public static void radixSort(int []arr){
        int max = findMax(arr);
        for(int place=1; max/place>0; place*=10){
            countSort(arr, place);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        radixSort(arr);
        printArray(arr);
    }
}
