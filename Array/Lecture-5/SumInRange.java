import java.util.Scanner;

public class SumInRange {
    private static void printArray(int []a){
        for(int x : a) System.out.print(x+" ");
        System.out.println();
    }
    private static void prefixSumArray(int []arr){
        for(int i=1; i<arr.length; i++){
            arr[i] = arr[i-1]+arr[i];
        }
    }
    private static int sumInRange(int []arr, int l, int r){
        return arr[r-1]-arr[l-1];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Array Size:");
        int n = sc.nextInt();
        int []arr = new int[n];
        System.out.print("Enter The Arrey Element: ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        printArray(arr);
        prefixSumArray(arr);
        System.out.print("Enter Queries Time: ");
        int t = sc.nextInt();
        while(t>0){
            System.out.print("Enter The Range: ");
            int l = sc.nextInt();
            int r = sc.nextInt();
            System.out.println(sumInRange(arr, l, r));
            t--;
        }
    }
}
