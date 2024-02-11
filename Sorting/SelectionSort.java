package Sorting;

import java.util.Scanner;

public class SelectionSort {
    public static void printArray(int []arr){
        for(int val : arr){
            System.out.print(val +" ");
        }
        System.out.println();
    }
    public static void selectionSort(int []arr){
        int n = arr.length;
        for(int i=0; i<n-1; i++){
            int minIdx = i;
            for(int j=i+1; j<n; j++){
                if(arr[minIdx] > arr[j]) minIdx = j;
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();
        printArray(arr);
        selectionSort(arr);
        printArray(arr);
        sc.close();
    }    
}