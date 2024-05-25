package com.hello;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdjacencyListWeightGraph {
    static class Pair{
        int destination;
        int weight;
        Pair(int destination, int weight){
            this.destination = destination;
            this.weight = weight;
        }
    }
    static Scanner sc;
    static List<List<Pair>> graph;
    private static void displayGraph() {
        for(int i=0; i<graph.size(); i++){
            System.out.print(i+ " -> {");
            for(int j=0; j<graph.get(i).size(); j++){
                Pair p = graph.get(i).get(j);
                System.out.print("{"+p.destination+","+p.weight+"}");
            }
            System.out.println("}");
        }
    }
    public static void addEdge(int source, Pair pair, boolean directed){
        if(directed){
            graph.get(source).add(pair);
        }else{
            graph.get(source).add(pair);
            graph.get(pair.destination).add(new Pair(source, pair.weight));
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
            int weight = sc.nextInt();
            Pair pair = new Pair(destination, weight);
            addEdge(source, pair, true);
            vertex--;
        }
        displayGraph();
    }
}