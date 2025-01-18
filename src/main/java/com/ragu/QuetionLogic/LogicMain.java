package com.ragu.QuetionLogic;

import java.util.List;

public class LogicMain {
    public static void main(String[] args) {
        Logic logic=Logic.getInstance();
        List<Integer> quetions=logic.getQuetions(15);
        System.out.println(quetions);
        List<Integer> quet=logic.getQuetions(10);
        System.out.println(quet);
        logic.resetUsed(quet);
        List<Integer> quetion=logic.getQuetions(15);
        System.out.println(quetion);
    }
}
