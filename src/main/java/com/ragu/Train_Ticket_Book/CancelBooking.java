package com.ragu.Train_Ticket_Book;

public class CancelBooking {
    public void cancelBooking(int pnr,int seats) {
        Ticket_Management tM=Ticket_Management.getInstance();
        Ticket ct=tM.bookedTickets.get(pnr);
        if(ct!=null) {
            if(seats<ct.getSeat()){
                ct.setSeat(ct.getSeat()-seats);
                tM.increaceTickets(seats, ct.getStart(), ct.getEnd());
                tM.partiallyCancelled.put(pnr,seats);

            }else {
                if(tM.partiallyCancelled.containsKey(pnr)){
                    ct.setSeat(tM.partiallyCancelled.get(pnr)+ct.getSeat());
                    tM.partiallyCancelled.remove(pnr);

                }
                tM.increaceTickets(ct.getSeat(), ct.getStart(), ct.getEnd());
                tM.bookedTickets.remove(pnr);
                tM.CancelledTickets.put(pnr, ct);

            }
            tM.checkwl();

        }else {
            System.out.println("Ticket does not exist");
        }

    }
}
