
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PascalsTriangle {
    private static void createPascalTriangles(int n, List<List<Integer>> triangles){
        for(int i=0; i<n; i++){
            List<Integer> triangle = new ArrayList<>();
            for(int j=0; j<=i; j++){
                if(j==0 || j==i){
                    triangle.add(1);
                }
                else{
                    triangle.add(triangles.get(i-1).get(j-1) + triangles.get(i-1).get(j));
                }
            }
            triangles.add(triangle);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of triangles: ");
        int n = sc.nextInt();
        List<List<Integer>> triangles = new ArrayList<>();
        createPascalTriangles(n, triangles);
        System.out.println("Pascal triangle is: ");
        for(List<Integer> triangle : triangles){
            for(int val : triangle){
                System.out.print(val+" ");
            }
            System.out.println();
        }
    }
}
