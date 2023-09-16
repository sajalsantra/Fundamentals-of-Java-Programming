import java.util.Scanner;

public class FirstRepeatingElement {
    private static int firstReapeatingNum(int []arr){
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[i]==arr[j]) return arr[i];
            }
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
        System.out.println(firstReapeatingNum(arr));
    }    
}
