package Sorting;

import java.util.Scanner;

public class QuickSort{
    public static void printArray(int []arr){
        for(int val : arr) System.out.print(val+" ");
        System.out.println();
    }
    private static void swap(int i, int j, int []arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private static int partition(int[] arr, int st, int end) {
        int pivot = arr[st];
        int count = 0;
        for(int i=st+1; i<=end; i++){
            if(arr[i] <= pivot) count++;
        }
        int pivotIdx = st + count;
        swap(st, pivotIdx, arr);
        int i = st;
        int j = end;
        while (i < pivotIdx && j > pivotIdx) {
            while (arr[i]<=pivot) i++;
            while (arr[j]>pivot) j--;
            if(i < pivotIdx && j > pivotIdx){
                swap(i, j, arr);
                i++;
                j--;
            }
        }
        return pivotIdx;
    }
    public static void quickSort(int st, int end, int []arr){
        if(st >= end) return;
        int pi = partition(arr, st, end);
        quickSort(st, pi-1, arr);
        quickSort(pi+1, end, arr);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        quickSort(0, n-1, arr);
        printArray(arr);
        sc.close();
    }
}