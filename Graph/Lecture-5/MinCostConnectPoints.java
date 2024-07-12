import java.util.*;

class Edge {
    int point2, cost;

    Edge(int point1, int point2, int cost) {
        this.point2 = point2;
        this.cost = cost;
    }
}

class Solution3 {
    public int calculateCost(int[] coordinate1, int[] coordinate2) {
        return Math.abs(coordinate1[0] - coordinate2[0]) + Math.abs(coordinate1[1] - coordinate2[1]);
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        if (n == 0) return 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        boolean[] visited = new boolean[n];

        for (int i = 1; i < n; i++) {
            int cost = calculateCost(points[0], points[i]);
            pq.add(new Edge(0, i, cost));
        }

        visited[0] = true;
        int edgeCount = n - 1;
        int minCost = 0;

        while (!pq.isEmpty() && edgeCount > 0) {
            Edge curr = pq.poll();
            int point2 = curr.point2;
            int cost = curr.cost;

            if (!visited[point2]) {
                minCost += cost;
                visited[point2] = true;
                edgeCount--;

                for (int i = 0; i < n; i++) {
                    if (!visited[i]) {
                        int cost2 = calculateCost(points[point2], points[i]);
                        pq.add(new Edge(point2, i, cost2));
                    }
                }
            }
        }

        return minCost;
    }
}


public class MinCostConnectPoints {
    public static void main(String[] args) {
        Solution3 sol = new Solution3();
        int [][]points = {{0,0},{2,2},{3,10},{5,2},{7,0}};
        int minCost = sol.minCostConnectPoints(points);
        System.out.println(minCost);
    }
}
