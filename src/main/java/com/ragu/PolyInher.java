package com.ragu;

import java.util.ArrayList;

public class PolyInher extends PolyMor{
    public void play(){
        System.out.println("Playing main");
//        super.play();
    }
    public PolyInher(){
        super();
    }
    public static void main(String[] args) throws Exception {
//       Heaps<Integer> heaps=new Heaps<>();
//       heaps.insert(69);
//       heaps.insert(99);
//       heaps.insert(2);
//       heaps.insert(5);
//       heaps.insert(9);
//       heaps.insert(1);
//        System.out.println(heaps.getHeap());
//        System.out.println(heaps.remove());
//        System.out.println(heaps.getHeap());
//        System.out.println(heaps.remove());
//        System.out.println(heaps.getHeap());
//        System.out.println(heaps.remove());
//        System.out.println(heaps.getHeap());
//        System.out.println(heaps.remove());
        Debug debug = new Debug();
        String s="(aANDb(cNOTd))";
        if (debug.checkExp(s))
            System.out.println("Valid");
        else
            System.out.println("Not Valid");

    }
}
