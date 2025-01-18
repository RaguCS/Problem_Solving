package com.ragu;

import java.util.*;

public class Detect_Cycle {
    public static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[V];
        int[] path=new int[V];
        for(int i=0;i<V;i++){
            if(visited[i]==0){
                if(DFS(adj,visited,path,i)){
                    return true;
                }
            }
        }
        return BFS(V,adj);
    }

    private static boolean BFS(int V,ArrayList<ArrayList<Integer>> adj){
        int[] indegree=new int[V];
        for(int i=0;i<V;i++){
            for(int a:adj.get(i)){
                indegree[a]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0)
                q.add(i);
        }
        int size=0;
        while(!q.isEmpty()){
            int n=q.poll();
            size++;
            for(int a:adj.get(n)){
                indegree[a]--;
                if(indegree[a]==0){
                    q.add(a);
                }
            }
        }
        return size!=V;

    }
    private static boolean DFS(ArrayList<ArrayList<Integer>> adj, int[] visited, int[] path, int i) {
        path[i]=1;
        visited[i]=1;
        for (int a : adj.get(i)) {
            if(visited[a]==0){
                if(DFS(adj,visited,path,a)){
                    return true;
                }
            } else if (path[a]==1) {
                return true;

            }
        }
        path[i]=0;
        return false;
    }
}
