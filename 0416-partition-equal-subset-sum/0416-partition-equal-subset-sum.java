class Solution {
    public boolean canPartition(int[] nums) {
        int n= nums.length;
        int t= 0;
        for(int i= 0;i<n ;i++){
        t= t + nums[i];
        }
        if(t%2!=0){
            return false;

        }
          t=t/2;
        int [][] dp= new int [n][t+1];

        for(int[] k: dp){
            Arrays.fill(k, -1);
        }

   return fun(n-1,t, nums, dp );   }

    boolean fun(int idx , int t, int [] arr, int[][] dp){

        if(idx == 0){
            
            return arr[0]==t;
        }
        if(dp[idx][t]!= -1){
            if(dp[idx][t]==1){return true;}
            return false;
        }



        boolean take = false;
       if(arr[idx]<= t){
         take = fun( idx-1, t- arr[idx], arr, dp);}
        boolean miss= fun( idx-1, t, arr, dp);
    
        if (take || miss){
            dp[idx][t]= 1;
        }
        else {
            dp[idx][t]= 0;
        }
        return take || miss;
    }
}