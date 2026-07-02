class Solution {
    public int numDistinct(String s, String t) {
        int n= s.length();
        int m = t.length();
        int [][] dp= new int [n+1][m+1];
        for(int[] k: dp){
            Arrays.fill(k, -1);
        }
        return fun(n-1, m-1, s, t, dp);

        
    }
    int fun(int i, int j, String s1, String s2, int[][] dp){
        if(i<0 || j<0){
            if(j>=0){
                return 0;
            }
            return 1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        if(s1.charAt(i) != s2.charAt(j)){
            return fun(i-1,j, s1, s2, dp);
        }
        int x=0;
        int y=0;

    if(s1.charAt(i) == s2.charAt(j)){
        x= fun(i-1, j-1, s1, s2, dp);
        y= fun(i-1, j, s1, s2, dp);
        }
        dp[i][j]= x+y;
        return dp[i][j];
    }
}