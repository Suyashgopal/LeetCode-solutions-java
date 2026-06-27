class Solution {
    public int rob(int[] nums) {

  int n= nums.length;
  int [] dp= new int [n];
  Arrays.fill(dp, -1);
  dp[0]= nums[0];

   
 int a=   fun(n-1, nums, dp);
 int b= fun(n-2, nums, dp);
        return Math.max(a,b);
    }
   
    int fun(int idx, int[] nums, int dp[]){
        if(idx<0){return 0;}
      
       if(idx==0){
      
         return dp[idx];} 
     
       if( dp[idx]!=-1){return dp[idx];}
       
      int  left = fun(idx-2, nums, dp)+ nums[idx];
       

       
       int  right = fun(idx-3, nums, dp)+ nums[idx];
       

       dp[idx]= Math.max(left, right);
       return dp[idx];
       
    }
}