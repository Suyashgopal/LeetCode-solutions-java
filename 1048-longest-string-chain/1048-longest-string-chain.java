class Solution {
    public int longestStrChain(String[] arr) {
        int n= arr.length;

        Arrays.sort(arr, Comparator.comparingInt(String::length));

        int[] dp= new int [n];
        
        int max=1;
        Arrays.fill(dp, 1);
        for(int i=1;i<n;i++){
            for(int j=0; j<i;j++){
                String s1= arr[j];
                String s2= arr[i];
                int k= s1.length();
                int l= s2.length();
            int diff= l-k;
                if(diff==1 && issubseq(k-1,l-1,s1,s2)){
                    dp[i]= Math.max(dp[i], dp[j]+1);
                    max= Math.max(max, dp[i]);
                }
            }
        }
        return max;

    }
    boolean issubseq(int i, int j, String s1, String s2){
        if(i<0 || j<0){
            if(i<0 && j<0){return true;}
            if(i<0){return true;}
            return false;
        }
        boolean pick = false;
        if(s1.charAt(i)== s2.charAt(j)){
        pick= issubseq(i-1, j-1, s1,s2);
        }
        boolean skip= issubseq(i, j-1, s1,s2);
        return skip|| pick;
        
    }
}