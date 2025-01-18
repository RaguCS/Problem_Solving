package com.ragu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.SplittableRandom;

public class Sample {
    public static void main(String[] args) {

        System.out.println(addBinary("01","10"));
//        int[] arr={2,1,5,4,7,9,8};
//        String[] str1={"hello","world","some","thing"};
//        String[] str2={"world","thing","world"};
//        System.out.println(InterSection(str1,str2));
//        System.out.println(SecondLargest(arr));

    }public static String trim(String s){
    int firstOne = s.indexOf('1');
        return (firstOne == -1) ? "0"
            : s.substring(firstOne);
}
    public static String addBinary(String s1, String s2) {
        s1=trim(s1);
        s2=trim(s2);
        int n=s1.length();
        int m=s2.length();
        StringBuilder result = new StringBuilder();
        int carry = 0,j=m-1;
        if(n<m){
            return addBinary(s2,s1);
        }
        for (int i=n-1;i>=0;i--){
            int sum=s1.charAt(i)-'0';
            sum+=carry;
            if(j>=0){
                sum+=s2.charAt(j--)-'0';
            }
            result.append(sum%2);
            carry=sum/2;
        }
        if(carry>0)
            result.append(1);

        return result.reverse().toString();
    }
    public static int myAtoi(String s) {
        long val=0,sign=1;
        int i=0,n=s.length();
        while(i<n&&s.charAt(i)==' '){
            i++;
        }
        if(s.charAt(i)=='-'){
            sign=-1;
            i++;
        }

        while(i<n&&s.charAt(i)>='0'&&s.charAt(i)<='9'){
            val=(val*10)+s.charAt(i)-'0';
            if(val>=Integer.MAX_VALUE){
                return sign==-1?Integer.MIN_VALUE:Integer.MAX_VALUE;
            }
            i++;
        }
        return sign==-1?(int)(val*sign):(int) val;
    }
    public static int SecondLargest(int[] arr) {
        int n=arr.length;
        int[] a1=new int[(n/2)+1];
        int[] a2=new int[(n/2)+1];
        int i=0,j=0;
        for (int k=0;k<n;k++) {
            if(k%2==0){
                a1[i++]=arr[k];
            }else {
                a2[j++]=arr[k];
            }
        }
        Arrays.sort(a1);
        Arrays.sort(a2);
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));
        return a1[a1.length-2]+a2[a2.length-2];

    }
    public static ArrayList<String> InterSection(String[] arr1, String[] arr2){ 
        int n=arr1.length;
        int m=arr2.length;
        ArrayList<String> list=new ArrayList<>();
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if(arr1[i].equals(arr2[j])){
                    list.add(arr1[i]);
                    i++;
                    if(i>=n)
                        break;
                }
            }
        }
        return list;
    }
}
