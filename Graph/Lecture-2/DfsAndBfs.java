import java.util.*;

public class DfsAndBfs {
    static List<List<Integer>> graph;
    private static void displayGraph(){
        for(int i=0; i<graph.size(); i++){
            System.out.print(i + "--> ");
            for(int j=0; j<graph.get(i).size(); j++){
                System.out.print(graph.get(i).get(j)+" ,");
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
    private static boolean dfs(int curr, int end, Set<Integer> isVisited){
        if(curr==end) return true;
        isVisited.add(curr);
        for(int neighbour : graph.get(curr)){
            if(!isVisited.contains(neighbour)){
                boolean result = dfs(neighbour, end, isVisited);
                if(result) return true;
            }
        }
        return false;
    }
    private static void helper(int curr, int end, Set<Integer> isVisit, List<Integer> list, List<List<Integer>> result){
        if(curr==end){
            list.add(curr);
            List<Integer> temp = new ArrayList<>(list);
            result.add(temp);
            list.remove(list.size()-1);
            return;
        }

        list.add(curr);
        isVisit.add(curr);
        for(int neighbour : graph.get(curr)){
            if (!isVisit.contains(neighbour)){
                helper(neighbour, end, isVisit, list, result);
            }
        }
        list.remove(list.size()-1);
    }
    private static void findAnyPath(int start, int end){
        Set<Integer> isVisited = new HashSet<>();
        boolean result =  dfs(start, end, isVisited);
        if(result) System.out.println(start+" to "+end+" path Exist");
        else System.out.println(start+" to "+end+" no path Exist");
    }

    private static void findAllPath(int start, int end){
        Set<Integer> isVisit = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        helper(start, end, isVisit, new ArrayList<>(), result);
        for(List<Integer> list : result){
            for(int val : list) System.out.print(val +" --> ");
            System.out.println();
        }
    }

    private static boolean findAnyPathBFS(int start, int end){
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> isVisit = new HashSet<>();
        q.add(start);
        isVisit.add(start);
        while (!q.isEmpty()){
            int curr = q.poll();
            if(curr==end) return true;
            for(int neighbour : graph.get(curr)){
                if(!isVisit.contains(neighbour)){
                    isVisit.add(neighbour);
                    q.add(neighbour);
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number of Vertices: ");
        int vertex = sc.nextInt();
        graph = new ArrayList<>();
        for(int i=0; i<vertex; i++) graph.add(new ArrayList<>());
        while (vertex-->0){
            int source = sc.nextInt();
            int destination = sc.nextInt();
            createGraph(source, destination, false);
        }
        System.out.println("The Graph is: ");
        displayGraph();

        /* Search Any Path between two Point Using DFS*/
        System.out.print("Enter Start and Ending point: ");
        int start = sc.nextInt();
        int end = sc.nextInt();
        findAnyPath(start, end);

        /* Display All Path between two Point Using DFS*/
        findAllPath(start, end);

        /* Search Any Path between two Point Using BFS*/
        boolean result = findAnyPathBFS(start, end);
        if(result) System.out.println(start+" to "+end+" Path Exist");
        else System.out.println(start+" to "+end+" no path Exist");
    }
}
 {
    
}
