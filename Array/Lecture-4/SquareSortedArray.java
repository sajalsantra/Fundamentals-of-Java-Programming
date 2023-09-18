import java.util.Scanner;

public class SquareSortedArray {
    private static void printArray(int []a){
        for(int x : a) System.out.print(x+" ");
        System.out.println();
    }
    private static int[] squareSortedArray(int []arr){
        int []ans = new int[arr.length];
        int left = 0;
        int right = arr.length-1;
        int i = 0;
        while(left<right){
            if(Math.abs(arr[left])>Math.abs(right)){
                ans[i++] = arr[left]*arr[left];
                left++;
            }else{
                ans[i++] = arr[right]*arr[right];
                right--;
            }
        }
        return ans;
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
        int []ans = squareSortedArray(arr);
        printArray(ans);
        sc.close();
    }
}
