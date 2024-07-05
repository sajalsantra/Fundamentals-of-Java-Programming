
import java.util.Scanner;

public class SpiralMatrixTraversal {

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void spiralMatrixTraversal(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int left = 0, right = m-1, top = 0, bottom = n-1;
        int totalEle = 0;
        while(totalEle < n*m) {
            for(int j=left; j<=right && totalEle < n*m; j++){
                System.out.print(matrix[top][j]+" ");
                totalEle++;
            }
            top++;
            for(int i=top; i<=bottom && totalEle < n*m; i++){
                System.out.print(matrix[i][right]+" ");
                totalEle++;
            }
            right--;
            for(int j=right; j>=left && totalEle < n*m; j--){
                System.out.print(matrix[bottom][j]+" ");
                totalEle++;
            }
            bottom--;
            for(int i=bottom; i>=top && totalEle < n*m; i--){
                System.out.print(matrix[i][left]+" ");
                totalEle++;
            }
            left++;
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
        System.out.println("The Spiral Matrix Traversal is: ");
        spiralMatrixTraversal(matrix);
    }
}
