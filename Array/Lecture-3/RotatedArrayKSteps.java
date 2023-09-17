import java.util.Scanner;

public class RotatedArrayKSteps {
    private static void printArray(int []arr){
        for(int val : arr) System.out.print(val+" ");
        System.out.println();
    }
    private static int[] rotated(int []arr, int k){ //T.C - O(N) & S.C - O(N)
        int n = arr.length;
        if(k>=n)k = k % n;
        int []ans = new int[n];
        int j = 0;
        for(int i=k; i<n; i++){
            ans[j++] = arr[i];
        }
        for(int i=0; i<k; i++){
            ans[j++] = arr[i];
        }
        return ans;
    }
    private static void swap (int []arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private static void reverse(int []arr, int left, int right){
        while(left<right){
            swap(arr, left, right);
            left++;
            right--;
        }
    }
    private static void rotstedInPlace(int []arr, int k){   //T.C - O(N) & S.C - O(1)
        int n = arr.length; 
        if(n<=k) k %= n;
        // 1 2 3 4 5
        reverse(arr, 0, k-1);   //2 1 3 4 5
        reverse(arr, k, n-1);   //2 1 5 4 3
        reverse(arr, 0, n-1);   //3 4 5 1 2
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
        System.out.print("Enter Time Of Rotation: ");
        int k = sc.nextInt();
        printArray(arr);
        // int []ans = rotated(arr, k);
        rotstedInPlace(arr, k);
        System.out.println("After Rotation: ");
        // printArray(ans);
        printArray(arr);
        sc.close();
    }
}
