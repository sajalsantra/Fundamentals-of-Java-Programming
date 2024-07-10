import java.util.*;

public class CycleDetectionII {
    static List<List<Integer>> graph;
    private static void displayGraph(){
        for(int i=0; i<graph.size(); i++){
            System.out.print(i + "--> ");
            for(int j=0; j<graph.get(i).size(); j++){
                System.out.print(graph.get(i).get(j)+", ");
            }
            System.out.println();
        }
    }
    private static void createGraph(int source, int destination, boolean directed){
        if(directed){
            graph.get(source).add(destination);
        }else{
            graph.get(source).add(destination);
            graph.get(destination).add(source);
        }
    }
    private static boolean dfs(int source, int parent, Set<Integer> isVisit){
        isVisit.add(source);
        for(int neighbour : graph.get(source)){
            if(isVisit.contains(neighbour) && neighbour != parent) return true;
            if(!isVisit.contains(neighbour)){
                dfs(neighbour, source, isVisit);
            }
        }
        return false;
    }
    private static boolean hasCycleDFS(int vertex){
        Set<Integer> isVisit = new HashSet<>();
        for(int i=0; i<vertex; i++){
            if(!isVisit.contains(i)){
                boolean result = dfs(i, -1, isVisit);
                if(result) return true;
            }
        }
        return false;
    }

    private static boolean hasCycleBFS(int source, int vertex){
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> isVisit = new HashSet<>();
        int []parent = new int[vertex+1];
        Arrays.fill(parent, -1);
        q.offer(source);
        isVisit.add(source);
        while (!q.isEmpty()){
            int curr = q.poll();
            for(int neighbour : graph.get(curr)){
                if(isVisit.contains(neighbour) && parent[curr]!=neighbour) return true;
                if(!isVisit.contains(neighbour)){
                    q.add(neighbour);
                    isVisit.add(neighbour);
                    parent[neighbour] = curr;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number of Vertices: ");
        int vertex = sc.nextInt();
        System.out.print("Enter Number of Edges: ");
        int edges = sc.nextInt();
        graph = new ArrayList<>();
        for(int i=0; i<vertex; i++) graph.add(new ArrayList<>());
        while (edges-->0){
            int source = sc.nextInt();
            int destination = sc.nextInt();
            createGraph(source, destination, false);
        }
        System.out.println("The Graph is: ");
        displayGraph();

        /* Cycle Detection Using DFS */
        if(hasCycleDFS(vertex)) System.out.println("Yes! Cycle Detected");
        else System.out.println("No! Cycle Not Detected");

        /* Cycle Detection Using BFS */
        if(hasCycleBFS(0 ,vertex)) System.out.println("Yes! Cycle Detected");
        else System.out.println("No! Cycle Not Detected");
    }
}
