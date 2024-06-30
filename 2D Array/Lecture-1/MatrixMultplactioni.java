import java.util.Scanner;

public class MatrixMultplactioni {

    private static void printMatrix(int[][] matrix) {
        for (int[] matrix1 : matrix) {
            for (int j = 0; j < matrix1.length; j++) {
                System.out.print(matrix1[j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter First Matrix Size: ");
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [][]Matrix1 = new int[n][m];
        
        System.out.println("Enter First Matrix Element: ");
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                Matrix1[i][j] = sc.nextInt();
            }
        }
        
        System.out.println("Enter Second Matrix Size: ");
        int x = sc.nextInt();
        int y = sc.nextInt();
        int [][]Matrix2 = new int[x][y];
        
        System.out.println("Enter Second Matrix Element: ");
        for(int i=0; i<x; i++){
            for(int j=0; j<y; j++){
                Matrix2[i][j] = sc.nextInt();
            }
        }

        System.out.println("The First Matrix is:");
        printMatrix(Matrix1);

        System.out.println("The Second Matrix is:");
        printMatrix(Matrix1);

        System.out.println("The Matrix multiplication is:");
    }
}
