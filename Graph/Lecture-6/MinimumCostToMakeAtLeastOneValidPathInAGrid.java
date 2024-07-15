import java.util.*;
class Solution {
    class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int minCost(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int [][]dist = new int[n][m];
        for(int []arr : dist) Arrays.fill(arr,  Integer.MAX_VALUE);
        int []dx = {0, 0, 1, -1};
        int []dy = {1, -1, 0, 0};

        Deque<Pair> dq = new LinkedList<>();
        dq.add(new Pair(0, 0));
        dist[0][0] = 0;
        while(!dq.isEmpty()){
            Pair curr = dq.pollFirst();
            int x = curr.x;
            int y = curr.y;
            int dir = grid[x][y];

            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                int edgeWt = 1;
                if(i+1==dir) edgeWt = 0;
                if(nx>=0 && nx<n && ny>=0 && ny<m){
                    if(dist[nx][ny] > dist[x][y]+edgeWt){
                        dist[nx][ny] = dist[x][y]+edgeWt;
                        if(edgeWt==1) dq.addLast(new Pair(nx, ny));
                        else dq.addFirst(new Pair(nx, ny));
                    }
                }
            }
        }
        return dist[n-1][m-1];
    }
}
public class MinimumCostToMakeAtLeastOneValidPathInAGrid {

    
}