import java.util.Scanner;

public class NumberIsPresentOrNot {
    static Scanner sc;
    private static int findMax(int []arr){
        int max = arr[0];
        for(int i=1; i<arr.length; i++){
            if(arr[i]>max) max = arr[i];
        }
        return max;
    }
    private static void searchNumber(int []arr){
        int max = findMax(arr);
        int []count = new int[max+1];
        for(int x : arr) count[x]++;
        System.out.print("Enter The Numner of Search Time: ");
        int t = sc.nextInt();
        while(t>0){
            System.out.print("Enter The Search Number: ");
            int a = sc.nextInt();
            if(count[a] > 0) System.out.println("YES");
            else System.out.println("NO");
            t--;
        }
    }
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        System.out.print("Enter Array Size: ");
        int n = sc.nextInt();
        int []arr = new int[n];
        System.out.print("Enter The Arrey Element: ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        searchNumber(arr);
        sc.close();
    }
}
