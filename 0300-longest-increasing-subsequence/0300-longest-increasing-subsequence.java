class Solution {
    public int lengthOfLIS(int[] arr) {
        int n= arr.length;
        int[][] dp= new int[n][n+1];
        for(int [] k: dp){
            Arrays.fill(k,-1);
        }
        return fun(0, -1, arr, dp);

        
    }
    int fun(int id, int prev, int[] arr, int[][] dp){
        if(id==arr.length){return 0;}
        
            if(dp[id][prev+1]!= -1){
                return dp[id][prev+1];
            }
        
        int skip= fun(id+1, prev, arr, dp);
        int pick=0;
        
        if(prev==-1 || arr[id]> arr[prev]){
             pick= 1+ fun(id+1, id, arr, dp);
        }
        dp[id][prev+1]= Math.max(pick, skip);
        return dp[id][prev+1];
        

    }
}