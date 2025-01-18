package com.ragu;

import java.util.*;



class Pair{
    int fp;
    int sp;
    public Pair(int a, int b){
        this.fp = a;
        this.sp = b;
    }
}

public class Trial {

        public static int[] findOrder(int N, int[][] prerequisites) {
            int P=prerequisites.length;
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            for(int i = 0; i < N; i++){
                list.add(new ArrayList<>());
            }
            for(int i = 0; i < P; i++){
                list.get(prerequisites[i][1]).add(prerequisites[i][0]);
            }
            // return Bfs(N,list);

            return Dfs(N,list);
        }
        public static int[] Dfs(int N,ArrayList<ArrayList<Integer>> list){
            Stack<Integer> stack=new Stack<>();
            int[] vis=new int[list.size()];
            int[] pathvis=new int[list.size()];
            int[] ans=new int[list.size()];
            for(int i=0;i<vis.length;i++){
                if(vis[i]==0){
                    if(check(stack,list,vis,pathvis,i)){
                        return new int[]{};
                    }
                }
            }
            int i=0;
            while(!stack.isEmpty()){
                ans[i++]=stack.pop();
            }
            return ans;
        }
        public static boolean check(Stack<Integer> stack, ArrayList<ArrayList<Integer>> list, int[] vis, int[] pathvis, int node){
            vis[node]=1;
            pathvis[node]=1;
            for(int a:list.get(node)){
                if(vis[a]==0){
                    if(check(stack,list,vis, pathvis, a)){
                        return true;
                    }
                } else if (pathvis[a]==1) {
                    return true;
                }
            }
            stack.push(node);
            pathvis[node]=0;
            return false;
        }

    public static void main(String[] args) {
//        int[][] arr={{0,1},{1,0}};
//        System.out.println(Arrays.toString(findOrder(2,arr)));
        System.out.println(minimumLength("lyqkwhyy"));
    }
    public static int minimumLength(String s) {
        if(s.length()<3) return s.length();
        ArrayList<Character> list = new ArrayList<>();
        for (char c : s.toCharArray()) {
            list.add(c);
        }
        int n=list.size();
        for(int i=1;i< n-1;i++){
            int left=0,right=i+1;
            char ch=list.get(i);
            while (list.get(left)!=ch&&left<i){
                left++;
            }
            while (list.get(right)!=ch&&right<list.size()){
                right++;
                if(right>=list.size())
                    break;
            }
            if(left<i&&right<list.size()){
                list.remove(left);
                list.remove(right);
            }
            n=list.size();
        }
        return list.size();
    }
    public static String losingPlayer(int x, int y) {
            int p=1;
            while (x>=1 && y>=4){
                x-=1;y-=4;
                p=p^1;
            }
            if(p==0){
                return "Alice";
            }else
                return "Bob";

    }

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        int[] indegree = new int[V];
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        ArrayList<ArrayList<Integer>> revadj=new ArrayList<>();

        for(int i=0;i<V;i++){
            revadj.add(new ArrayList<>());
        }
        for(int i=0;i<V;i++){
            for(int a: adj.get(i)){
                indegree[i]++;
                revadj.get(a).add(i);
            }
        }
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while (!q.isEmpty()){
            int n=q.poll();
            ans.add(n);
            for (int a: revadj.get(n)){
                indegree[a]--;
                if(indegree[a]==0)
                    q.add(a);
            }
        }

        Collections.sort(ans);

        return ans;
    }
}
