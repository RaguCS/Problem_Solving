package com.ragu.Problems;
import java.util.*;
public class NQueens {
    public static List<List<String>> solveNQueens(int n) {
      List<List<String>> res=new ArrayList<>();
      char[][] board=new char[n][n];
      for(char[] b:board){
          Arrays.fill(b,'.');
      }
      solveQueenUtil(board,res,0,n);
      return res;
    }

    private static void solveQueenUtil(char[][] board, List<List<String>> res, int col, int N) {
        if(col>=N){
            res.add(construct(board));
        }
        for (int row=0;row<N;row++){
            if (isValids(board,row,col,N)){
                board[row][col]='Q';
                solveQueenUtil(board,res,col+1,N);
                board[row][col]='.';
            }
        }
    }

    private static boolean isValids(char[][] board, int row, int col, int N) {
        for (int i=0;i<col;i++){
            if(board[row][i]=='Q')
                return false;
        }

        for (int i=row,j=col;i>=0&&j>=0;i--,j--){
            if(board[i][j]=='Q')
                return false;
        }
        for (int i=row,j=col;i<N&&j>=0;i++,j--){
            if(board[i][j]=='Q')
                return false;
        }
        return true;

    }

    private static List<String> construct(char[][] board) {
        List<String> ans=new ArrayList<>();
        for (char[] b:board){
            String s="";
            for (char c:b){
                s+=c;
            }
            ans.add(s);
        }
        return ans;
    }
    List<List<String>> res = new ArrayList<>();
    int[] columns;
    Map<Integer, String> map = new HashMap<>();
    public List<List<String>> solveNQueenboardopti_0ms(int n) {
        columns = new int[n];
        char[] c = new char[n];
        Arrays.fill(c, '.');
        for (int i = 0; i < n; i++) {
            c[i] = 'Q';
            map.put(i, new String(c));
            c[i] = '.';
        }
        dfso(n, 0, 0, 0, 0);
        return res;
    }

    private void dfso(int n, int row, int col1, int di1, int di2) {
        if (row == n) {
            List<String> t = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                t.add(map.get(columns[i]));
            }
            res.add(t);
            return;
        }
        int availablePositions = ((1 << n) - 1) & (~(col1 | di1 | di2));
        while (availablePositions != 0) {
            int position = availablePositions & (-availablePositions);
            availablePositions = availablePositions & (availablePositions - 1);
            int col = Integer.bitCount(position - 1);
            columns[row] = col;
            dfs(n, row + 1, col1 | position, (di1 | position) << 1, (di2 | position) >> 1);
        }
    }

    public static void main(String[] args) {
//        for (List<String> s:solveNQueens(4)){
//            System.out.println(s);
//        }
        System.out.println(totalNQueens(4));
    }

        static int count = 0;
        public static int totalNQueens(int n) {
            int[] cols = new int[n];
            int[] d1 = new int[2 * n];
            int[] d2 = new int[2 * n];
            dfs(n, cols, d1, d2, 0);
            return count;
        }
        private static void dfs(int n, int[] cols, int[] d1, int[] d2, int row) {
            if (row == n) {
                count++;
                return;
            }
            for (int j = 0; j < n; j++) {
                if (cols[j] == 1 || d1[row + j] == 1 || d2[n - row + j] == 1)
                    continue;
                cols[j] = 1;
                d1[row + j] = 1;
                d2[n - row + j] = 1;
                dfs(n, cols, d1, d2, row + 1);
                d2[n - row + j] = 0;
                d1[row + j] = 0;
                cols[j] = 0;
            }
        }
    List<List<String>> reso = new ArrayList<>();
    int[] columnso;
    Map<Integer, String> mapo = new HashMap<>();

    public List<List<String>> solveNQueenoptimal(int n) {
        columnso = new int[n];
        char[] c = new char[n];
        Arrays.fill(c, '.');
        for (int i = 0; i < n; i++) {
            c[i] = 'Q';
            mapo.put(i, new String(c));
            c[i] = '.';
        }
        dfs(n, 0, 0, 0, 0);
        return reso;
    }

    private void dfs(int n, int row, int col1, int di1, int di2) {
        if (row == n) {
            List<String> t = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                t.add(mapo.get(columnso[i]));
            }
            reso.add(t);
            return;
        }
        int availablePositions = ((1 << n) - 1) & (~(col1 | di1 | di2));
        while (availablePositions != 0) {
            int position = availablePositions & (-availablePositions);
            availablePositions = availablePositions & (availablePositions - 1);
            int col = Integer.bitCount(position - 1);
            columnso[row] = col;
            dfs(n, row + 1, col1 | position, (di1 | position) << 1, (di2 | position) >> 1);
        }
    }

}
