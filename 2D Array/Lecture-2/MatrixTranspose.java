import java.util.Scanner;

public class MatrixTranspose {

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    private static int[][] transpose(int n, int m, int[][] matrix) {
        int [][]result = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

    private static void transposeInPlace(int n, int m, int[][] matrix) {
        if(n!=m){
            System.out.println("In place transpose not possible");
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < m; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        System.out.println("The Trasposed Matrix In Place is: ");
        printMatrix(matrix);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Matrix Size: ");
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [][]matrix = new int[n][m];
        System.out.println("Enter Matrix Element: ");
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println("The Original Matrix is: ");
        printMatrix(matrix);
        System.out.println("The Trasposed Matrix is: ");
        int [][]result = transpose(n, m, matrix);
        printMatrix(result);
        transposeInPlace(n, m, matrix);
    }
}
