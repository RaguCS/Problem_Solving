package com.ragu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class A{
    static String name;
}
public class SubString {
    public static void main(String[] args) {
        A a1=new A();
        A a2=new A();
        a1.name="ragu";
        System.out.println(a2.name);


        System.exit(0);

        SubString subString=new SubString();
        List<List<Integer>> res =new ArrayList<>();
        int[] arrr={5,4,7,8};
        subString.combi(arrr,0,new ArrayList<>(),res);
        System.out.println(res);

        System.exit(0);
        String s="tsahirahisvtthisvbkdjjbtihas";
        String r="this";
        List<String> list=subString.findAllSubstrings(s, r);
        Collections.sort(list,(x,y)->x.length()-y.length());
        System.out.println(list);
    }
    public List<String> findAllSubstrings(String s1,String s2) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < s1.length(); i++) {
            for (int j = i+1; j <= s1.length(); j++) {
                if(checksub(s1,i,j,s2))
                    list.add(s1.substring(i, j));
            }
        }
        return list;
    }

    private boolean checksub(String s1, int start, int end,String s2) {
        int[] hash=new int[26];
        for (int i=start;i<end;i++){
            char c=s1.charAt(i);
            hash[c-'a']++;
        }
        for (int i=0;i<s2.length();i++){
            char c=s2.charAt(i);
            if(hash[c-'a']==0)
                return false;
            else
                hash[c-'a']--;
        }
        return true;
    }


    public void combi(int[] arr,int i,List<Integer> ans,List<List<Integer>> res){
        if(i>=arr.length){
            res.add(new ArrayList<>(ans));
            return;
        }
        combi(arr,i+1,ans,res);
        ans.add(arr[i]);
        combi(arr,i+1,ans,res);
        ans.remove(ans.size()-1);

    }
}
