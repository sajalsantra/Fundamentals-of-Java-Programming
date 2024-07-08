package com.hello;

public class DSU {
    private static int find(int x, int []parent){
        if(parent[x]==x) return x;
        return parent[x] = find(parent[x], parent);
    }
    private static void union(int a, int b, int []rank, int []parent){
        a = find(a, parent);
        b = find(b, parent);
        if(rank[a] < rank[b]){
            rank[b]++;
            parent[a] = b;
        }else{
            rank[a]++;
            parent[b] = a;
        }
    }
    public static void main(String[] args) {

    }
}
