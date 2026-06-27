class Solution {
    public int rob(int[] nums) {
        
      int n= nums.length;
      if(n==1){return nums[0];}
      int[] dp= new int[n];
      Arrays.fill(dp, -1);
      

      int a= fun(n-1, nums, 1, dp);
       Arrays.fill(dp, -1);
      int b= fun(n-2, nums, 0, dp);
      return Math.max(a,b);
   

        
    }
    int fun(int idx, int [] nums, int st , int[] dp){
        if(idx<st){return 0;}
        if(idx==st){
            return nums[st];

        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int left= fun(idx-2, nums,st, dp) + nums[idx];
        int right = fun(idx-1, nums,st, dp);
        dp[idx]= Math.max(left, right);
        return dp[idx];
    }
}