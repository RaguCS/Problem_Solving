package practice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BfsAndDfs {
    public static void main(String[] args) {
        BfsAndDfs bfsAndDfs=new BfsAndDfs();
        int[][] grid={{0,0,0},{1,1,0},{1,1,0}};
        System.out.println(bfsAndDfs.shortestPath(grid));
    }

    public int shortestPath(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        if(grid[n-1][m-1]==1)return -1;
        int[][] visited = new int[n][m];
        for (int[] a:visited)
            Arrays.fill(a,-1);
        Queue<int[]> q = new LinkedList<>();
        visited[n-1][m-1] = 1;
        q.add(new int[]{n-1,m-1,1});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int row = cur[0];
            int col = cur[1];
            int val=cur[2];
            for (int i=-1;i<=1;i++){
                for (int j=-1;j<=1;j++){
                    int nr=row+i;
                    int nc=col+j;
                    if(nr>=0&&nr<n&&nc>=0&&nc<m&&visited[nr][nc]==-1&&grid[nr][nc]==0){
                        visited[nr][nc]=val+1;
                        q.add(new int[]{nr,nc,val+1});
                    }
                }
            }
        }

        return visited[0][0];
    }
}
