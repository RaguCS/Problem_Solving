package com.ragu.TicTacToe;

import java.util.Arrays;

public class Board {
    PlayerMangement playerMangement=PlayerMangement.getInstance();
    private final char[][] board;
    private static Board instance = null;
    private Board() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            Arrays.fill(board[i], '.');
        }
    }
    public static Board getInstance() {
        if (instance == null) {
            instance = new Board();
        }
        return instance;
    }
    public boolean isEmpty(int row, int col) {
        return board[row][col] == '.';
    }
    public void setSymbol(int row, int col, char symbol) {
        board[row][col] = symbol;
    }
    public boolean checkWinner(int row, int col, char symbol) {
        for(int x=0;x<3;x++){
            for (int y=0;y<3;y++){
                if(board[x][y]==symbol) {
                    for (int i = -1; i <= 1; i++) {
                        for (int j = -1; j <= 1; j++) {
                            if (i != 0||j!=0) {
                                if(check(x,y,symbol,i,j,0))
                                    return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    public void removeSymbol(int[] cordinates){
        int row=cordinates[0];
        int col=cordinates[1];
        board[row][col]='.';
    }
    private boolean check(int row,int col,char symbol,int rowInc,int colInc,int count){
        if (count>=3)return true;
        if(row<0||col<0||row>=3||col>=3||board[row][col]!=symbol)
            return false;
        return check(row+rowInc,col+colInc,symbol,rowInc,colInc,count+1);

    }

    public void printBoard() {
        System.out.println(Arrays.toString(board[0]));
        System.out.println(Arrays.toString(board[1]));
        System.out.println(Arrays.toString(board[2]));
    }
}
