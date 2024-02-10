package Sorting;

import java.util.Scanner;

class BubbleSort {
    public static void printArray(int []arr){
        for(int val : arr){
            System.out.print(val+" ");
        }
        System.out.println();
    }
    
    public static void bubbleSort(int []arr){
        int n = arr.length;
        for(int i=0; i<n-1; i++){
            boolean flag = false;   //Check any swaping happend or not
            for(int j=0; j<n-i-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;
                }
            }
            if(!flag) break;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();
        printArray(arr);
        bubbleSort(arr);
        printArray(arr);
        sc.close();
    }
}