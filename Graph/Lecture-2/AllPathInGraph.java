package com.hello;

import java.util.*;

public class AllPathInGraph {
    static List<List<Integer>> graph;
    static List<List<Integer>> path;
    static Set<Integer> set;

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
    public static void dfs(int curr, int end, List<Integer> list){
        if(curr==end){
            list.add(curr);
            List<Integer> temp = new ArrayList<>(list);
            path.add(temp);
            list.remove(list.get(list.size()-1));
            return;
        }
        list.add(curr);
        set.add(curr);
        for(int neighbour : graph.get(curr)){
            if(!set.contains(neighbour)){
                dfs(neighbour, end, list);
            }
        }
        set.remove(curr);
        list.remove(list.get(list.size()-1));
    }
    private static void allPath(int start, int end){
        dfs(start, end, new ArrayList<>());
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number of Vertices: ");
        int vertex = sc.nextInt();
        graph = new ArrayList<>();
        for(int i=0; i<vertex; i++) graph.add(new ArrayList<>());
        while (vertex>0){
            int source = sc.nextInt();
            int destination = sc.nextInt();
            addEdge(source, destination, false);
            vertex--;
        }
        displayGraph();
        System.out.println("Enter Start & End Vertex: ");
        int start = sc.nextInt();
        int end = sc.nextInt();
        path = new ArrayList<>();
        set = new HashSet<>();
        allPath(start, end);
        System.out.println(path.size());
        for(List<Integer> list : path){
            for(int val : list) System.out.print(val+" ");
            System.out.println();
        }
    }
}
