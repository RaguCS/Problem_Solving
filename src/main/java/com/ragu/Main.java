package com.ragu;

import java.util.ArrayList;
import java.util.Scanner;
class Jodi{
    int fj,sj;
    public Jodi(int fj,int sj){
        this.fj=fj;
        this.sj=sj;
    }

}
public class Main {
    public static void main(String[] args) {
        char[][] grid = {{'a', 'h', 'd', 'm', 'g'},
                        {'s', 'f', 'w', 'e', 'q'},
                        {'b', 'c', 'e', 'x', 'f'},
                        {'h', 'z', 'd', 'f', 'y'},
                        {'n', 'l', 'y', 'e', 'g'}};
        String ax="Ragu";
        System.out.println(ax.hashCode());
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the word!: ");
        String str=sc.nextLine();
        int n= grid.length,m= grid[0].length;
        ArrayList<Pair> al=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                boolean[][] vis=new boolean[n][m];
                if(grid[i][j]==str.charAt(0)){
//                    diadfs(i,j,grid,str,0,al);
                    vhdfs(i,j,grid,str,0,al,vis);
                    if(al.size()<str.length())
                        al.clear();
                     else if(al.size()==str.length())
                        i=n;j=m;
                }
            }
        }
        for(Pair p:al) {
            int a=p.fp;
            int b=p.sp;
            System.out.println(a + " " + b);
        }
     


    }

    private static void vhdfs(int i, int j, char[][] grid, String str, int i1, ArrayList<Pair> al, boolean[][] vis) {
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||i1>=str.length()||grid[i][j]!=str.charAt(i1)|| vis[i][j]){
         return;
        }
        al.add(new Pair(i,j));
        vis[i][j]=true;
        vhdfs(i+1,j,grid,str,i1+1,al, vis);
        vhdfs(i-1,j,grid,str,i1+1,al, vis);
        vhdfs(i,j+1,grid,str,i1+1,al, vis);
        vhdfs(i,j-1,grid,str,i1+1,al, vis);
        vhdfs(i-1,j-1,grid,str,i1+1,al, vis);
        vhdfs(i+1,j-1,grid,str,i1+1,al, vis);
        vhdfs(i-1,j+1,grid,str,i1+1,al, vis);
        vhdfs(i+1,j+1,grid,str,i1+1,al, vis);
    }

    private static void diadfs(int i, int j, char[][] grid, String str, int i1, ArrayList<Pair> al) {

    }

}