package com.ragu.Maze_Runner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int x;
    int y;
    int val;
    public Pair(int x,int y,int val){
        this.x=x;
        this.y=y;
        this.val=val;
    }
}
public class Maze{
    private int[][] maze;
    private Pair TreasureLocation;
    public Maze(int width, int height) {
        maze = new int[width][height];
    }
    public void putTreasureMaze(int x, int y) {
        TreasureLocation=new Pair(x,y,0);
    }
    private void calculatePath(){
        int[][] visited=new int[maze.length][maze[0].length];
        Queue<Pair> q=new LinkedList<>();
        q.add(TreasureLocation);
        visited[TreasureLocation.x][TreasureLocation.y]=1;
        int[] arr1={-1,0,1,0};
        int[] arr2={0,-1,0,1};
        while (!q.isEmpty()){
            int r=q.peek().x;
            int c=q.peek().y;
            int val=q.poll().val;
            for(int i=0;i<4;i++){
                    int nr=r+arr1[i];
                    int nc=c+arr2[i];
                    if(nr>=0&&nc>=0&&nr<maze.length&&nc<maze[0].length&&visited[nr][nc]==0&&maze[nr][nc]!=-1){
                            visited[nr][nc] = 1;
                            maze[nr][nc] = val + 1;
                            q.add(new Pair(nr, nc, val + 1));
                    }
            }
        }
    }
    public int shortestPath(int x,int y){
        calculatePath();
        return maze[x][y]<=0?-1:maze[x][y];
    }
    public void putObstecles(int x,int y){
        maze[x][y]=-1;
    }
    public void printMaze(){
        for(int[] m:maze){
            System.out.println(Arrays.toString(m));
        }

    }
}
