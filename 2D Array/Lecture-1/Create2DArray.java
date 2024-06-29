
import java.util.Scanner;

public class Create2DArray {
    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Matrix Size: ");
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [][]Matrix = new int[n][m];
        System.out.println("Enter Matrix Element: ");
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                Matrix[i][j] = sc.nextInt();
            }
        }

        printMatrix(Matrix);
    }

}
