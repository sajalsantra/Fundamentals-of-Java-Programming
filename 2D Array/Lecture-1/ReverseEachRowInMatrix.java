import java.util.Scanner;

public class ReverseEachRowInMatrix {

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void reverseEachRow(int [][] matrix){
        for(int []row : matrix){
            int i = 0;
            int j = row.length-1;
            while(i<j){
                int temp = row[i];
                row[i] = row[j];
                row[j] = temp;
                i++;
                j--;
            }
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
        System.out.println("The Original Matrix is:");
        printMatrix(Matrix);
        System.out.println("After Reverse Each Row Matrix is:");
        reverseEachRow(Matrix);
        printMatrix(Matrix);
    }
}
