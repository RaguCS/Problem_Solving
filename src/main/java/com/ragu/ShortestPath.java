package com.ragu;
import java.util.*;
public class ShortestPath {//Directed Graph
    public static int[] shortestPath(int N,int M, int[][] edges) {
        ArrayList<ArrayList<Duo>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            ArrayList<Duo> temp=new ArrayList<Duo>();
            adj.add(temp);
        }
        for (int i = 0; i < M; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Duo(v,wt));
        }
        int[] visited = new int[N];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            if(visited[i] == 0){
                topo(adj,visited,stack,i);
            }
        }
        int[] dist = new int[N];
        Arrays.fill(dist, (int) (1e9));
        dist[0] = 0;
        while(!stack.isEmpty()){
            int u = stack.pop();
            for(int i=0;i<adj.get(u).size();i++){
                int v = adj.get(u).get(i).first;
                int wt = adj.get(u).get(i).sec;
                if(dist[u] + wt<dist[v]){
                    dist[v] = dist[u] + wt;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            if (dist[i] == (int)(1e9)) {
                dist[i] = -1;
            }
        }


        return dist;
    }

    private static void topo(ArrayList<ArrayList<Duo>> adj, int[] visited, Stack<Integer> stack, int node) {
        visited[node] = 1;
        for(int i=0;i<adj.get(node).size();i++){
            int a=adj.get(node).get(i).first;
            if(visited[a] == 0){
                topo(adj,visited,stack,a);
            }
        }
        stack.push(node);

    }
}
