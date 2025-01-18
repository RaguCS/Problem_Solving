package com.ragu;

import java.util.*;

public class Count_Smaller_Elements {
    public static ArrayList<String>  subSeq(String a, String b) {
        if(b.isEmpty()){
            ArrayList<String> res=new ArrayList<>();
//            if(!a.isEmpty())
                res.add(a);

            return res;
        }
        char c=b.charAt(0);
        ArrayList<String> right=subSeq(a,b.substring(1));
        ArrayList<String> left=subSeq(a+c,b.substring(1));
        right.addAll(left);
        return right;
    }
    public static List<List<Integer>> subSet(int[] arr){
        List<List<Integer>> outer= new ArrayList<>();
        outer.add(new ArrayList<>());
        for (int a:arr){
            int n=outer.size();
            for (int i=0;i<n;i++){
                List<Integer> internal=new ArrayList<>(outer.get(i));
                internal.add(a);
                outer.add(internal);
            }
        }
        return outer;
    }
    public static List<List<Integer>> subSetDuplicate(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> outer= new ArrayList<>();
        outer.add(new ArrayList<>());
        int start=0;
        int end=0;
        for(int i=0;i<nums.length;i++){
            start=0;
            if(i>0&&nums[i]==nums[i-1]){
                start=end+1;
            }
            end=outer.size()-1;
            int n=outer.size();
            for(int j=start;j<n;j++){
                List<Integer> internal=new ArrayList<>(outer.get(j));
                internal.add(nums[i]);
                outer.add(internal);
            }
        }
        return outer;
    }
    public static int PermuCount(String p,String up){
        if(up.isEmpty()){
            return 1;
        }
        int count=0;
        char ch=up.charAt(0);
        for (int i=0;i<=p.length();i++){
            String first=p.substring(0,i);
            String second=p.substring(i);
            count+=PermuCount(first+ch+second,up.substring(1));
        }
        return count;
    }
    public static List<String> Permu(String p,String up){
        if(up.isEmpty()){
            List<String> ans=new ArrayList<>();
            ans.add(p);
            return ans;
        }
        char ch=up.charAt(0);
        List<String> all=new ArrayList<>();
        for (int i=0;i<=p.length();i++){
            String first=p.substring(0,i);
            String second=p.substring(i);
            List<String> temp=Permu(first+ch+second,up.substring(1));
            all.addAll(temp);
        }
        return all;
    }
    public static List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            List<String> res=new ArrayList<>();
            return res;
        }
        String[] arr={"","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        return helper("",digits,arr);
    }

    private static List<String> helper(String s, String digits, String[] arr) {
        if(digits.isEmpty()){
            List<String> res=new ArrayList<>();
            res.add(s);
            return res;
        }
        List<String> res=new ArrayList<>();
        int digit=(digits.charAt(0)-'0');
        for(char ch:arr[digit].toCharArray()){
            res.addAll(helper(s+ch,digits.substring(1), arr));
        }
        return res;
    }
    public static int count(int row,int col){
        if(row==1||col==1){
            return 1;
        }
        int left=count(row-1,col);
        int right=count(row,col-1);
        return right+left;
    }
    public static void path(String p,int row,int col){
        if(row==1&&col==1){
            System.out.println(p);
            return;
        }
        if(row>1)
            path(p+"D",row-1,col);
        if(col>1)
            path(p+"R",row,col-1);
    }

    public static void main(String[] args) {
//        int[] arr={1};
//        int [] ar=Arrays.copyOfRange(arr,1, arr.length);
//        System.out.println(Arrays.toString(ar));
        System.out.println(Integer.compare(2,1));
        String s="";
        
//        path("",3,3);
//        System.out.println(count(5,5));
//        System.out.println(subSeq("","abc"));
//        System.out.println(PermuCount("","ragu"));
//        System.out.println(letterCombinations("89"));
//        for(List<Integer> num:subSetDuplicate(new int[]{2,4,6})){
//            System.out.println(num);
//        }
//        ArrayList<String> res=subSeq("","abcd");

//        System.out.println(res);
//        int[] arr = {12, 1, 2, 3, 0, 11, 4};
//        System.out.println(Arrays.toString(constructLowerArray(arr)));
    }
    public static int binarySearch(List<Integer> v, int x) {
        int l = 0, h = v.size() - 1, mid;
        while (l <= h) {
            mid = (l + h) / 2;
            if (v.get(mid) == x) return mid;
            else if (v.get(mid) > x) h = mid - 1;
            else l = mid + 1;
        }
        return -1;
    }

    public static int[] constructLowerArray(int[] arr) {
        List<Integer> v = new ArrayList<>();
        for (int num : arr) {
            v.add(num);
        }
        Collections.sort(v);

        int[] t = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int max = binarySearch(v, arr[i]);
            while (max > 0 && v.get(max - 1).equals(v.get(max))) {
                max--;
            }
            t[i] = max;
            v.remove(max);
        }
        return t;
    }
}
