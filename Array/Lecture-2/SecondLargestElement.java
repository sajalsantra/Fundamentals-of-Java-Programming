import java.util.Scanner;

public class SecondLargestElement {
    private static int findMaxinmum(int []arr){
        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            if(arr[i] > max) max = arr[i];
        }
        return max;
    }
    private static int findSecondLargest(int []arr){
        int max = findMaxinmum(arr);
        for(int i=0; i<arr.length; i++){
            if(arr[i]==max) arr[i] = Integer.MIN_VALUE;
        }
        return findMaxinmum(arr);
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
        System.out.println(findSecondLargest(arr));
    }
    
}
