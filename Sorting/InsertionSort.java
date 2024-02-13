package Sorting;

import java.util.Scanner;

public class InsertionSort {

    public static void printArray(int []arr){
        for(int val : arr){
            System.out.print(val +" ");
        }
        System.out.println();
    }
    public static void insertionSort(int []arr){
        for(int i=1; i<arr.length; i++){
            int j = i;
            while (j>0 && arr[j]<arr[j-1]){
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;              
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();
        insertionSort(arr);
        printArray(arr);
        sc.close();
    }
}