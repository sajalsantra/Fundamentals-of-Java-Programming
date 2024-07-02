import java.util.Scanner;

public class RotatedMatrix {

    private static void printMatrix(int[][] matrix) {
        for (int[] matrix1 : matrix) {
            for (int j = 0; j < matrix1.length; j++) {
                System.out.print(matrix1[j] + " ");
            }
            System.out.println();
        }
    }

    private static void transposeInPlace(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private static void reversedMatrixRows(int []arr){
        int left = 0;
        int right = arr.length-1;
        while(left<right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    private static void rotatedMatrix(int [][]matrix){
        transposeInPlace(matrix);
        for(int []arr: matrix){
            reversedMatrixRows(arr);
        }
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
        if(n==m){
            System.out.println("The rotated Matrix is: ");
            rotatedMatrix(matrix);
            printMatrix(matrix);
        }
        else System.out.println("Rotation is not supported");
    }
}
