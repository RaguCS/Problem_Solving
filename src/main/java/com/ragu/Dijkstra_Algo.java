package com.ragu;

import java.util.*;
import java.util.PriorityQueue;

class DijkPair{
    int dist;
    int node;
    public DijkPair(int dist, int node) {
        this.dist = dist;
        this.node = node;
    }
}
public class Dijkstra_Algo {
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
//        Dijkstra Using PriorityQueue
// "(x,y)->x.dist-y.dist" is needed,not able to compare int priorityQueue without this expression
        PriorityQueue<DijkPair> pq = new PriorityQueue<DijkPair>((x,y)->x.dist-y.dist);
        int[] dist = new int[V];
        Arrays.fill(dist,(int)1e9);
        dist[S] = 0;
        pq.add(new DijkPair(0,S));
        while (!pq.isEmpty()) {
            DijkPair pair = pq.poll();
            int node = pair.node;
            int dis = pair.dist;
            for(int i=0; i<adj.get(node).size(); i++) {
                int edgeweight=adj.get(node).get(i).get(1);
                int adjNode=adj.get(node).get(i).get(0);
                if(dis+edgeweight<dist[adjNode]){
                    dist[adjNode]=dis+edgeweight;
                    pq.add(new DijkPair(dist[adjNode],adjNode));
                }
            }
        }
        return dist;
    }
    public List<Integer> shortestPath(int n, int m, int edges[][]) {

        ArrayList<ArrayList<DijkPair>> adj = new ArrayList<ArrayList<DijkPair>>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<DijkPair>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(new DijkPair(edges[i][1],edges[i][2]));
            adj.get(edges[i][1]).add(new DijkPair(edges[i][0],edges[i][2]));
        }


        PriorityQueue<DijkPair> pq = new PriorityQueue<DijkPair>((a,b) -> a.dist - b.dist);

        int dist[] = new int[n+1];
        for(int i=0;i<=n;i++) dist[i] = (int) 1e9;

        int parent[] = new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i] = i;
        }

        pq.add(new DijkPair(1,0));
        dist[1] = 0;

        while(!pq.isEmpty()){
            DijkPair p = pq.poll();
            for(DijkPair pa : adj.get(p.node)){
                int edgeDistance = pa.dist;
                int n_ = pa.node;
                if(edgeDistance+p.dist < dist[n_]){
                    parent[n_] = p.node;
                    dist[n_] = edgeDistance+p.dist;
                    pq.add(new DijkPair(n_,dist[n_]));
                }
            }
        }
        List<Integer> ans = new ArrayList<Integer>();
        if(dist[n] == (int) 1e9){
            ans.add(-1);
            return ans;
        }
        int node = n;
        while(parent[node] != node){
            ans.add(node);
            node = parent[node];
        }
        ans.add(1);
        ans.add(dist[n]);


        Collections.reverse(ans);

        return ans;
    }
}
