package Sorting;

import java.util.Scanner;

public class CountSort {
    public static void printArray(int []arr){
        for(int val : arr) System.out.print(val+" ");
        System.out.println();
    }
    public static int findMax(int []arr){
        int max = Integer.MIN_VALUE;
        for(int val : arr){
            max = Math.max(max, val);
        }
        return max;
    }
    public static int[] basicCountSort(int []arr){
        int n = arr.length;
        int max = findMax(arr);
        int []count = new int[max+1];
        for(int val : arr) count[val]++;
        int []ans = new int[n];
        int k = 0;
        for(int i=0; i<=max; i++){
            for(int j=0; j<count[i]; j++){
                ans[k++] = i;
            }
        }
        return ans;
    }
    public static int[] countSort(int []arr){
        int n = arr.length;
        int max = findMax(arr);
        int []count = new int[max+1];
        for(int val : arr) count[val]++;
        for(int i=1; i<=max; i++){
            count[i] += count[i-1];
        }
        int []output = new int[n];
        for(int i=n-1; i>=0; i--){
            int idx = count[arr[i]]-1;
            output[idx] = arr[i];
            count[arr[i]]--;
        }
        return output;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int []result = basicCountSort(arr);
        printArray(result);
        int []output = countSort(arr);
        printArray(output);
    }    
}