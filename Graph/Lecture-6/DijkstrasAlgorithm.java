
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

public class DijkstrasAlgorithm {

    static class Pair{
        int u, dist;
        Pair(int u, int dist){
            this.u = u;
            this.dist = dist;
        }
    }

    private static class PairComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair e1, Pair e2) {
            return Integer.compare(e1.dist, e2.dist);
        }
    }

    static List<List<Pair>> graph;

    private static void createGraph(int u, int v, int w, boolean directed){
        graph.get(u).add(new Pair(v, w));
        if(!directed) graph.get(v).add(new Pair(u, w));
    }

    private static Map<Integer, Integer> dijkstras(int n, int src){
        PriorityQueue<Pair> pq = new PriorityQueue<>(new PairComparator());
        Set<Integer> visited = new HashSet<>();
        int []via = new int[n];
        Arrays.fill(via, -1);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) map.put(i, Integer.MAX_VALUE);
        pq.add(new Pair(src, 0));
        map.put(src, 0);
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            if(visited.contains(curr.u)) continue;
            visited.add(curr.u);
            for(Pair neighbour : graph.get(curr.u)){
                if(!visited.contains(neighbour.u) && map.get(neighbour.u) > neighbour.dist + map.get(curr.u)){
                    pq.add(new Pair(neighbour.u, neighbour.dist + map.get(curr.u)));
                    via[neighbour.u] = curr.u;
                    map.put(neighbour.u, neighbour.dist + map.get(curr.u));
                }
            }
        }
        return map;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        graph = new ArrayList<>();
        for(int i=0; i<n; i++) graph.add(new ArrayList<>());
        while(m-->0){
            int source = sc.nextInt();
            int destination = sc.nextInt();
            int weight = sc.nextInt();
            createGraph(source, destination, weight, false);
        }

        int start = sc.nextInt();
        Map<Integer, Integer> result = dijkstras(n, start);
        for(int key : result.keySet()){
            System.out.println(key+" "+result.get(key));
        }
        int dist = sc.nextInt();
        System.out.println("Distance Between "+start+" to "+dist+" is: "+result.get(dist));
    }
}
