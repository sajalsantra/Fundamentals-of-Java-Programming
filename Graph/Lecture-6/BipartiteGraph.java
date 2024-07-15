
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


class Solution {
    public boolean helper(int src, int []colour, int[][] graph){
        int n = graph.length;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        colour[src] = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int neighbour : graph[curr]){
                if(colour[curr]==colour[neighbour]) return false;
                if(colour[neighbour]==-1){
                    colour[neighbour] = colour[curr]==0 ? 1 : 0;
                    q.add(neighbour);
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int []colour = new int[n];
        Arrays.fill(colour, -1);
        for(int i=0; i<n; i++){
            if(colour[i]==-1 && !helper(i, colour, graph)) return false;
        }
        return true;
    }
}


public class BipartiteGraph {
    
}
