package com.ragu.Train_Ticket_Book;

public class Booking {
    Ticket_Management ticketManagement=Ticket_Management.getInstance();
    public void BookTicket(int seat,char start,char end){
        if(ticketManagement.ticketsAvail(seat,start,end)){
           int pnr=ticketManagement.bookTickts(seat,start,end);
            System.out.println("your pnr is: "+pnr);
        } else if (ticketManagement.checkWaitingList()) {
            int pnr=ticketManagement.addtoWaitingList(seat,start,end);
            System.out.println("added to waiting list,pnr is: "+pnr);
        }else {
            System.out.println("No tickets available.");
        }
    }
    public void show(){
        ticketManagement.show();
    }
}
