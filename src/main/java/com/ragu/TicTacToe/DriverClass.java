package com.ragu.TicTacToe;

import java.util.Scanner;

public class DriverClass {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Controller controller=new Controller();
        for (int i=0;i<2;i++){
            System.out.println("Enter the Player "+(i+1)+" Name: ");
            String s=scanner.nextLine();
            System.out.println("Chose X or O");
            String c=scanner.nextLine();
            controller.createPlayer(c.charAt(0),s);
        }
        boolean b=false;
        do {
            b=controller.nextPlayer();
        }while (!b);
    }
}
