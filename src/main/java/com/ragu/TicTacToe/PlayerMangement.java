package com.ragu.TicTacToe;

import java.util.LinkedList;
import java.util.Queue;

public class PlayerMangement {
    private static PlayerMangement playerMangement=null;
    public static PlayerMangement getInstance(){
        if (playerMangement==null){
            playerMangement=new PlayerMangement();
        }
        return playerMangement;
    }
    private PlayerMangement(){

    }
    Queue<Player> players=new LinkedList<Player>();
    private final int playersize=2;
    private boolean addIntoQ(Player player){
        if (players.size()<=playersize) {
            players.add(player);
            return true;
        }
        else
            return false;
    }
    public void createPlayer(char c,String name){
        if(c=='X'||c=='O'){
            if(addIntoQ(new Player(c,name))){
                System.out.println("Player "+name+" added");
            }else
                System.out.println("Player limit reached");
        }else
            System.out.println("Invalid symbol");
    }
    public Player getNextPlayer(){
        if (players.size()==playersize) {
            Player player = players.poll();
            players.add(player);
            return player;
        }else
            return null;
    }
}
