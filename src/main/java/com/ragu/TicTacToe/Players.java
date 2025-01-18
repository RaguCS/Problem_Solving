package com.ragu.TicTacToe;

import java.util.LinkedList;
import java.util.Queue;

public interface Players {
    public char getSymbol();
    public void addQ(int[] ar);
    public int[] remove();
    public int sizee();
    public String getName();

}
