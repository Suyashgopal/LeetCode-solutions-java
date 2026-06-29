class Solution {
    public boolean canPartition(int[] nums) {
        int n= nums.length;
        int s2= 0;
        for(int i= 0;i<n ;i++){
        s2= s2 + nums[i];
        }
        int [][] dp= new int [n][s2+1];

        for(int[] k: dp){
            Arrays.fill(k, -1);
        }

   return fun(n-1, 0,s2, nums, dp );   }

    boolean fun(int idx , int s1 , int s2, int [] arr, int[][] dp){

        if(idx == 0){
            if(s1==s2){
                return true;
            }
            return false;
        }
        if(dp[idx][s1]!= -1){
            if(dp[idx][s1]==1){return true;}
            return false;
        }



        
       
        boolean take = fun( idx-1, s1+ arr[idx], s2-arr[idx], arr, dp);
        boolean miss= fun( idx-1, s1, s2, arr, dp);
    
        if (take || miss){
            dp[idx][s1]= 1;
        }
        else {
            dp[idx][s1]= 0;
        }
        return take || miss;
    }
}