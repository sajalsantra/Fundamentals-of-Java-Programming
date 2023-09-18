import java.util.Scanner;

public class OddEvenReArrange {
    private static void printArray(int []a){
        for(int x : a) System.out.print(x+" ");
        System.out.println();
    }
    private static void swap(int []arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private static void oddEvenArrenge(int []arr){
        int i = 0; 
        int j = 0;
        int n = arr.length;
        while(j<n){
            if(arr[j]%2==0){
                swap(arr, i, j);
                i++;
                j++;
            }else{
                j++;
            }
        }
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
        oddEvenArrenge(arr);
        System.out.println("After Re-Arrange: ");
        printArray(arr);
        sc.close();
    }
}
