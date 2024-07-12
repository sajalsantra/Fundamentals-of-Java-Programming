
import java.util.Arrays;

/*
 * There are N cities numbered from 1 to N.
 * 
 * You are given connections, where each connections[i] = [city1, city2, cost]
 * represents the cost to connect city1 and city2 together. (A connection is
 * bidirectional: connecting city1 and city2 is the same as connecting city2 and
 * city1.)
 * 
 * Return the minimum cost so that for every pair of cities, there exists a path
 * of connections (possibly of length 1) that connects those two cities
 * together. The cost is the sum of the connection costs used. If the task is
 * impossible, return -1.
 * 
 * 
 * Example 1:
 * Input: N = 3, connections = [[1,2,5],[1,3,6],[2,3,1]]
 * Output: 6
 * Explanation:
 * Choosing any 2 edges will connect all cities so we choose the minimum 2.
 * 
 * Example 2:

 * Input: N = 4, connections = [[1,2,3],[3,4,4]]
 * Output: -1
 * Explanation:
 * There is no way to connect all cities even if all edges are used.
 * 
 * 
 * Note:
 * 1 <= N <= 10000
 * 1 <= connections.length <= 10000
 * 1 <= connections[i][0], connections[i][1] <= N
 * 0 <= connections[i][2] <= 10^5
 * connections[i][0] != connections[i][1]
 */

 public class ConnectingCitiesWithMinimumCost {
    
    private static int find(int a, int []parent){
        return parent[a] = (parent[a]==a) ? a : find(parent[a], parent);
    }
    private static boolean union(int a, int b, int []parent, int []rank){
        a = find(a, parent);
        b = find(b, parent);
        if(a==b) return false;
        if(rank[a] < rank[b]){
            rank[b]++;
            parent[a] = b;
        }else{
            rank[a]++;
            parent[b] = a;
        }
        return true;
    }
    private static int minimumCost(int n, int [][]connections){
        int []parent = new int[n+1];
        int []rank = new int[n+1];
        for(int i=0; i<n; i++) parent[i] = i;
        Arrays.fill(rank, 1);
        Arrays.sort(connections, (a, b) -> Integer.compare(a[2], b[2]));
        int totalCost = 0;
        int component = n;
        for(int []connection : connections){
            if(union(connection[0], connection[1], parent, rank)){
                totalCost += connection[2];
                component--;
            }
        }
        if(component > 1) return -1;
        return totalCost;
    }
    public static void main(String[] args) {

        int n = 3;
        int[][] connections = { { 1, 2, 5 }, { 1, 3, 6 }, { 2, 3, 1 } };
        int minCost = minimumCost(n, connections);
        System.out.println(minCost);
        
        int n2 = 4;
        int [][]connections2 = {{1, 2, 3}, {3, 4, 4}};
        System.out.println(minimumCost(n2, connections2));
    }
}
