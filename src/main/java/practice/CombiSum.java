package practice;

import java.util.ArrayList;
import java.util.List;

public class CombiSum {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> ans=new ArrayList<>();
    public static void main(String[] args) {
        CombiSum cs = new CombiSum();
        System.out.println(cs.FindSum(new int[]{2,3,6,7},7));

    }
    public List<List<Integer>> FindSum(int[] arr, int target) {

        combi(0, arr, target);
        return res;
    }
    public void combi(int indnex, int[] arr, int target) {
        if(target==0){
            res.add(new ArrayList<>(ans));
            return;
        }
        for (int i=indnex;i<arr.length;i++){
            if(arr[i]<=target){
                ans.add(arr[i]);
                combi(i,arr,target-arr[i]);
                ans.remove(ans.size()-1);
            }
        }
    }
}
