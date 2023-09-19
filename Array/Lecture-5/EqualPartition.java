import java.util.Scanner;

public class EqualPartition {
    private static void printArray(int []a){
        for(int x : a) System.out.print(x+" ");
        System.out.println();
    }
    private static int findSumArray(int []arr){
        int sum = 0;
        for(int val : arr) sum += val;
        return sum;
    }
    private static boolean isPossible(int []arr) {
        int totalSum = findSumArray(arr);
        int prefixSum = 0;
        for(int i=0; i<arr.length; i++){
            prefixSum += arr[i];
            int sufixSum = totalSum - prefixSum;
            if(prefixSum == sufixSum) return true;
        }
        return false;
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
        if(isPossible(arr)) System.out.println("YES");
        else System.out.println("NO");
    }
}
