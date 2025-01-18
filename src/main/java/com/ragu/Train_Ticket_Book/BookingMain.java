package com.ragu.Train_Ticket_Book;

import java.util.Scanner;

public class BookingMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice=0;
        do{
            System.out.println("1.book/2.cancel/3.details/4.close");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    Booking booking = new Booking();
                    System.out.println("destinations: A , B , C , D , E , F . || MAX SEATS: 8\nenter start point: ");
                    String  start=sc.next();
                    System.out.println("enter the end point: ");
                    String end=sc.next();
                    System.out.println("enter the seat count: ");
                    int seat= sc.nextInt();
                    booking.BookTicket(seat,start.charAt(0),end.charAt(0));
                    break;
                case  2:
                    CancelBooking cancelBooking=new CancelBooking();
                    System.out.println("enter the pnr: ");
                    int pnr=sc.nextInt();
                    System.out.println("enter the seat count: ");
                    int seats= sc.nextInt();
                    cancelBooking.cancelBooking(pnr,seats);
                    break;
                case 3:
                    Booking book=new Booking();
                    book.show();
                    break;
            }

        }while (choice!=4);
    }
}
