import java.util.*;

// A basic implementation of topological sort using Kahn's algorithm
class Solution {
    List<List<Integer>> graph;
    private void addEdge(int source, int destination, boolean isDirected){
        if(isDirected){
            graph.get(source).add(destination);
        }else{
            graph.get(source).add(destination);
            graph.get(destination).add(source);
        }
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        graph = new ArrayList<>();
        for(int i=0; i<numCourses; i++) graph.add(new ArrayList<>());
        for(int []path : prerequisites){
            addEdge(path[0], path[1], true);
        }
        int []indegree = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            for(int neighbour : graph.get(i)){
                indegree[neighbour]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visit = new HashSet<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0){
                q.add(i);
                visit.add(i);
            }
        }
        while(!q.isEmpty()){
            int val = q.poll();
            for(int neighbour : graph.get(val)){
                if(!visit.contains(neighbour)){
                    indegree[neighbour]--;
                    if(indegree[neighbour]==0){
                        q.add(neighbour);
                        visit.add(neighbour);
                    }
                }
            }
        }
        return visit.size()==numCourses;
    }
}

public class CourseSchedule {
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
        Solution sol = new Solution();
        boolean result = sol.canFinish(numCourses, prerequisites);
        if(result) System.out.println("Yes! Possible Complete all courses");
        else System.out.println("No! Not possible complete all courses");
    }
}

