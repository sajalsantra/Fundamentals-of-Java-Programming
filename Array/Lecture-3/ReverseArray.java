import java.util.Scanner;

public class ReverseArray {
    private static void printArray(int []arr){
        for(int val : arr) System.out.print(val+" ");
        System.out.println();
    }
    private static void swap (int []arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private static void reverse(int []arr){
        int left = 0;
        int right = arr.length-1;
        while(left<right){
            swap(arr, left, right);
            left++;
            right--;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Array Size: ");
        int n = sc.nextInt();
        int []arr = new int[n];
        System.out.print("Enter The Arrey Element: ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        printArray(arr);
        reverse(arr);
        System.out.println("After Reverse The Array: ");
        printArray(arr);
    }
}
