package com.ragu.QuetionLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Logic {
    private static Logic instance=null;
    private Random random=new Random();
    public static Logic getInstance(){
        if(instance==null){
            instance=new Logic();
        }
        return instance;
    }
    List<Integer> quetions;
    List<Boolean> used;
    private Logic() {
        quetions = new ArrayList<Integer>();
        used = new ArrayList<>();
        addValues();
    }
    private void addValues() {
        for (int i = 1; i <=100 ; i++) {
            quetions.add(i);
            used.add(false);
        }
    }
    public List<Integer> getQuetions(int count) {
        List<Integer> ans=new ArrayList<>();
        while (count!=0){
            int randomNumber=random.nextInt(quetions.size())+1;
            if(!used.get(randomNumber)){
                ans.add(quetions.get(randomNumber));
                count--;
                used.set(randomNumber,true);
            }
        }
        return ans;
    }
    public void resetUsed(List<Integer> wrong) {
        for(int number:wrong){
            used.set(number-1,false);
        }
    }
}
