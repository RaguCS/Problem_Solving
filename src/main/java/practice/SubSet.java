package practice;

import java.util.ArrayList;
import java.util.List;

public class SubSet {
    List<List<Integer>> res=new ArrayList<>();
    List<Integer> ans=new ArrayList<>();
    public static void main(String[] args) {
        SubSet s=new SubSet();
        System.out.println(s.subsetsWithDup(new int[]{1,2,3,4}));
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
       helper(nums,0,nums.length);
        return res;
    }
    public void helper(int[] nums,int index,int N) {
        if(index==N) {
            res.add(new ArrayList<>(ans));
            return;
        }
        helper(nums,index+1,N);
        ans.add(nums[index]);
        helper(nums,index+1,N);
        ans.remove(ans.size()-1);
    }
}
