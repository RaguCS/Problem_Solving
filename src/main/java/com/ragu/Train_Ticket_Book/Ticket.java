package com.ragu.Train_Ticket_Book;

public class Ticket {
    private static int pnrgen=1;
    private int pnr;
    private char start;
    private char end;
    private int seat;

    public Ticket( char start, char end, int seat) {
        this.pnr = pnrgen++;
        this.start = start;
        this.end = end;
        this.seat = seat;
    }

    public int getPnr() {
        return pnr;
    }

    public char getStart() {
        return start;
    }

    public void setStart(char start) {
        this.start = start;
    }

    public char getEnd() {
        return end;
    }

    public void setEnd(char end) {
        this.end = end;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }
}
