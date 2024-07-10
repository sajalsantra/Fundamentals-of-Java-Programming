import java.util.*;

public class CycleDetection {

    private static int find(int x, int []parent){
        if(parent[x]==x) return x;
        return parent[x] = find(parent[x], parent);
    }
    private static boolean union(int a, int b, int []rank, int []parent){
        a = find(a, parent);
        b = find(b, parent);
        if(a==b) return true;
        if(rank[a] < rank[b]){
            rank[b]++;
            parent[a] = b;
        }else{
            rank[a]++;
            parent[b] = a;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        int []parent = new int[v+1];
        int []rank = new int[v+1];
        for(int i=0; i<v; i++) parent[i] = i;
        while (e-->0){
            int source = sc.nextInt();
            int destination = sc.nextInt();
            
            /* Cycle Detaction in a Graph Using DSU */
            boolean result = union(source, destination, rank, parent);
            if(result) System.out.println("Cycle Detacted!");
        }
    }
}
