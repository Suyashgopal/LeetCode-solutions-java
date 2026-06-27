class Solution {
    public int minimumTotal(List<List<Integer>> outer) {
        int r = outer.size();
        int c= r;
        int[][] dp = new int[r][c];
        for(int[] k: dp){
            Arrays.fill(k, -1);
        }
        int res= Integer.MAX_VALUE;
        for(int i=0;i< outer.size();i++){
           res= Math.min(res, fun(r-1, i, outer, dp));
        }

return res;
        
    }
    int fun(int r, int c,List<List<Integer>> outer, int[][] dp ){
        if(r==0){
            return outer.get(0).get(0);
        }
        if(r<0 || c<0 || (c> r)){
            return Integer.MAX_VALUE;


        }
        if(dp[r][c]!= -1){
            return dp[r][c];
        }
        int up= fun(r-1, c, outer, dp);
        int lup= fun(r-1, c-1, outer, dp);
        dp[r][c]= outer.get(r).get(c) + Math.min(up, lup);
        return dp[r][c];

    }
}
