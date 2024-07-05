
import java.util.Scanner;

public class CreateSpiralMatrix {

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void crateSprialMatrix(int n, int [][]matrix){
        int left = 0, right = n-1, top = 0, bottom = n-1;
        int totalEle = 1;
        while(totalEle <= n*n) {
            for(int j=left; j<=right && totalEle <= n*n; j++){
                matrix[top][j] = totalEle++;
            }
            top++;
            for(int i=top; i<=bottom && totalEle <= n*n; i++){
                matrix[i][right] = totalEle++;
            }
            right--;
            for(int j=right; j>=left && totalEle <= n*n; j--){
                matrix[bottom][j] = totalEle++;
            }
            bottom--;
            for(int i=bottom; i>=top && totalEle <= n*n; i--){
                matrix[i][left] = totalEle++;
            }
            left++;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Matrix Size: ");
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        crateSprialMatrix(n, matrix);
        System.out.println("Spriral Matrix is: ");
        printMatrix(matrix);
    }
}
