
import java.util.Scanner;

public class SumOfRectangle {

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int findRectangleSumBrute(int r1, int c1, int r2, int c2, int[][] matrix){
        int sum = 0;
        for(int i=r1; i<=r2; i++){
            for(int j=c1; j<=c2; j++){
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    public static int findRectangleSumBetter(int r1, int c1, int r2, int c2, int[][] matrix){
        int sum = 0;
        
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Matrix Size: ");
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [][]matrix = new int[n][m];
        System.out.print("Enter Matrix Element: ");
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println("The Original Matrix is: ");
        printMatrix(matrix);
        System.out.print("Enter First point: ");
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();
        System.out.print("Enter Second point: ");
        int r2 = sc.nextInt();
        int c2 = sc.nextInt();
        int sum1 = findRectangleSumBrute(r1, c1, r2, c2, matrix);
        System.out.println("Rectangle sum (Using Brute Force): "+sum1);
        int sum2 = findRectangleSumBetter(r1, c1, r2, c2, matrix);
        System.out.println("Rectangle sum (Better Solution): "+sum2);
    }
}
