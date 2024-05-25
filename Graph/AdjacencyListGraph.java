package com.hello;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdjacencyListGraph {
    static Scanner sc;
    static List<List<Integer>> graph;
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
            addEdge(source, destination, true);
            vertex--;
        }
        displayGraph();
    }
}