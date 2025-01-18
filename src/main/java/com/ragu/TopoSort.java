package com.ragu;
import java.util.*;
public class TopoSort {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int[] vis=new int[V];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                Dfs(vis,stack,i,adj);

            }
        }
        int[] ans=new int[V];
        int i=0;
        while(!stack.isEmpty()){
            ans[i++]=stack.pop();
        }
        // return ans;
        return Bfs(V,adj);
    }
    static int[] Bfs(int V,ArrayList<ArrayList<Integer>> adj){
        int[] indegree=new int[V];
        for(int i=0;i<V;i++){
            for(int a:adj.get(i)){
                indegree[a]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int[] ans=new int[V];
        int i=0;
        while(!q.isEmpty()){
            int n=q.poll();
            ans[i++]=n;
            for(int a:adj.get(n)){
                indegree[a]--;
                if(indegree[a]==0){
                    q.add(a);
                }
            }
        }
        return ans;

    }

    static void Dfs(int[] vis, Stack<Integer> stack,int node,ArrayList<ArrayList<Integer>> adj){
        vis[node]=1;
        for(int a:adj.get(node)){
            if(vis[a]==0){
                Dfs(vis,stack,a,adj);
            }
        }
        stack.push(node);
    }
}


