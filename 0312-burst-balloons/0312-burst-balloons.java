class Solution {
    public int maxCoins(int[] nums) {
        int n= nums.length;
    

        int[] arr= new int[n+2];
        
        arr[0]=1;
        arr[n+1]=1;
        for(int i=1; i<=n;i++){
            arr[i]= nums[i-1];

        }
        int[][] dp= new int[n+2][n+2];
        for(int[] k : dp){
            Arrays.fill(k,-1);

        }
    return fun(1, n, arr, dp);

    }
    int fun(int i, int j, int [] arr, int[][] dp){
        if(i>j){
            return 0;
        }
        int max=0;
    if(dp[i][j]!=-1){
        return dp[i][j];
    }

        for(int k=i;k<=j;k++){
            int m= arr[i-1]*arr[k]*arr[j+1]+ fun(i, k-1,arr, dp) + fun(k+1, j, arr, dp);
            max= Math.max(m, max);
        }
        dp[i][j]= max;
        return dp[i][j];
    }
}