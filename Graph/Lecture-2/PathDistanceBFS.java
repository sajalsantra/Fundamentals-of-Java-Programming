package com.hello;

import java.util.*;

public class PathDistanceBFS {
    static List<List<Integer>> graph;
    static Set<Integer> visit;
    public static void addEdge(int source, int destination, boolean directed){
        if(directed){
            graph.get(source).add(destination);
        }else{
            graph.get(source).add(destination);
            graph.get(destination).add(source);
        }
    }
    private static void displayGraph() {
        for(int i=0; i<graph.size(); i++){
            System.out.print(i+ " -> ");
            for(int j=0; j<graph.get(i).size(); j++){
                System.out.print(graph.get(i).get(j)+", ");
            }
            System.out.println();
        }
    }
    private static void bfs(int source, Map<Integer, Integer> distance) {
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        distance.put(source, 0);
        visit.add(source);
        while (!q.isEmpty()){
            int curr = q.remove();
            for(int neighbour : graph.get(curr)){
                if(!visit.contains(neighbour)){
                    q.add(neighbour);
                    visit.add(neighbour);
                    distance.put(neighbour, distance.getOrDefault(curr, 0)+1);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number Of Vertices: ");
        int vertex = sc.nextInt();
        graph = new ArrayList<>();
        for(int i=0; i<vertex; i++){
            graph.add(new ArrayList<>());
        }
        System.out.println("Enter The Graph Data: ");
        while(vertex > 0){
            int source = sc.nextInt();
            int destination = sc.nextInt();
            addEdge(source, destination, false);
            vertex--;
        }
        displayGraph();
        Map<Integer, Integer> distance = new HashMap<>();
        System.out.print("Enter source Vertex: ");
        int source = sc.nextInt();
        visit = new HashSet<>();
        bfs(source, distance);
        for(int destinationVertex : distance.keySet()){
            System.out.println(source+" to "+destinationVertex+ " distance is: "+distance.get(destinationVertex));
        }
    }
}
