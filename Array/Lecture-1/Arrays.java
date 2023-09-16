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
    public static int calLength(int []arr){  //Calculate arr length without length() function
        int size = 0;
        for(int val : arr) size++;
        return size;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Array Size: ");
        int n = sc.nextInt();
        int []arr = new int[n]; //Inisilize a new Array 
        System.out.print("Enter Array Element: ");
        takeInput(arr);
        System.out.print("The Array is: ");
        printArray(arr);
        sc.close();
        int []arr2 = {1, 3, 4, 6, 9, 7, 10, 5}; //Inisilize a new Array
        System.out.println("Array Size: " + calLength(arr2));
    }
}