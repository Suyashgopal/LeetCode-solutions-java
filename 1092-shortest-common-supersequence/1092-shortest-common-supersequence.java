class Solution {
    public String shortestCommonSupersequence(String s1, String s2) {


        int n= s1.length();
        int m= s2.length();
        int[][] dp= new int[n+1][m+1];
     
        for(int i=0;i<n;i++){ dp[i][0]=0;}
        for(int i=0;i<m;i++){dp[0][i]=0;}

        for(int i=1;i<=n;i++){
        for(int j=1;j<=m;j++){
          if(s1.charAt(i-1)== s2.charAt(j-1)){
                dp[i][j]= 1+ dp[i-1][j-1];}
                 else{
        dp[i][j]= Math.max(dp[i-1][j], dp[i][j-1]);
                 }}}

StringBuilder sb= new StringBuilder();

  int i1=n;
  int j1= m;

       while(i1>0 && j1>0){
        if(s1.charAt(i1-1)== s2.charAt(j1-1)){
          sb.append(s1.charAt(i1-1));
           i1--; 
           j1--;
        }
        else if(dp[i1-1][j1]>dp[i1][j1-1]){
             sb.append(s1.charAt(i1-1));
            i1--;
        }
        else{
            sb.append(s2.charAt(j1-1));
            j1--;
        }

       }
while(i1>0){
    sb.append(s1.charAt(i1-1));
    i1--;
}

while(j1>0){
    sb.append(s2.charAt(j1-1));
    j1--;
}




    return sb.reverse().toString();

        
    }
    
}

