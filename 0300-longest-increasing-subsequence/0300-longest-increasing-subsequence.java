class Solution {
    public int lengthOfLIS(int[] arr) {
        int n= arr.length;
        int dp[]= new int[n];
        Arrays.fill(dp,1);
        for(int i=1; i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    dp[i]= Math.max(dp[j]+1, dp[i]);
                }
            }
        }

        int max=0;
        for(int i=0;i<n;i++){
            max= Math.max(max, dp[i]);
        }

        return max;

        
    }
}