import java.util.*;

class Solutions {
    List<List<Integer>> graph;
    private void addEdge(int source, int destination, boolean isDirected){
        if(isDirected){
            graph.get(source).add(destination);
        }else{
            graph.get(source).add(destination);
            graph.get(destination).add(source);
        }
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        graph = new ArrayList<>();
        for(int i=0; i<numCourses; i++) graph.add(new ArrayList<>());
        for(int []path : prerequisites){
            addEdge(path[1], path[0], true);
        }
        int []indegree = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            for(int neighbour : graph.get(i)){
                indegree[neighbour]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> visit = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int val = q.poll();
            visit.add(val);
            for(int neighbour : graph.get(val)){
                indegree[neighbour]--;
                if(indegree[neighbour]==0){
                    q.add(neighbour);
                }
            }
        }
        if(visit.size()!=numCourses) return new int[0];
        int []result = new int[numCourses];
        int k = 0;
        for(int val : visit) result[k++] = val;
        return result;
    }
}

public class CourseScheduleII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCourses = sc.nextInt();
        int n = sc.nextInt();
        int[][] prerequisites = new int[n][2];
        for(int i=0; i<n; i++){
            for(int j=0; j<2; j++){
                prerequisites[i][j] = sc.nextInt();
            }
        }
        Solutions sol = new Solutions();
        int[] result = sol.findOrder(numCourses, prerequisites);
        if (result.length == 0) {
            System.out.println("It's not possible to finish all courses.");
        } else {
            for (int val : result) System.out.print(val + " ");
            System.out.println();
        }
    }
}
