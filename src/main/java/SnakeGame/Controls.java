package SnakeGame;

import java.util.Scanner;

public class Controls {
    public static void main(String[] args) {
        Board board=new Board();
        Scanner sc=new Scanner(System.in);
        String s;
        do{
            board.showBoard();
            System.out.println("Enter the Direction (U,D,L,R): ");
             s=sc.nextLine();
             if(s.isEmpty()){
                 System.out.println("Enter the valid String");
                 break;
             }
        }while (board.Directions(s.charAt(0)));
        System.out.println("Game Over");
    }

}