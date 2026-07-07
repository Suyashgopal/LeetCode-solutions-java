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
                if(diff==1 && issubseq(s1,s2)){
                    dp[i]= Math.max(dp[i], dp[j]+1);
                    max= Math.max(max, dp[i]);
                }
            }
        }
        return max;

    }
    boolean issubseq( String s1, String s2){
        int i=0;
        int j=0;
        while(i<s1.length() && j<s2.length()){
            if(s1.charAt(i)==s2.charAt(j)){
                i++;
                j++;
            }
            else{
  j++;
            }
          

        }
        return i==s1.length();
        
    }
}