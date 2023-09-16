import java.util.Scanner;

public class UniqueNumber {
    private static int findUniqueNumber(int []arr){
        int n = arr.length;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(arr[i]==arr[j]){
                    arr[i] = -1;
                    arr[j] = -1;
                }
            }
        }
        for(int i=0; i<n; i++){
            if(arr[i] != -1) return arr[i];
        }
        return -1;
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
        System.out.println(findUniqueNumber(arr));
    }
}
