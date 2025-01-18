package com.ragu.Maze_Runner;

public class Runner {
    public static void main(String[] args) {
        Maze maze=new Maze(4,4);
        maze.putTreasureMaze(1,3);
        maze.putObstecles(1,1);
        maze.putObstecles(2,1);
        maze.putObstecles(2,2);
        System.out.println(maze.shortestPath(3,0));
        maze.printMaze();
        System.out.println();
    }
}
