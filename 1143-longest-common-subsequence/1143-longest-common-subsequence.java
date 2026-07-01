class Solution {
    public int longestCommonSubsequence(String t1, String t2) {
        int n= t1.length();
        int m= t2.length();
        int[][] dp= new int[n][m];
        for(int[] k: dp){
            Arrays.fill(k, -1);
        }

    return fun(n-1, m-1, t1, t2, dp);

        
    }
    int fun(int id1, int id2, String  s1, String s2, int[][] dp){
        if(id1<0 || id2<0){return 0;}
    
      if(dp[id1][id2]!=-1){
        return dp[id1][id2];
      }
      if(s1.charAt(id1)== s2.charAt(id2)){

        dp[id1][id2]= 1+ fun(id1-1, id2-1, s1, s2, dp);

       }
       else{
        dp[id1][id2]= Math.max(fun(id1-1, id2, s1, s2, dp), fun(id1, id2-1, s1, s2, dp));
       }
     return dp[id1][id2];


    }
}