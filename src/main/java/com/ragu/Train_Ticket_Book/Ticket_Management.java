package com.ragu.Train_Ticket_Book;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Ticket_Management {
private static Ticket_Management instance = null;
private int[] ticketcount=new int[5];
private int waitList=2;
public Ticket_Management(){
    Arrays.fill(ticketcount,8);
}
HashMap<Integer,Ticket> bookedTickets=new HashMap<>();
HashMap<Integer,Ticket> CancelledTickets=new HashMap<>();
ConcurrentHashMap<Integer,Integer> partiallyCancelled=new ConcurrentHashMap<>();
Queue<Ticket> wl=new LinkedList<>();


public boolean ticketsAvail(int seats,char start,char end){
    for(int i=start-'A';i<end-'A';i++){
        if(ticketcount[i]<seats)return false;
    }
    return true;
}
public int bookTickts(int seat,char start,char end){
    Ticket ticket=new Ticket(start,end,seat);
    bookedTickets.put(ticket.getPnr(),ticket);
    reduceTickets(seat,start,end);
    return ticket.getPnr();

}
public void reduceTickets(int seat,char start,char end){
    for (int i=start-'A';i<end-'A';i++){
        ticketcount[i]-=seat;
    }
}
public void increaceTickets(int seat,char start,char end){
    for (int i=start-'A';i<end-'A';i++){
        ticketcount[i]+=seat;
    }
}
public boolean checkWaitingList() {
    return waitList>0;
}
public int addtoWaitingList(int seat,char start,char end){
    Ticket ticket=new Ticket(start,end,seat);
    waitList--;
    wl.add(ticket);
    return ticket.getPnr();
}
public void checkwl(){
    if(!wl.isEmpty()){
        Ticket ticket=wl.peek();
        if(ticketsAvail(ticket.getSeat(),ticket.getStart(),ticket.getEnd())){
            wl.remove();
            bookedTickets.put(ticket.getPnr(),ticket);
            reduceTickets(ticket.getSeat(),ticket.getStart(),ticket.getEnd());
            System.out.println("Waiting List Ticket "+ticket.getPnr()+" has been booked!");
        }
    }
}
public void show(){
    System.out.println("Booked Tickets:");
    int i=1;
    for(int key:bookedTickets.keySet()){
        Ticket ticket=bookedTickets.get(key);
        System.out.println((i++)+".Pnr: "+ticket.getPnr()+", start: "+ticket.getStart()+", end: "+ticket.getEnd()+", seat: "+ticket.getSeat());    }
    System.out.println();
    i=1;
    System.out.println("Cancelled Tickets:");
    for(int key:CancelledTickets.keySet()){
        Ticket ticket=CancelledTickets.get(key);
        System.out.println((i++)+".Pnr: "+ticket.getPnr()+", start: "+ticket.getStart()+", end: "+ticket.getEnd()+", seat: "+ticket.getSeat());    }
    System.out.println();
    System.out.println("Waiting list:");
    i=1;
    Queue<Ticket> w=new LinkedList<>(wl);
    while (!w.isEmpty()){
        Ticket ticket=w.poll();
        System.out.println((i++)+".Pnr: "+ticket.getPnr()+", start: "+ticket.getStart()+", end: "+ticket.getEnd()+", seat: "+ticket.getSeat());
    }
    System.out.println();
    i=0;
    System.out.println("    1  2  3  4  5  6  7  8  ");
    for (int num:ticketcount){
        System.out.print((char) ('A'+i++)+"  ");
        for(int j=0;j<num;j++){
            System.out.print(" * ");
        }
        System.out.println();
    }
}

public static Ticket_Management getInstance() {
    if (instance == null) {
        instance = new Ticket_Management();
    }
    return instance;
}
}
