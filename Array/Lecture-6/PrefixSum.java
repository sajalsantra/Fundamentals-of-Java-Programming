import java.util.Scanner;

public class PrefixSum{

    private static void prefixSum(int []arr){
        int []prefixSum = new int[arr.length];
        prefixSum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) prefixSum[i] = arr[i] + prefixSum[i - 1];
        System.out.print("PreFix Sum Array: ");
        for (int i = 0; i < arr.length; i++) System.out.print(prefixSum[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Array Size: ");
        int n = sc.nextInt();
        int []arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        prefixSum(arr);
    }
}