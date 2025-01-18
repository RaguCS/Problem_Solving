package com.ragu.TicTacToe;

import java.util.LinkedList;
import java.util.Queue;

public class Player implements Players{
    private String playerName;
    private char symbol;
    Queue<int[]> coordinates;
    public Player(char symbol,String playerName) {
        this.playerName = playerName;
        this.symbol = symbol;
        coordinates = new LinkedList<int[]>();
    }
    @Override
    public char getSymbol() {
        return symbol;
    }

    @Override
    public void addQ(int[] ar) {
        coordinates.add(ar);
    }
    @Override
    public int[] remove(){
        return coordinates.remove();
    }

    @Override
    public int sizee() {
        return coordinates.size();
    }

    @Override
    public String getName() {
        return playerName;
    }
}
