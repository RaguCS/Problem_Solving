package com.ragu;

import java.util.*;

class Duo {
    int first;
    int sec;
//    int dis;
    public Duo(int first, int sec) {
        this.first = first;
        this.sec = sec;
//        this.dis = dis;
    }

}

public class free {
    public static int find(int target,int[] arr){
        Arrays.sort(arr);

        return -1;
    }
    public static void main(String[] args) {
        int[] arr={5,7,9,2,1,4,6,8,0,3};
        System.out.println(find(1,arr));
//                System.out.println(s1);
//        String a="kxdghhg";
//        pattern(5,0);
//        System.out.println(minChanges(13,4));
    }
    public static int minChanges(int n, int k) {
        k ^= n;
        int cnt = Integer.bitCount(k);
        k &= n;
        return cnt == Integer.bitCount(k) ? cnt : -1;
    }
    public static void pattern(int n,int k){
        if(n==0)
            return;
        if (k<n) {
            pattern(n,k+1);
            System.out.print("*");

        }else {
            pattern(n - 1,0);
            System.out.println();

        }
    }

    public static int MaxConnection(int[][] grid) {
        int N = grid.length, M = grid[0].length;
        int Maxcon=0,color=2;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,0);
        int[] delrow={0,1,0,-1};
        int[] delcol={1,0,-1,0};
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(grid[i][j]==1){
                    int area=DFS(grid,color,i,j);
                    map.put(color,area);
                    color++;
                }
            }
        }
       for(int i=0;i<N;i++){
           for(int j=0;j<M;j++){
               if(grid[i][j]==0){
                   HashSet<Integer> set = new HashSet<>();
                   int len=1;
                   if(i>0){
                       len+=map.get(grid[i-1][j]);
                       set.add(grid[i-1][j]);
                   }
                   if(j>0 && !set.contains(grid[i][j-1])){
                       len+=map.get(grid[i][j-1]);
                       set.add(grid[i][j-1]);
                   }
                   if(i<N-1 && !set.contains(grid[i+1][j])){
                       len+=map.get(grid[i+1][j]);
                       set.add(grid[i+1][j]);
                   }
                   if(j<N-1 && !set.contains(grid[i][j+1])){
                       len+=map.get(grid[i][j+1]);
                   }
                   Maxcon=Math.max(len,Maxcon);
               }
               Maxcon=Math.max(Maxcon,map.get(grid[i][j]));
               }
           }

        return Maxcon;
    }

    private static int check(HashSet<Integer> set, int[][] grid, int i, int j, int[] delcol, int[] delrow, HashMap<Integer, Integer> map) {
        int len=1;
        for (int k=0;k<4;k++){
            int nc=j+delcol[k],nr=i+delrow[k];
            if(nc>=0&&nc<grid[0].length&&nr>=0&&nr< grid.length){
                if(!set.contains(grid[nr][nc])) {
                    set.add(grid[nr][nc]);
                    len+=map.get(grid[nr][nc]);

                }
            }
        }
        return len;
    }

    private static int DFS(int[][] grid,int color, int row, int col) {
        if(row<0||row>= grid.length||col<0||col>=grid[0].length||grid[row][col]!=1){
            return 0;
        }
       grid[row][col]=color;
        int len=1;
        len+=DFS(grid,color,row+1,col);
        len+=DFS(grid,color,row-1,col);
        len+=DFS(grid,color,row,col+1);
        len+=DFS(grid,color,row,col-1);
        return len;
    }

    private static int BFS(int[][] grid, int[] delrow, int[] delcol, int row, int col) {
        Queue<Duo> q = new LinkedList<>();
        q.add(new Duo(row,col));
        int count=0;
        int N = grid.length, M = grid[0].length;
        int[][] temp = new int[N][M];
        temp[row][col]=1;
        while(!q.isEmpty()){
            Duo u = q.poll();
            int r = u.first, c = u.sec;
            count++;
            for(int i=0;i<4;i++){
                int nr=r+delrow[i],nc=c+delcol[i];
                if (nr>=0&&nr<N&&nc>=0&&nc<M&&temp[nr][nc]==0&&grid[nr][nc]==1){
                    q.add(new Duo(nr,nc));
                    temp[nr][nc]=1;
                }
            }
        }
        return count;
    }

}

