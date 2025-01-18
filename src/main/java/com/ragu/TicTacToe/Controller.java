package com.ragu.TicTacToe;

import java.util.Scanner;

public class Controller {
    PlayerMangement playerMangement=PlayerMangement.getInstance();
    Board board=Board.getInstance();
    Scanner scanner=new Scanner(System.in);
    public void createPlayer(char c,String name){
        playerMangement.createPlayer(c,name);
    }
    public boolean nextPlayer(){
        board.printBoard();
        Player player=playerMangement.getNextPlayer();
        System.out.println(player.getName()+"'s move");
        int row=scanner.nextInt();
        int col=scanner.nextInt();
        if(row<0||col<0||row>=3||col>=3)return false;
        if(board.isEmpty(row,col)){
            if(player.sizee()>=3){
                board.removeSymbol(player.remove());
            }
            player.addQ(new int[]{row,col});
            board.setSymbol(row,col,player.getSymbol());
            if(board.checkWinner(row,col,player.getSymbol())){
                System.out.println(player.getName()+" is wins this game");
                board.printBoard();
                return true;
            }
        }else
            System.out.println("Invalid move");

        return false;
    }
}
