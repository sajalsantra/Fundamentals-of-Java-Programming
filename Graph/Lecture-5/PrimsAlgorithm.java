
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class PrimsAlgorithm {
    static class Pair{
        int wt, v;
        Pair(int wt, int v){
            this.wt = wt;
            this.v = v;
        }
    }

    private static class PairComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair e1, Pair e2) {
            return Integer.compare(e1.wt, e2.wt);
        }
    }

    static List<List<Pair>> graph;

    private static void createGraph(int u, int v, int wt, boolean directed){
        graph.get(u).add(new Pair(wt, v));
        if(!directed) graph.get(v).add(new Pair(wt, u));
    }

    public static int prims(int n, int start) {
        PriorityQueue<Pair> pq = new PriorityQueue<>( new PairComparator());
        Set<Integer> visited = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        int []parent = new int[n+1]; 
        Arrays.fill(parent, -1);
        pq.add(new Pair(0, start));
        for(int i=0; i<=n; i++) map.put(i, Integer.MAX_VALUE);
        map.put(start, -1);
        int toatlCount = 0;
        int totalWeight = 0;
        while(toatlCount < n && !pq.isEmpty()){
            Pair curr = pq.poll();
            if(visited.contains(curr.v)) continue;
            visited.add(curr.v);
            totalWeight += curr.wt;
            for(Pair neighbour : graph.get(curr.v)){
                if(!visited.contains(neighbour.v) && map.get(neighbour.v) > neighbour.wt){
                    pq.add(neighbour);
                    parent[neighbour.v] = curr.v;
                    map.put(neighbour.v, neighbour.wt);
                }
            }
        }
        return totalWeight;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        graph = new ArrayList<>();
        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());
        while(m-->0){
            int source = sc.nextInt();
            int destination = sc.nextInt();
            int weight = sc.nextInt();
            createGraph(source, destination, weight, false);
        }

        int start = sc.nextInt();
        int result = prims(n, start);
        System.out.println(result);
    }
}
