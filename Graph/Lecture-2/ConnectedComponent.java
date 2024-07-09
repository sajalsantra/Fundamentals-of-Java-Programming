import java.util.*;

public class ConnectedComponent {
    static List<List<Integer>> graph;

    public static void addEdge(int source, int destination, boolean directed){
        if(directed){
            graph.get(source).add(destination);
        }else{
            graph.get(source).add(destination);
            graph.get(destination).add(source);
        }
    }
    private static void dfs(int curr, Set<Integer> visit){
        visit.add(curr);
        for(int neighbour : graph.get(curr)){
            if(!visit.contains(neighbour)){
                dfs(neighbour, visit);
            }
        }
    }
    private static int connectedComponent(int vertex){
        int count = 0;
        Set<Integer> visit = new HashSet<>();
        for(int i=0; i<vertex; i++){
            if(!visit.contains(i)){
                count++;
                dfs(i, visit);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number Of Vertices & Edges: ");
        int vertex = sc.nextInt();
        int edges = sc.nextInt();
        graph = new ArrayList<>();
        for(int i=0; i<edges; i++){
            graph.add(new ArrayList<>());
        }
        System.out.println("Enter The Graph Data: ");
        while(edges > 0){
            int source = sc.nextInt();
            int destination = sc.nextInt();
            addEdge(source, destination, false);
            edges--;
        }
        int result = connectedComponent(vertex);
        System.out.println("Number of Connected Component: "+result);
    }
}
