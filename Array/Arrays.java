package Array;

import java.util.Scanner;

public class Arrays {
    public static void takeInput(int []arr){
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
    }
    public static void printArray(int []arr){
        for(int val : arr) System.out.print(val+" ");
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Array Size: ");
        int n = sc.nextInt();
        int []arr = new int[n];
        System.out.print("Enter Array Element: ");
        takeInput(arr);
        System.out.print("The Array is: ");
        printArray(arr);
        sc.close();
    }
}