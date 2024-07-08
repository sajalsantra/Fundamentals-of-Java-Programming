package com.hello;

import java.util.*;
/* it has also known as Kahn's algorithm */
public class TopologicalSort {
    static List<List<Integer>> graph;
    static int v;
    private static void addEdge(int source, int destination, boolean isDirected){
        if(isDirected){
            graph.get(source).add(destination);
        }else{
            graph.get(source).add(destination);
            graph.get(destination).add(source);
        }
    }
    private static List<Integer> topologicalSort(){
        int []indegree = new int[v];
        for(int i=0; i<v; i++) {
            for (int neighbour : graph.get(i)){
                indegree[neighbour]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visit = new HashSet<>();
        for(int i=0; i<v; i++){
            if(indegree[i]==0){
                q.add(i);
                visit.add(i);
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!q.isEmpty()){
            int curr = q.poll();
            result.add(curr);
            for(int neighbour : graph.get(curr)){
                if(!visit.contains(neighbour)){
                    indegree[neighbour]--;
                    if(indegree[neighbour]==0){
                        q.add(neighbour);
                        visit.add(neighbour);
                    }
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        int e = sc.nextInt();
        graph = new ArrayList<>();
        for(int i=0; i<v; i++) graph.add(new ArrayList<>());
        while (e-->0){
            int source = sc.nextInt();
            int destination = sc.nextInt();
            addEdge(source, destination, true);
        }
        List<Integer> list = topologicalSort();
        for(int val : list) System.out.print(val+" ");
        System.out.println();
    }
}
