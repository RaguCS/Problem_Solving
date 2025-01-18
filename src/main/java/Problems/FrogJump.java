package Problems;

import java.util.*;

public class FrogJump {
    public int findMinimalJump(int[] arr) {
        //space optimized O(1);
        int prev1 = 0, prev2 = 0;
        for (int i = 1; i < arr.length; i++) {
            int left = prev1 + Math.abs(arr[i] - arr[i - 1]);
            int right = Integer.MAX_VALUE;
            if (i > 1)
                right = prev2 + Math.abs(arr[i] - arr[i - 2]);
            int cur = Math.min(left, right);
            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;

//        int[] dp=new int[arr.length+1];
//        //tabulation;
//        dp[0]=0;
//        for (int i=1;i<arr.length;i++){
//            int left=dp[i-1]+Math.abs(arr[i]-arr[i-1]);
//            int right=Integer.MAX_VALUE;
//            if(i>1)right=dp[i-2]+Math.abs(arr[i]-arr[i-2]);
//            dp[i]=Math.min(right,left);
//        }
//        return dp[arr.length-1];
//        Arrays.fill(dp,-1);
////        dp[0]=0;
//        return find(arr.length-1,arr,dp);

    }

    //memoization
    private int find(int n, int[] arr, int[] dp) {
        if (n == 0) return 0;
        if (dp[n] != -1) return dp[n];
        int right = Integer.MAX_VALUE;
        int left = find(n - 1, arr, dp) + Math.abs(arr[n] - arr[n - 1]);
        if (n > 1) right = find(n - 2, arr, dp) + Math.abs(arr[n] - arr[n - 2]);

        return dp[n] = Math.min(right, left);

    }

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = {2, 0, 0};
        FrogJump fj = new FrogJump();
        int[][] grid= {{3,1,1},{2,5,1},{1,5,5},{2,1,1}};
        System.out.println(fj.solve(grid.length,grid[0].length,grid));

    }

    private int solve(int n, int m, int[][] grid) {
int[][][] dp=new int[n][m][m];
return finMax(0,0,m-1,grid,dp);
    }

    private int finMax(int i, int j1, int j2, int[][] grid, int[][][] dp) {
            if(j1<0||j2<0||j2>=grid[0].length||j1>=grid[0].length)return (int)-1e8;
            if(i==grid.length-1){
                if(j1==j2)return grid[i][j2];
                else return grid[i][j1]+grid[i][j2];
            }
            if (dp[i][j1][j2]!=0)return dp[i][j1][j2];
            int max=(int)-1e8;
            for (int d1=-1;d1<=1;d1++){
                for(int d2=-1;d2<=1;d2++){
                    if(j1==j2){
                        max=Math.max(max,grid[i][j2]+finMax(i+1,j1+d1,j2+d2,grid, dp));
                    }else
                        max=Math.max(max,(grid[i][j2]+grid[i][j1]+finMax(i+1,j1+d1,j2+d2,grid, dp)));
                }
            }
            return dp[i][j1][j2]=max;
    }

    public int frogJumpWithKDistance(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return findmin(n,arr,k,dp);
    }

    private int findmin(int n, int[] arr, int k, int[] dp) {
        if(n == 0) return 0;
        if(dp[n] != -1) return dp[n];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            if(n-i>=0) {
                int min1 = findmin(n - i, arr, k, dp) +Math.abs(arr[n]-arr[n-i]);
                min = Math.min(min,min1);
            }

        }
        return dp[n]=min;
    }
}
