package com.ragu;

import java.util.*;

import static java.util.Random.from;

public class Debug {

   public int stocks(int[] prices){
       int buy = prices[0];
       int profit = 0;
       int totalProfit = 0;
       for(int i=1; i< prices.length;i++){
           if(prices[i] > buy){
               profit = prices[i] - buy;
               totalProfit += profit;
           }
           buy = prices[i];
       }
       return totalProfit;
   }
   public String Decod(String s){
       Stack<Integer> stNum = new Stack<>();
       Stack<StringBuilder> stStr = new Stack<>();

       StringBuilder currStr = new StringBuilder();
       int currNum = 0;
       for(char ch : s.toCharArray())
       {
           if(ch == '[')
           {
               stNum.push(currNum);
               stStr.push(currStr);
               currNum = 0;
               currStr = new StringBuilder();
           }
           else if(ch == ']')
           {
               int num = stNum.pop();
               StringBuilder prevStr = stStr.pop();
               String s1 = currStr.toString();
               currStr = prevStr.append(s1.repeat(num));
           }
           else if(ch >= '0' && ch <= '9')
               currNum = currNum * 10 + ((int)ch - 48);
           else
               currStr.append(ch);
       }
       return currStr.toString();
   }
   public int[] tempCheck(int[] temp){
       int[] arr = new int[temp.length];
       Stack<Integer> stNum = new Stack<>();
       for(int i=0; i<temp.length; i++){
           while (!stNum.isEmpty()&&temp[i]>temp[stNum.peek()]){
               int index = stNum.pop();
               arr[index]=i-index;
           }
           stNum.push(i);
       }
       return arr;
   }

    public static void main(String[] args) {
        Debug d=new Debug();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(6);
        pq.add(2);
        pq.add(3);
        pq.add(4);
        System.out.println(pq);
        int b=pq.poll();
//        int b=;
        System.out.println(b);
//        System.exit(0);
        LinkedList<String > list = new LinkedList<>();
        String hash="karthiga";
        System.out.println(hash.hashCode());
        System.exit(0);
        int[][]  grid={{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        String s="rr";
//        int[] arr=new int[]{};
        int[][] a={
                {1,2,3,4},
                {14,15,16,5},
                {13,20,17,6},
                {12,19,18,7},
                {11,10,9,8}
        };
//        d.sprial(a);
        System.out.println();
        Stack<Integer> stack=new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(s.repeat(3));
        int[] ar={60,70,56,45,66};
//        d.insertionSort(ar);
//        d.heapsort(ar);
        System.out.println(Arrays.toString(d.tempCheck(ar)));
        Random rand=new Random();
        int randNum=0;
        while (randNum!=6)
            randNum=rand.nextInt(6)+1;

        System.out.println(randNum);
//        System.out.println(d.canReachCorner(3,3,new int[][]{{1,1,2}}));
//        for(String l:d.findWords(new char[][]{{'a','b','c'},{'a','e','d'},{'a','f','g'}},new String[]{"dgc"})){
//            System.out.println(l);
//        }

    }
    public void heapsort(int[] arr){
        int n=arr.length;
        for (int i=n/2-1;i>=0;i--){
            heapify(arr,i,n);
        }
        for (int i=n-1;i>=0;i--){
            int temp=arr[i];
            arr[i]=arr[0];
            arr[0]=temp;
            heapify(arr,0,i);
        }
    }
    public void heapify(int[] arr,int i,int n){
        int largest=i;
        int left=2*i+1,right=2*i+2;
        if(left<n&&arr[left]>arr[largest]){
            largest=left;
        }
        if (right<n&&arr[right]>arr[largest]){
            largest=right;
        }
        if(largest!=i){
            int temp=arr[largest];
            arr[largest]=arr[i];
            arr[i]=temp;
            heapify(arr,largest,n);
        }
    }
    public void insertionSort(int[]a) {
        for(int i=0;i<a.length-1;i++){
            int j=i+1;
            while (j>0 && a[j-1] > a[j]){
                int temp=a[j];
                a[j]=a[j-1];
                a[j-1]=temp;
                j--;
            }
        }
    }
    

    public void sprial(int[][] mat){
        int top=0,right=mat.length,down=0,left=mat[0].length;
        while (top<right&&down<left){
        for (int i=top;i<left;i++){
            System.out.print(mat[down][i]+" ");
        }
        top+=1;
        for (int i=top;i<right;i++){
            System.out.print(mat[i][left-1]+" ");
        }
        left-=1;
        for (int i=left-1;i>=down;i--){
            System.out.print(mat[right-1][i]+" ");
        }
        right-=1;
        for (int i=right-1;i>=top;i--){
            System.out.print(mat[i][down]+" ");
        }
        down+=1;
        }
    }
    public boolean checkExp(String s){
       Stack<Character> stack=new Stack<>();
       List<Character> LOGICAL=new ArrayList<>();
       List<Character> Char=new ArrayList<>();
       for(int i=0;i<s.length();i++){
           char c=s.charAt(i);
           if(c=='A'){
               if(s.charAt(i+1)=='N'&&s.charAt(i+2)=='D'){
                   i=i+2;
                   LOGICAL.add(c);
               }else return false;
           } else if (c == 'O') {
               if(s.charAt(i+1)=='R'){
                   i=i+1;
                   LOGICAL.add(c);
               }else return false;
           } else if (c == 'N') {
               if(s.charAt(i+1)=='O'&&s.charAt(i+2)=='T'){
                   i=i+2;
                   LOGICAL.add(c);
               }else return false;
           } else if (c >= 'a' && c <= 'z') {
               Char.add(c);
           } else if (c=='(')  {
               stack.push(c);
           }else if(c==')'){
               if(stack.isEmpty()){
                   return false;
               }else stack.pop();
           }
       }
       return (LOGICAL.size()*2)==Char.size()&&stack.isEmpty();
    }
}
