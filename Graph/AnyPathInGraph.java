package com.hello;

import java.util.*;

public class AnyPathInGraph {
    static Scanner sc;
    static List<List<Integer>> graph;
    static Set<Integer> set;
    private static void displayGraph() {
        for(int i=0; i<graph.size(); i++){
            System.out.print(i+ " -> ");
            for(int j=0; j<graph.get(i).size(); j++){
                System.out.print(graph.get(i).get(j)+", ");
            }
            System.out.println();
        }
    }
    public static void addEdge(int source, int destination, boolean directed){
        if(directed){
            graph.get(source).add(destination);
        }else{
            graph.get(source).add(destination);
            graph.get(destination).add(source);
        }
    }
    public static boolean dfs(int curr, int end){
        if(curr == end) return true;
        set.add(curr);
        for(int neighbour : graph.get(curr)){
            if(!set.contains(neighbour)){
                boolean result = dfs(neighbour, end);
                if(result) return true;
            }
        }
        return false;
    }
    public static boolean anyPath(int source, int destination){
        return dfs(source, destination);
    }
    public static void main(String[] args) {
        sc = new Scanner(System.in);
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
        System.out.print("Enter Source & Destination Vertex: ");
        int source = sc.nextInt();
        int destination = sc.nextInt();
        set = new HashSet<>();
        boolean result = anyPath(source, destination);
        System.out.println(result);
    }
}
