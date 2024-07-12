import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class KruskalAlgo {
    static class Edges {
        int u, v, wt;

        public Edges(int u, int v, int wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
    }

    private static class EdgesComparator implements Comparator<Edges> {
        @Override
        public int compare(Edges e1, Edges e2) {
            return Integer.compare(e1.wt, e2.wt);
        }
    }

    private static int find(int[] parent, int a) {
        return parent[a] = (parent[a] == a) ? a : find(parent, parent[a]);
    }

    private static void union(int a, int b, int[] parent, int[] rank) {
        a = find(parent, a);
        b = find(parent, b);
        if (rank[a] < rank[b]) {
            rank[b]++;
            parent[a] = b;
        } else {
            rank[a]++;
            parent[b] = a;
        }
    }

    private static int kruskal(int n, int e, List<Edges> list) {
        Collections.sort(list, new EdgesComparator());
        int[] rank = new int[n + 1];
        Arrays.fill(rank, 1);
        int[] parent = new int[n + 1];
        for (int i = 0; i <= n; i++)
            parent[i] = i;

        int edgeCount = 0;
        int i = 0;
        int totalCost = 0;
        while (edgeCount < n - 1 && i < list.size()) {
            Edges curr = list.get(i);
            int sourceParent = find(parent, curr.u);
            int destinationParent = find(parent, curr.v);
            if (sourceParent != destinationParent) {
                union(sourceParent, destinationParent, parent, rank);
                totalCost += curr.wt;
                edgeCount++;
            }
            i++;
        }
        return totalCost;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number of Vertises and Edges: ");
        int vertex = sc.nextInt();
        int edge = sc.nextInt();
        List<Edges> graph = new ArrayList<>();
        while (edge-- > 0) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int wt = sc.nextInt();
            Edges e = new Edges(u, v, wt);
            graph.add(e);
        }
        int result = kruskal(vertex, edge, graph);
        System.out.println("Minimum Cost to Create Spaning Tree: " + result);
    }
}
