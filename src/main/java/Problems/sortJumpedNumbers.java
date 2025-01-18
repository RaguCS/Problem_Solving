package Problems;

import java.util.*;

public class sortJumpedNumbers {
    public static int[] sortJumbled(int[] mapping, int[] nums) {
        int n=nums.length;
        int[][] mapped=new int[n][2];
        for(int i=0;i<n;i++){
            int Val=nums[i],newVal=Val==0?mapping[0]:0,placeValue=1;
            while(Val>0){
                int digit=Val%10;
                newVal+=placeValue*mapping[digit];
                placeValue*=10;
                Val/=10;
            }
            mapped[i]=new int[]{newVal,i};
        }
        Arrays.sort(mapped, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[] ans=new int[n];
        for (int i=0;i<n;i++){
            ans[i]=nums[mapped[i][1]];
        }
        return ans;
    }

    public static void main(String[] args) {
    int[]  mapping = {8,9,4,0,2,1,3,5,7,6},nums = {991,338,38};
//        System.out.println(Arrays.toString(sortJumbled(mapping,nums)));
//        int[][] mat = {{1, 0},
//            {1, 0}};
//        System.out.println(findPath(mat));
        int[] num={1,2,3};

    }
    public static ArrayList<String> findPath(int[][] mat) {
        boolean[][] visited=new boolean[mat.length][mat[0].length];
        ArrayList<String> ans=helpe("",0,0,mat,visited);
        if(ans.isEmpty()){
            ans.add("-1");
        }
        return ans;
    }

    private static ArrayList<String> helpe(String p, int row, int col, int[][] mat, boolean[][] visited) {
        if(row==mat.length-1&&col==mat[0].length-1){
            ArrayList<String> temp=new ArrayList<>();
            temp.add(p);
            return temp;
        }
        visited[row][col]=true;
        ArrayList<String> ans=new ArrayList<>();
        if(row>0&&!visited[row-1][col]&&mat[row-1][col]==1){
           ans.addAll(helpe(p+"U",row-1,col,mat,visited));
        }
        if(col>0&&!visited[row][col-1]&&mat[row][col-1]==1){
           ans.addAll(helpe(p+"L",row,col-1,mat,visited));
        }
        if(col<mat[0].length-1&&!visited[row][col+1]&&mat[row][col+1]==1){
            ans.addAll(helpe(p+"R",row,col+1,mat,visited));
        }
        if(row<mat.length-1&&!visited[row+1][col]&&mat[row+1][col]==1){
            ans.addAll(helpe(p+"D",row+1,col,mat,visited));
        }
        visited[row][col]=false;
        return ans;
    }
}
