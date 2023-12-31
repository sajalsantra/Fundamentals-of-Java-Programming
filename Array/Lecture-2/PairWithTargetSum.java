import java.util.Scanner;

public class PairWithTargetSum {
    public static int targetSum(int []arr, int target){  //T.C - O(N^2)
        int n = arr.length;
        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(arr[i]+arr[j]==target) count++;
            }
        }
        return count;
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
        System.out.println(targetSum(arr, 5));
    }
}
