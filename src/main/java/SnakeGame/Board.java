package SnakeGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
public class Board {
    static final int SIZE=8;
    static char[][] board=new char[SIZE][SIZE];
    static Queue<ArrayList<Integer>> snake=new LinkedList<>();
    static ArrayList<ArrayList<Integer>> Points =new ArrayList<>();
    static ArrayList<Integer> head;
    static {
       for(char[] c:board){
           Arrays.fill(c,'-');
       }
        ArrayList<Integer> temp=new ArrayList<>(){{add(0);add(0);}};
        snake.add(temp);
        head=temp;
        Points.add(new ArrayList<>(){{add(3);add(5);}});
        Points.add(new ArrayList<>(){{add(2);add(2);}});
        Points.add(new ArrayList<>(){{add(6);add(1);}});
        Points.add(new ArrayList<>(){{add(7);add(5);}});
        Points.add(new ArrayList<>(){{add(0);add(5);}});
        Points.add(new ArrayList<>(){{add(5);add(3);}});
        Points.add(new ArrayList<>(){{add(4);add(0);}});
        Points.add(new ArrayList<>(){{add(5);add(7);}});
        board[head.get(0)][head.get(1)]='@';
        for (ArrayList<Integer> p:Points){
            board[p.get(0)][p.get(1)]='#';
        }
    }
    public boolean Directions(char c){
        switch (c){
            case 'U':
                int rowu =head.get(0)-1;
                int colu =head.get(1);
                ArrayList<Integer> tempu =new ArrayList<>(){{add(rowu);add(colu);}};
                if(rowu >=0&&!snake.contains(tempu)){
                    if(Points.contains(tempu)){
                        moveWithPoint(rowu, colu);
                    }else {
                        moveWithoutPoint(rowu, colu);
                    }
                }else{
                    return false;
                }
                break;
            case 'D':
                int rowd =head.get(0)+1;
                int cold =head.get(1);
                ArrayList<Integer> tempd =new ArrayList<>(){{add(rowd);add(cold);}};
                if(rowd <SIZE&&!snake.contains(tempd)){
                    if(Points.contains(tempd)){
                        moveWithPoint(rowd, cold);
                    }else {
                        moveWithoutPoint(rowd, cold);
                    }
                }else{
                    return false;
                }
                break;
            case 'L' :
                int rowl =head.get(0);
                int coll =head.get(1)-1;
                ArrayList<Integer> templ =new ArrayList<>(){{add(rowl);add(coll);}};
                if(coll >=0&&!snake.contains(templ)){
                    if(Points.contains(templ)){
                        moveWithPoint(rowl, coll);
                    }else {
                        moveWithoutPoint(rowl, coll);
                    }
                }else{
                    return false;
                }
                break;
            case 'R':
                int rowr =head.get(0);
                int colr =head.get(1)+1;
                ArrayList<Integer> tempr =new ArrayList<>(){{add(rowr);add(colr);}};
                if(colr<SIZE&&!snake.contains(tempr)){
                    if(Points.contains(tempr)){
                        moveWithPoint(rowr, colr);
                    }else {
                        moveWithoutPoint(rowr, colr);
                    }
                }else{
                    return false;
                }
                break;
            default:
                System.out.println("Enter the Valid Direction");
                return false;
        }
//        board[head.get(0)][head.get(1)]='@';
        return true;
    }
    private static void moveWithPoint(int row,int col){
        ArrayList<Integer> temp=new ArrayList<>(){{add(row);add(col);}};
        head=temp;
        snake.add(temp);
        fillSnake();
        Points.remove(temp);

    }
    private static void moveWithoutPoint(int row,int col){
        ArrayList<Integer> temp=new ArrayList<>(){{add(row);add(col);}};
        head=temp;
        snake.add(temp);
        fillSnake();
        int delrow=snake.peek().get(0);
        int delcol=snake.poll().get(1);
        board[delrow][delcol]='-';

    }
    public static void fillSnake(){
        for(ArrayList<Integer> body:snake){
            if(body!=head){
                board[body.get(0)][body.get(1)]='*';
            }else {
                board[body.get(0)][body.get(1)]='@';
            }
        }
    }
    public void showBoard(){
        for(char[] c:board){
            System.out.println(Arrays.toString(c));
        }
    }
}
